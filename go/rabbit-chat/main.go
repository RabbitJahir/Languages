package main

import (
	"bufio"
	"fmt"
	"math/rand"
	"net"
	"os"
	"sort"
	"strings"
	"sync"
	"time"
)

const (
	defaultPort   = "5000"
	discoveryPort = 5001
	maxName       = 20
	maxLine       = 4096

	reset     = "\033[0m"
	hostColor = "\033[1;97m" // bold bright white, reserved for Host
)

// Bright 256-color codes. White/grey/black deliberately excluded.
var palette = []int{
	196, 202, 208, 214, 220, 118, 82, 46, 48, 51,
	45, 39, 33, 63, 93, 129, 165, 201, 205, 213,
}

type client struct {
	conn  net.Conn // nil for the host
	name  string
	color string
	out   chan string
}

func (c *client) send(msg string) {
	select {
	case c.out <- msg:
	default:
	}
}

func (c *client) tag() string { return c.color + c.name + reset }

var (
	mu      sync.RWMutex
	clients = make(map[string]*client) // key: lowercase name
)

func ts() string { return time.Now().Format("15:04") }

// sanitize strips control characters so users can't inject ANSI escapes.
func sanitize(s string) string {
	return strings.Map(func(r rune) rune {
		if r < 32 || r == 127 {
			return -1
		}
		return r
	}, s)
}

// pickColor returns a random color not yet in use (falls back to any). Caller holds mu.
func pickColor() string {
	used := map[string]bool{}
	for _, c := range clients {
		used[c.color] = true
	}
	var free []string
	for _, n := range palette {
		code := fmt.Sprintf("\033[1;38;5;%dm", n)
		if !used[code] {
			free = append(free, code)
		}
	}
	if len(free) == 0 {
		return fmt.Sprintf("\033[1;38;5;%dm", palette[rand.Intn(len(palette))])
	}
	return free[rand.Intn(len(free))]
}

func broadcast(msg string, except *client) {
	mu.RLock()
	defer mu.RUnlock()
	for _, c := range clients {
		if c != except {
			c.send(msg)
		}
	}
}

func userList() string {
	mu.RLock()
	defer mu.RUnlock()
	cs := make([]*client, 0, len(clients))
	for _, c := range clients {
		cs = append(cs, c)
	}
	sort.Slice(cs, func(i, j int) bool { return strings.ToLower(cs[i].name) < strings.ToLower(cs[j].name) })
	tags := make([]string, len(cs))
	for i, c := range cs {
		tags[i] = c.tag()
	}
	return fmt.Sprintf("Online (%d): %s", len(cs), strings.Join(tags, ", "))
}

func dm(from *client, targetName, text string) {
	mu.RLock()
	target, ok := clients[strings.ToLower(targetName)]
	mu.RUnlock()
	if !ok {
		from.send("No such user: " + targetName)
		return
	}
	target.send(fmt.Sprintf("[%s] (private) %s: %s", ts(), from.tag(), text))
	from.send(fmt.Sprintf("[%s] (to %s) %s", ts(), target.tag(), text))
}

func handleClient(conn net.Conn) {
	defer conn.Close()

	sc := bufio.NewScanner(conn)
	sc.Buffer(make([]byte, 0, 1024), maxLine)

	c := &client{conn: conn, out: make(chan string, 64)}

	for {
		fmt.Fprintln(conn, "Enter your name:")
		if !sc.Scan() {
			return
		}
		name := strings.TrimSpace(sc.Text())
		if name == "" || len(name) > maxName || strings.ContainsAny(name, " \t/") || name != sanitize(name) {
			fmt.Fprintf(conn, "Invalid name (1-%d chars, no spaces or '/').\n", maxName)
			continue
		}
		key := strings.ToLower(name)
		mu.Lock()
		if _, taken := clients[key]; taken {
			mu.Unlock()
			fmt.Fprintln(conn, "Name already taken.")
			continue
		}
		c.name = name
		c.color = pickColor()
		clients[key] = c
		mu.Unlock()
		break
	}

	done := make(chan struct{})
	go func() {
		w := bufio.NewWriter(conn)
		for {
			select {
			case m := <-c.out:
				w.WriteString(m + "\n")
				w.Flush()
			case <-done:
				return
			}
		}
	}()

	defer func() {
		close(done)
		mu.Lock()
		delete(clients, strings.ToLower(c.name))
		mu.Unlock()
		broadcast(fmt.Sprintf("[%s] *** %s left ***", ts(), c.tag()), nil)
	}()

	c.send("Welcome! Commands: /list  /msg <name> <text>  /quit  /help")
	c.send(userList())
	broadcast(fmt.Sprintf("[%s] *** %s joined (%s) ***", ts(), c.tag(), conn.RemoteAddr()), c)

	for sc.Scan() {
		line := sanitize(strings.TrimSpace(sc.Text()))
		if line == "" {
			continue
		}

		if strings.HasPrefix(line, "/") {
			parts := strings.SplitN(line, " ", 3)
			switch strings.ToLower(parts[0]) {
			case "/quit", "/exit":
				return
			case "/list":
				c.send(userList())
			case "/help":
				c.send("Commands: /list  /msg <name> <text>  /quit  /help")
			case "/msg":
				if len(parts) < 3 {
					c.send("Usage: /msg <name> <text>")
					continue
				}
				dm(c, parts[1], parts[2])
			default:
				c.send("Unknown command. /help")
			}
			continue
		}

		broadcast(fmt.Sprintf("[%s] %s: %s", ts(), c.tag(), line), c)
	}
}

func localIPs() []string {
	var ips []string
	addrs, _ := net.InterfaceAddrs()
	for _, a := range addrs {
		if ipn, ok := a.(*net.IPNet); ok && !ipn.IP.IsLoopback() && ipn.IP.To4() != nil {
			ips = append(ips, ipn.IP.String())
		}
	}
	return ips
}

func discoveryResponder(port string) {
	pc, err := net.ListenPacket("udp4", fmt.Sprintf(":%d", discoveryPort))
	if err != nil {
		fmt.Println("Discovery disabled:", err)
		return
	}
	defer pc.Close()
	buf := make([]byte, 64)
	for {
		n, addr, err := pc.ReadFrom(buf)
		if err != nil {
			return
		}
		if string(buf[:n]) == "RABBIT_DISCOVER" {
			pc.WriteTo([]byte("RABBIT_HERE:"+port), addr)
		}
	}
}

func discover() (string, error) {
	pc, err := net.ListenPacket("udp4", ":0")
	if err != nil {
		return "", err
	}
	defer pc.Close()

	dst := &net.UDPAddr{IP: net.IPv4bcast, Port: discoveryPort}
	if _, err := pc.WriteTo([]byte("RABBIT_DISCOVER"), dst); err != nil {
		return "", err
	}
	pc.SetReadDeadline(time.Now().Add(3 * time.Second))

	buf := make([]byte, 64)
	n, addr, err := pc.ReadFrom(buf)
	if err != nil {
		return "", fmt.Errorf("no host found on this network")
	}
	msg := string(buf[:n])
	if !strings.HasPrefix(msg, "RABBIT_HERE:") {
		return "", fmt.Errorf("bad discovery reply")
	}
	port := strings.TrimPrefix(msg, "RABBIT_HERE:")
	return net.JoinHostPort(addr.(*net.UDPAddr).IP.String(), port), nil
}

func host(port string) {
	ln, err := net.Listen("tcp", ":"+port)
	if err != nil {
		fmt.Println("Could not start server:", err)
		return
	}
	defer ln.Close()

	// Host is a first-class participant, always white, name reserved.
	hc := &client{name: "Host", color: hostColor, out: make(chan string, 128)}
	mu.Lock()
	clients["host"] = hc
	mu.Unlock()

	go discoveryResponder(port)

	fmt.Println("=== RABBIT CHAT HOST ===")
	for _, ip := range localIPs() {
		fmt.Printf("  join %s:%s\n", ip, port)
	}
	fmt.Println("Type to chat. Commands: /list  /msg <name> <text>  /kick <name>  /quit")
	fmt.Println()

	// Everything addressed to the host is printed here.
	go func() {
		for m := range hc.out {
			fmt.Printf("\r\033[K%s\n> ", m)
		}
	}()

	go func() {
		for {
			conn, err := ln.Accept()
			if err != nil {
				return
			}
			go handleClient(conn)
		}
	}()

	in := bufio.NewScanner(os.Stdin)
	in.Buffer(make([]byte, 0, 1024), maxLine)
	fmt.Print("> ")
	for in.Scan() {
		line := sanitize(strings.TrimSpace(in.Text()))
		if line == "" {
			fmt.Print("> ")
			continue
		}

		if strings.HasPrefix(line, "/") {
			parts := strings.SplitN(line, " ", 3)
			switch strings.ToLower(parts[0]) {
			case "/quit", "/exit":
				broadcast(fmt.Sprintf("[%s] *** Host closed the server ***", ts()), hc)
				time.Sleep(300 * time.Millisecond)
				return
			case "/list":
				hc.send(userList())
			case "/msg":
				if len(parts) < 3 {
					hc.send("Usage: /msg <name> <text>")
				} else {
					dm(hc, parts[1], parts[2])
				}
			case "/kick":
				if len(parts) < 2 {
					hc.send("Usage: /kick <name>")
					break
				}
				mu.RLock()
				t, ok := clients[strings.ToLower(parts[1])]
				mu.RUnlock()
				switch {
				case !ok:
					hc.send("No such user: " + parts[1])
				case t == hc:
					hc.send("Can't kick yourself.")
				default:
					t.send("*** You were kicked by Host ***")
					time.Sleep(100 * time.Millisecond)
					t.conn.Close()
				}
			default:
				hc.send("Commands: /list  /msg <name> <text>  /kick <name>  /quit")
			}
			fmt.Print("> ")
			continue
		}

		broadcast(fmt.Sprintf("[%s] %s: %s", ts(), hc.tag(), line), hc)
		fmt.Print("> ")
	}
}

func join(addr string) {
	if addr == "" {
		fmt.Println("Searching LAN for host...")
		var err error
		addr, err = discover()
		if err != nil {
			fmt.Println(err)
			fmt.Println("Try: rabbit-chat join <ip>:5000")
			return
		}
	} else if !strings.Contains(addr, ":") {
		addr = net.JoinHostPort(addr, defaultPort)
	}

	conn, err := net.DialTimeout("tcp", addr, 5*time.Second)
	if err != nil {
		fmt.Println("Could not connect:", err)
		return
	}
	defer conn.Close()
	fmt.Println("Connected to", addr)

	done := make(chan struct{})

	go func() {
		sc := bufio.NewScanner(conn)
		sc.Buffer(make([]byte, 0, 1024), maxLine)
		for sc.Scan() {
			fmt.Printf("\r\033[K%s\n> ", sc.Text())
		}
		fmt.Println("\r\033[KDisconnected.")
		close(done)
	}()

	go func() {
		in := bufio.NewScanner(os.Stdin)
		in.Buffer(make([]byte, 0, 1024), maxLine)
		for in.Scan() {
			line := strings.TrimSpace(in.Text())
			if line != "" {
				fmt.Fprintln(conn, line)
			}
			fmt.Print("> ")
		}
		conn.Close()
	}()

	<-done
}

func usage() {
	fmt.Println("Rabbit Chat (works fully offline on a LAN)")
	fmt.Println()
	fmt.Println("  rabbit-chat host [port]")
	fmt.Println("  rabbit-chat join                  (auto-discover host)")
	fmt.Println("  rabbit-chat join <ip>[:port]")
}

func main() {
	rand.Seed(time.Now().UnixNano())
	if len(os.Args) < 2 {
		usage()
		return
	}
	switch os.Args[1] {
	case "host":
		port := defaultPort
		if len(os.Args) > 2 {
			port = os.Args[2]
		}
		host(port)
	case "join":
		addr := ""
		if len(os.Args) > 2 {
			addr = os.Args[2]
		}
		join(addr)
	default:
		usage()
	}
}
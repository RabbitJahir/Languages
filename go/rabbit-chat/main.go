package main

import (
	"bufio"
	"fmt"
	"net"
	"os"
	"strings"
	"sync"
)

var (
	clients = make(map[net.Conn]string)
	mu      sync.Mutex
)

func broadcast(message string, sender net.Conn) {
	mu.Lock()
	defer mu.Unlock()

	for conn := range clients {
		if conn != sender {
			fmt.Fprintln(conn, message)
		}
	}
}

func handleClient(conn net.Conn) {
	defer conn.Close()

	reader := bufio.NewReader(conn)

	fmt.Fprint(conn, "Enter your name: ")

	name, err := reader.ReadString('\n')
	if err != nil {
		return
	}

	name = strings.TrimSpace(name)

	mu.Lock()
	clients[conn] = name
	mu.Unlock()

	fmt.Printf("%s joined the chat\n", name)

	broadcast(fmt.Sprintf("*** %s joined the chat ***", name), conn)

	for {
		message, err := reader.ReadString('\n')

		if err != nil {
			break
		}

		message = strings.TrimSpace(message)

		if message == "" {
			continue
		}

		fmt.Printf("%s: %s\n", name, message)

		broadcast(
			fmt.Sprintf("%s: %s", name, message),
			conn,
		)
	}

	mu.Lock()
	delete(clients, conn)
	mu.Unlock()

	fmt.Printf("%s disconnected\n", name)

	broadcast(
		fmt.Sprintf("*** %s left the chat ***", name),
		conn,
	)
}

func host() {
	listener, err := net.Listen("tcp", ":5000")

	if err != nil {
		fmt.Println("Could not start server:", err)
		return
	}

	defer listener.Close()

	fmt.Println("================================")
	fmt.Println("       RABBIT CHAT HOST")
	fmt.Println("================================")
	fmt.Println()
	fmt.Println("Server running on port 5000")
	fmt.Println("Waiting for players...")
	fmt.Println()

	for {
		conn, err := listener.Accept()

		if err != nil {
			fmt.Println("Connection error:", err)
			continue
		}

		fmt.Println("New connection:", conn.RemoteAddr())

		go handleClient(conn)
	}
}

func join(address string) {
	conn, err := net.Dial("tcp", address)

	if err != nil {
		fmt.Println("Could not connect:", err)
		return
	}

	defer conn.Close()

	fmt.Println("Connected to", address)
	fmt.Println()

	// Receive messages from server.
	go func() {
		reader := bufio.NewReader(conn)

		for {
			message, err := reader.ReadString('\n')

			if err != nil {
				fmt.Println("\nDisconnected from server.")
				os.Exit(0)
			}

			fmt.Print("\r" + message)
			fmt.Print("You: ")
		}
	}()

	reader := bufio.NewReader(os.Stdin)

	for {
		fmt.Print("You: ")

		message, err := reader.ReadString('\n')

		if err != nil {
			return
		}

		fmt.Fprintln(conn, strings.TrimSpace(message))
	}
}

func main() {
	if len(os.Args) < 2 {
		fmt.Println("Rabbit Chat")
		fmt.Println()
		fmt.Println("Usage:")
		fmt.Println("  rabbit-chat host")
		fmt.Println("  rabbit-chat join <server-ip>:5000")
		return
	}

	switch os.Args[1] {

	case "host":
		host()

	case "join":
		if len(os.Args) < 3 {
			fmt.Println("Please provide the server address.")
			fmt.Println("Example:")
			fmt.Println("  rabbit-chat join 192.168.1.10:5000")
			return
		}

		join(os.Args[2])

	default:
		fmt.Println("Unknown command.")
	}
}

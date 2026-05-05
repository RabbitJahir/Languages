package main

import (
	"fmt"
	"net/http"
	_ "net/http/pprof"
)

func Check(currentUser, password string) bool {
	mainPassword := "123456"
	user := "Rabbit"

	return password == mainPassword && currentUser == user
}

func main() {

	// Start pprof server in background
	go func() {
		fmt.Println("pprof running on http://localhost:6060/debug/pprof/")
		http.ListenAndServe("localhost:6060", nil)
	}()

	var currentUser, password string

	fmt.Print("Enter Username: ")
	fmt.Scan(&currentUser)

	fmt.Print("Enter password: ")
	fmt.Scan(&password)

	ok := Check(currentUser, password)

	if ok {
		fmt.Println("Welcome", currentUser)
	} else {
		fmt.Println("Invalid user or/and invalid password")
	}

	// keep program alive so pprof works
	select {}
}
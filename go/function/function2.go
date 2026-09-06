package main

import "fmt"

func Users(user, section string) {
	fmt.Println(user + ": " + section)
}

func main(){

	user1, user2, user3 := "one", "two", "three"
	section := "A"
	
	Users(user1, section)
	Users(user2, section)
	Users(user3, section)
	
}

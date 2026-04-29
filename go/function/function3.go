package main

import (
	"fmt"
)

func Check(currentUser, password string) bool{
	mainPassword := "123456"
	user := "Rabbit"

	if(password == mainPassword && currentUser == user){
		return true;
	} else{
		return false
	}

}

func main(){

	var currentUser, password string

	fmt.Print("Enter Username: ")
	fmt.Scan(&currentUser)

	fmt.Print("Enter password: ")
	fmt.Scan(&password)
	ok := Check(currentUser, password)
	if ok {
		fmt.Println("Welcome ", currentUser)
	} else {
		fmt.Println("Invalid user or/and invalid password")
	}
}

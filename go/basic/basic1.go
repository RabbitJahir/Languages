package main

import "fmt"

func main(){
	number := 5

	if number%2==0 {
		fmt.Printf("%d is Even", number)
	} else {
		fmt.Printf("%d is odd", number)
	}
}

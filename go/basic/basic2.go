package main

import (
	"fmt"
	// "bufio"
	// "os"
)

func main(){
	

	var name string
	fmt.Print("Enter only one word, otherwise rest will drift away to the 2nd input: ")
	fmt.Scanf("%s", &name)

	fmt.Printf("name is %v\n", name)
//-------------------------------------------
	// reader := bufio.NewReader(os.Stdin)

	// fmt.Print("Enter full name: ")

	// fullName, _ := reader.ReadString('\n')

	// fmt.Printf("Full name is: %v", fullName)


}
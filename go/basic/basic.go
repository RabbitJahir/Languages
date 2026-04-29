package main;

import "fmt"

func main(){

	var name string = "string"
	name1, name2, number1, number2 := "literally", " anything ", 56, 67.8

	fmt.Println("yolo")
	fmt.Printf("Yoooo %v\n", "go is wackeed")
	fmt.Printf("printing name %s\n", name)
	fmt.Println(name1, name2, number1, number2)

	const try = "Const need no colon"
	const try1 = 56.7

	msg := fmt.Sprintf("Putting print in a varaible and %s also %f", try, try1)

	fmt.Println(msg)
}
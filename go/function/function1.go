package main

import "fmt"

func add(x int, y int) int{
	return x+y
}

func main(){

	fmt.Print("ENter two numbers with space between them: ")
	num1, num2 := 0,0
	fmt.Scan(&num1, &num2)
	fmt.Println(add(num1, num2))
}
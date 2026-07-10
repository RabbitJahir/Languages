/*

Hoisting means: JavaScript moves variable and function declarations to the top of their scope before execution.

It does NOT move the code physically.
It happens during the memory creation phase of execution.

*/

/*

Every time JS runs a script or function, it creates an Execution Context with two phases:

1. Memory Creation Phase
2. Code Execution Phase

During memory phase:

1. Variables are allocated memory
2. Functions are stored completely

This is why hoisting happens.

*/

//------------------------------------------------------------------------------Hoisting_with_var

console.log(a);  //undefined
var a = 10; 

//Internally JS sees this in memory creation phase
var a;
console.log(a);


//a is hoisted, But initialized with undefined

//------------------------------------------------------------------------------Hoisting_with_let_const

console.log(b); //ReferenceError
let b = 20;

//Because let and const are hoisted BUT: They are placed in something called the Temporal Dead Zone (TDZ).

// TDZ: They exist in memory but cannot be accessed before initialization.

//TDZ = The time between: Variable hoisted And variable initialized

//------------------------------------------------------------------------------Function_Hoisting

sayHello();

function sayHello() {
  console.log("Hello");
}

//Functions are fully hoisted. Because entire function definition is stored in memory.

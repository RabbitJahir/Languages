// Scope determines: Where a variable can be accessed in your code.
// Scope = visibility area of a variable

/*
There are mainly 3 types:

1. Global Scope
2. Function Scope
3. Block Scope
*/

//-----------------------------------------------------------------------------------Global_Scope

//A variable declared outside any function or block belongs to the global scope.
let name = "Rabbit";

function greet() {
  console.log(name);
}

greet(); // Rabbit

//Here: name is global, It can be accessed anywhere

//--------------------------------------------------------------------------------------Function_Scope


//Variables declared inside a function are only accessible inside that function.
function test() {
  let age = 20;
  console.log(age);
}

test();       // 20
console.log(age); //  Error

//age exists only inside test().

//------------------------------------------------------------------------------Block_Scope

//Block scope means variables exist only inside { }.
if (true) {
  let x = 10;
  const y = 20;
}

console.log(x); //  Error
console.log(y); // Error

//let and const are block-scoped.

if (true) {
  var z = 50;
}

console.log(z); // 50

//var is function-scoped.

//------------------------------------------------------------------------Lexical_Scope


//determined by where the function is written, not where it is called.
let a = 10;

function outer() {
  let b = 20;

  function inner() {
    console.log(a); // 10
    console.log(b); // 20
  }

  inner();
}

outer();

//inner() can access: Its own scope, Outer function scope, Global scope 

//This chain is called the Scope Chain.










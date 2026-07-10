//Shadowing happens when a variable declared inside a scope (like a function or block) has the same name as a variable in an outer scope.

//----------------------------------------------------------------------Example_1-Basic_Shadowing/Function_Shadowing

let name = "Rabbit";

function greet() {
  let name = "Tiger";
  console.log(name);
}

greet();           //Tiger     
console.log(name); //Rabbit

//The inner name inside greet() shadows the outer name.
//Inside the function → "Tiger"
//Outside the function → "Rabbit"

//-------------------------------------------------------------------------------Example_2-Block_Scope_Shadowing

let age = 20;

if (true) {
  let age = 25;
  console.log(age); // 25
}

console.log(age); // 20

//let is block-scoped, the inner age shadows the outer one.

//-------------------------------------------------------------------------------Example_3-Var_VS_Let

var a = 10;

{
  var a = 20;
}

console.log(a); // 20

//no real shadowing happens because var is function-scoped, not block-scoped

let a = 10;

{
  let a = 20;
}

console.log(a); // 10

//proper shadowing

let a = 10;

{
  var a = 20; 
}

console.log(a);  //  Error
//Illegal Shadowing
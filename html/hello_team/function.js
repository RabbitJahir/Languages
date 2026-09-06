/*---------------------------------
function main(a, b){
  const n = a+b;
  console.log(n);
}

main(2, 4);
*/

// Call Stack: where execution contexts are kept
// LIFO (Last-In, First-Out)

/*--------------------------------------
const user = function main(a, b){
  const n = a+b;
  console.log(n);
}

user(5, 5);
*/

/*------------------------------------------
console.log((function(){
  console.log("hello");
})())

// Anonymous has no name, used for one time calling.

const user = function (){
  const a = 100;
  console.log(a);
}

console.log(user())
*/

/*--------------------------------------------
//First Class / Secondary 
function user(){
  console.log("User");
}

function rabbit(fun){
  console.log(fun);
}

rabbit(user);

console.log("123");
*/

/*---------------------------------------------
function user(name, callback){
  console.log(`hi ${name}`);
  callback();
}

function bye(){
  console.log("bye");
}

user("abir", bye); //bye goes in callback parameter in user, then jumps to bye function
*/

/*-----------------------------------------------

//arrow function
const user = name => "hello " + name;
console.log(user("rabbit"));

//function statement
function user1(name){
  return `hello ${name}`;
}

console.log(user1("Hitler"));
*/

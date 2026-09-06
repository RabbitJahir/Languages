/*
A closure is a function bundled together with its lexical environment.

That means:
When a function is created, it remembers the variables from where it was written.

Not where it is called.
But where it was defined.

closures are created when function is defined
*/

//------------------------------------------------------------------------Basic_Closure
function outer() {
  let count = 0;

  function inner() {
    count = count + 1; 
    //scope er jonne bhitorer 1 saved thakbe, jodio bayre theke 0 asteshe, bhitore count = 1, so count = 1+1
    console.log(count);
  }

  return inner;
}

const counter = outer();
counter(); // 1
counter(); // 2

//outer() runs, first execution context, returns 1.
//runs again, second execution context, but now there is 1 inside innner(), closure, returns 2

//-------------------------------------------------------------------------------------Data_Privacy

function bankAccount() {
  let balance = 1000;

  return {
    deposit(amount) {
      balance = balance + amount; //first balance er value ta saved thakbe bhitorei
      console.log(balance);
    }
  }
}

const account = bankAccount();
account.deposit(500); // 1500

// cannot access balance directly. It’s private. Because of closure.

//-----------------------------------------------------------------------------------
function deposit(balance, amount) {
  return balance + amount;
}

let newBalance = deposit(1000, 500);
console.log(newBalance); // 1500

let newDeposit = (balance, amount) => console.log(`using arrow function, ${balance + amount}\n`);
newDeposit(500, 500);

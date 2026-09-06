function withdraw(balance, amount) {
  if (amount > balance) {
    return "Not enough money";
  }
  return balance - amount;
}

console.log(withdraw(1000, 200)); // 800

// arrow function
let newWithdraw = (balance, amount)=>{
    (amount>balance)? console.log(`Not enough balance, current balance is ${balance}`):console.log(`current balance is ${balance-amount}`)
}
newWithdraw(2000, 3000)
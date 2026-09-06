// searching or filtering, 

let nums = [1, 2, 3, 4, 5];

let even = nums.filter(n => n % 2 === 0);

console.log(even);

let vars = [1, 5.5, "rabbit", "wakanda", 300, "rabbit"]

let find = vars.filter(n => n === "rabbit")

console.log(find)

// find is for finding only once, returns the first match

let users = ["rabbit", "john", "alex", "john"];

let result = users.find(u => u === "john");

console.log(result);
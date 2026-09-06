let users= ["alfred", "shrek", "dyno"]

users.push("putin");

console.log(users); // [ 'alfred', 'shrek', 'dyno', 'putin' ]

users.pop(); // remove last

users.unshift("jackson"); // add to start

console.log(users); // [ 'jackson', 'alfred', 'shrek', 'dyno' ]

users.shift(); // remove first
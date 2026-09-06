let users = ["one", "two", "three", "four", "five"];

console.log(users.length);

// simple loop
for (let i = 0; i < users.length; i++) {
  console.log(users[i]);
}

// advanced loop
users.forEach((user) => {
  console.log(user);
});

//arrow function
users.forEach((u) => console.log("advanced array :${u}"));

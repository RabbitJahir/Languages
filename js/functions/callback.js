function greet(name, callback) {
  console.log("Hello " + name);
  callback();
}

greet("rabbit", () => {
  console.log("Done!");
});
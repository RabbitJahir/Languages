void main() {
  // key, value
  Map<String, String> fruits = Map();
  fruits["apple"] = "red";
  fruits["banana"] = "yellow";
  fruits["watermelon"] = "green";

  fruits.containsKey("apple");
  print("\n");

  print(fruits["apple"]);
  print("\n");

  for (String printKey in fruits.keys) {
    print("fruits: $printKey");
  }
  print("\n");

  for (String value in fruits.values) {
    print("colors: $value");
  }
  print("\n");

  fruits.update("apple", (value) => "green");

  fruits.forEach((key, value) => print("fruits: $key, color: $value"));
}

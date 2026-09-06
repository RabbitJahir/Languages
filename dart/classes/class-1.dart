void main() {
  // new is optional in dart
  var student1 = Students();
  const name = "name";
  const id = 12;

  student1.info(name, id);
}

class Students {
  void info(name, id) {
    print("$name and $id");
  }

  void study() {}
  void code() {}
  void eat() {}
  void sleep() {}
}

void main() {
  Dog bobby = Dog();

  bobby.info("bobby", "popcorn", "black");
}

class animal {
  String? color;
  String? name;

  void info(name, food, color) {
    print("Dog eats $food");
    print("$name\'s color is $color");
  }
}

class Dog extends animal {
  String? breed;
  void dogBreed(name, food, color) {
    super.info(name, food, color);

  }
}

class cat extends animal {
  void meow() {}
  void play_ball() {}
}

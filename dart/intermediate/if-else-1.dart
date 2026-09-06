void main() {
  voter(23);

  max maxFind = new max();

  maxFind.max2(2, 5);
  maxFind.max3(5, 7, 3);

  check currentUser = new check();

  currentUser.lists("HIM");
}

class voter {
  voter(age) {
    if (age >= 18) {
      print("Can vote");
    } else {
      print("Can not vote");
    }
  }
}

class max {
  max2(a, b) {
    (a > b) ? print("$a is bigger thn $b") : print("$b is greter than $a");
  }

  max3(a, b, c) {
    (a > b && a > c)
        ? print("$a is greater than &b & $c")
        : (b > c)
        ? print("$b is greater than $a & $c")
        : print("$c is greater than $a & $b");
  }
}

class check {

  // array only for strings
  List<String> users = ["him", "her"];

  // .contains return true or false
  lists(currentUser) {
    users.contains(currentUser.toLowerCase())? print("Welcome ${currentUser}"): print("User not found");
  }
}

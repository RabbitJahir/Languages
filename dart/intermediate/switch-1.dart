void main() {
  String grade = "A";

  switch (grade) {
    case "A":
      print("A");
    case "B":
      print("B");
    default:
      print("WTF");
  }

  // arrow function switch can not be used on its own. =>, commonly known as fat arrow in dart

  int day_number = 3;

  String day = switch (day_number) {
    1 => "Sun",
    2 => "Mon",
    3 => "Tues",
    4 => "Wednes",
    5 => "Thurs",
    6 => "Fri",
    7 => "Sat",
    _ => "No ",
  };
  print("${day}day");

  print(switch (day_number) {
    1 => "Sun",
    2 => "Mon",
    3 => "Tues",
    4 => "Wednes",
    5 => "Thurs",
    6 => "Fri",
    7 => "Sat",
    _ => "No ",
  });
}

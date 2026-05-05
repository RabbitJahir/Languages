import "dart:io";

void main() {
  // with stdout, the cursor is on the same line.
  stdout.write("enter name: ");
  // String?, ? means the string can be null, readLineSync waits for users to press enter.
  // Sync is synchronous, the program pauses and waits for enter button '\n'
  String? name = stdin.readLineSync();

  stdout.write("Enter age: ");
  // int.tryParse, converts string to int. the ! says, this wont be null
  int? age = int.tryParse(stdin.readLineSync()!);

  stdout.write("Enter cgpa: ");
  double? cgpa = double.tryParse(stdin.readLineSync()!);

  print("\nName : $name");
  print("Age  : $age");
  print("CGPA : $cgpa");

  // dart inputs does not know numbers, the inputs from keyboards are stored as strings, encoded using UNICODE
}

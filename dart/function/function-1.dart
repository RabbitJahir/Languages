import 'dart:io';
import 'dart:math';

void main() {
  area Area = new area();

  stdout.write("Enter radius: ");
  double? radius = double.tryParse(stdin.readLineSync()!);

  Area.circle(radius);

  print("\n\nEnter three values, press enter after each: ");
  double? a = double.tryParse(stdin.readLineSync()!);
  double? b = double.tryParse(stdin.readLineSync()!);
  double? c = double.tryParse(stdin.readLineSync()!);
  average(a, b, c);
}

class area {
  circle(radius) {
    // .toStringAsFixed(2) = 2 decimal places
    // .toStringAsPrecision(4) = 4 total digits, 123.6
    print("$pi x $radius = ${(radius * radius * pi).toStringAsFixed(2)}");
  }
}

// =>, fat arrow, writing functions that has a single expression/ line/ logic/ statement,   shorter code
void average(a, b, c) => print(
  "The average of $a, $b, $c = ${((a + b + c) / 3).toStringAsFixed(3)}",
);

// required parameters, the number of parameters and arguements has to be equal

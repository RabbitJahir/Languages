import 'dart:io';

void main() {
  stdout.write("Enter amount to deposit: ");
  int? deposit = int.tryParse(stdin.readLineSync()!);
  // try catch, otherwise, exceptions will print, but nerver a good practice. 
  //catch (e), its job is to catch whats throw(n)
  try {
    logic.depositMoney(deposit);
  } catch (e) {
    print(e);
  }
}

// Exception is build in dart:core, for custom exception handling
class exceptions implements Exception {
  String depositError() {
    return "Can not enter negative amounts.";
  }
}

// throw is a keyword. throw "error", also works,
class logic {
  //static because i directly accessed using the class name in main
  // static means the function belongs to the class, not an object of the class. So no object needed to be made in main
  static void depositMoney(deposit) {
    if (deposit < 0) {
      throw exceptions().depositError();
    } else if(deposit > 0) {
      print("\$ $deposit has been depositted.");
    } else {
      print("error");
    }
  }
}

// ============================================================
// TOPIC: Custom Exception Class
// ------------------------------------------------------------
// Java allows creating user-defined exceptions by extending
// the built-in Exception class. This is called a
// "Custom Exception" or "User-Defined Exception".
//
// Why use custom exceptions?
//   - To represent domain-specific error situations
//   - Makes error handling more readable and meaningful
//   - Provides better control over what errors can occur
//
// Syntax:
//   class MyException extends Exception {
//       public MyException(String message) {
//           super(message); // passes message to Exception
//       }
//   }
// ============================================================

public class InsufficientBalanceException extends Exception {

    // Constructor receives a message describing the error
    // super(message) sends it to the parent Exception class
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

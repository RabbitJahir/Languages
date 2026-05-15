// ============================================================
// TOPIC: Custom Exception (continued)
// ------------------------------------------------------------
// This exception is thrown during a money transfer when the
// receiver's bank account object is null (not found).
//
// Using a specific exception class like this instead of a
// generic NullPointerException makes the code self-documenting
// — the name alone tells you exactly what went wrong.
// ============================================================

public class AccountNotFoundException extends Exception {

    public AccountNotFoundException(String message) {
        super(message);
    }
}

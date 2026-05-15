// ============================================================
// TOPIC: Custom Exception (continued)
// ------------------------------------------------------------
// This exception is thrown when a deposit or withdrawal
// amount is invalid (e.g., zero or negative values).
//
// Having a separate exception class for each error type
// allows the caller to catch them individually and handle
// each case differently.
// ============================================================

public class InvalidAmountException extends Exception {

    public InvalidAmountException(String message) {
        super(message);
    }
}

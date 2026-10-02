package core;

/** Base class for all bank business-rule violations. Plain messages only —
 *  no ANSI colour codes here, so both the terminal view and the JavaFX
 *  view can format/display them however they like. */
public class BankException extends RuntimeException {
    public BankException(String message) { super(message); }

    public static class InvalidInputException extends BankException {
        public InvalidInputException() { super("Invalid input."); }
        public InvalidInputException(String msg) { super(msg); }
    }

    public static class InvalidAmountException extends BankException {
        public InvalidAmountException() { super("Invalid amount."); }
        public InvalidAmountException(String msg) { super(msg); }
    }

    public static class ExistingLoanException extends BankException {
        public ExistingLoanException() { super("Pay previous loan first!"); }
    }

    public static class InvalidDurationException extends BankException {
        public InvalidDurationException() { super("Duration must be 3, 6, 12, or 24 months."); }
    }

    public static class InsufficientBalanceException extends BankException {
        public InsufficientBalanceException() {
            super("Insufficient balance. Minimum $100 must be kept in the account.");
        }
    }

    public static class SimilarUserException extends BankException {
        public SimilarUserException() { super("Cannot transfer to your own account."); }
    }

    public static class UserExistsException extends BankException {
        public UserExistsException() { super("Username already exists."); }
    }

    public static class UserNotFoundException extends BankException {
        public UserNotFoundException() { super("User not found."); }
    }

    public static class InvalidCredentialsException extends BankException {
        public InvalidCredentialsException() { super("Username or password is incorrect."); }
    }
}

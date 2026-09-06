// ─────────────────────────────────────────────
//  Custom Exceptions
//  How to create your own exceptions, both
//  checked and unchecked, with extra context.
// ─────────────────────────────────────────────

// ── 1. Custom Checked Exception ─────────────────────────────────────────
//    Extend Exception → caller MUST handle it with try/catch or throws
class InsufficientFundsException extends Exception {
    private double amount;
    private double balance;

    public InsufficientFundsException(double amount, double balance) {
        // Pass a clear message to the parent
        super(String.format(
            "Cannot withdraw $%.2f. Current balance: $%.2f (short by $%.2f)",
            amount, balance, amount - balance
        ));
        this.amount  = amount;
        this.balance = balance;
    }

    // Extra getters — callers can access context without parsing the message
    public double getAmount()  { return amount; }
    public double getBalance() { return balance; }
    public double getShortfall() { return amount - balance; }
}

// ── 2. Custom Unchecked Exception ───────────────────────────────────────
//    Extend RuntimeException → catch is optional
class InvalidAgeException extends RuntimeException {
    private int age;

    public InvalidAgeException(int age) {
        super("Invalid age: " + age + ". Must be between 0 and 150.");
        this.age = age;
    }

    // Cause chaining constructor — wraps another exception
    public InvalidAgeException(int age, Throwable cause) {
        super("Invalid age: " + age, cause);
        this.age = age;
    }

    public int getAge() { return age; }
}

// ── 3. Exception hierarchy for an app ───────────────────────────────────
//    Common pattern: one base app exception, then specifics
class AppException extends RuntimeException {
    private final String errorCode;

    public AppException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public AppException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() { return errorCode; }
}

class UserNotFoundException extends AppException {
    public UserNotFoundException(int userId) {
        super("USR_404", "User not found with ID: " + userId);
    }
}

class PermissionDeniedException extends AppException {
    public PermissionDeniedException(String action) {
        super("AUTH_403", "Permission denied: " + action);
    }
}

// ── The classes that use these exceptions ────────────────────────────────
class Wallet {
    private double balance;

    Wallet(double balance) { this.balance = balance; }

    // Checked: must declare 'throws' or caller must catch
    void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount, balance);
        }
        balance -= amount;
        System.out.printf("Withdrew $%.2f → New balance: $%.2f%n", amount, balance);
    }

    double getBalance() { return balance; }
}

class UserService {
    void registerUser(String name, int age) {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException(age);  // unchecked, no try needed
        }
        System.out.println("Registered: " + name + ", age " + age);
    }

    void findUser(int id) {
        if (id != 1) {
            throw new UserNotFoundException(id);
        }
        System.out.println("Found user #" + id);
    }

    void adminAction(String role, String action) {
        if (!role.equals("ADMIN")) {
            throw new PermissionDeniedException(action);
        }
        System.out.println("Action '" + action + "' performed by " + role);
    }
}

// ── Main demo ────────────────────────────────────────────────────────────
public class CustomExceptionDemo {

    public static void main(String[] args) {

        // ── Checked exception (InsufficientFundsException) ──────────────
        System.out.println("=== Checked: InsufficientFundsException ===");
        Wallet wallet = new Wallet(100.00);

        try {
            wallet.withdraw(40.00);   // OK
            wallet.withdraw(200.00);  // throws InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println("Caught: " + e.getMessage());
            System.out.printf("  Shortfall: $%.2f%n", e.getShortfall());
        }

        // ── Unchecked exception (InvalidAgeException) ───────────────────
        System.out.println("\n=== Unchecked: InvalidAgeException ===");
        UserService users = new UserService();

        users.registerUser("Alice", 25);  // OK
        try {
            users.registerUser("Bob", -3);  // throws InvalidAgeException
        } catch (InvalidAgeException e) {
            System.out.println("Caught: " + e.getMessage());
            System.out.println("  Bad age value: " + e.getAge());
        }

        // ── App exception hierarchy ──────────────────────────────────────
        System.out.println("\n=== App Exception Hierarchy ===");

        try {
            users.findUser(99);
        } catch (UserNotFoundException e) {
            System.out.println("Caught [" + e.getErrorCode() + "]: " + e.getMessage());
        }

        try {
            users.adminAction("USER", "delete all data");
        } catch (PermissionDeniedException e) {
            System.out.println("Caught [" + e.getErrorCode() + "]: " + e.getMessage());
        }

        // Catching by parent type
        System.out.println("\n--- Catching by parent AppException ---");
        try {
            users.findUser(404);
        } catch (AppException e) {
            // Catches any AppException subclass
            System.out.println("App error [" + e.getErrorCode() + "]: " + e.getMessage());
        }
    }
}

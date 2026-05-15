// ============================================================
// TOPIC: Class & Encapsulation
// ------------------------------------------------------------
// A class is a blueprint for creating objects.
// Encapsulation means keeping fields private and exposing
// them only through controlled methods (getters/setters).
//
// Here, 'balance' and 'pin' are private — they cannot be
// accessed directly from outside. This prevents accidental
// or unauthorized modification.
// ============================================================

public class BankAccount {

    // --------------------------------------------------------
    // TOPIC: Private Fields (Data Hiding)
    // --------------------------------------------------------
    // 'private' keyword restricts access to this class only.
    // This is the core idea behind encapsulation.
    // --------------------------------------------------------
    private int    accountNumber;
    private String customerName;
    private double balance;
    private int    pin;


    // --------------------------------------------------------
    // TOPIC: Constructor
    // --------------------------------------------------------
    // A constructor is a special method called when an object
    // is created using 'new'. It initializes the object's
    // fields with the provided values.
    //
    // 'this.field' refers to the current object's field,
    // distinguishing it from the parameter with the same name.
    // --------------------------------------------------------
    public BankAccount(int accountNumber, String customerName,
                       double balance, int pin) {

        this.accountNumber = accountNumber;
        this.customerName  = customerName;
        this.balance       = balance;
        this.pin           = pin;
    }


    // --------------------------------------------------------
    // TOPIC: Getter Method
    // --------------------------------------------------------
    // A getter provides read-only access to a private field.
    // The field itself stays private; only its value is shared.
    // --------------------------------------------------------
    public int getAccountNumber() {
        return accountNumber;
    }


    // --------------------------------------------------------
    // TOPIC: Regular Method
    // --------------------------------------------------------
    // Displays the current balance. Since 'balance' is private,
    // this method acts as the only safe way to read it.
    // --------------------------------------------------------
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }


    // --------------------------------------------------------
    // TOPIC: Throwing Custom Exceptions (throw keyword)
    // --------------------------------------------------------
    // 'throws' in the method signature declares that this
    // method MAY throw the listed exception types.
    //
    // 'throw' (inside the method) actually triggers the
    // exception with a specific message.
    //
    // The caller is responsible for handling it with try-catch.
    // --------------------------------------------------------
    public void deposit(double amount)
            throws InvalidAmountException {

        // Validate input — negative or zero deposits are invalid
        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Deposit amount cannot be negative or zero.");
        }

        balance += amount;

        System.out.println("Deposit successful.");
        System.out.println("New Balance: " + balance);
    }


    // --------------------------------------------------------
    // TOPIC: Multiple Exception Types on One Method
    // --------------------------------------------------------
    // A method can declare multiple exception types separated
    // by commas in the 'throws' clause.
    // The caller must handle ALL of them.
    // --------------------------------------------------------
    public void withdraw(double amount)
            throws InsufficientBalanceException,
                   InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Withdrawal amount must be positive.");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance.");
        }

        balance -= amount;

        System.out.println("Withdrawal successful.");
        System.out.println("Remaining Balance: " + balance);
    }


    // --------------------------------------------------------
    // TOPIC: Exception Propagation
    // --------------------------------------------------------
    // transferMoney() calls withdraw() which already throws
    // exceptions. Instead of catching them here, we re-declare
    // them in the 'throws' clause — they propagate up to the
    // caller (Main). This avoids redundant try-catch blocks.
    // --------------------------------------------------------
    public void transferMoney(BankAccount receiver, double amount)
            throws AccountNotFoundException,
                   InvalidAmountException,
                   InsufficientBalanceException {

        // Check for null receiver before proceeding
        if (receiver == null) {
            throw new AccountNotFoundException(
                    "Receiver account not found.");
        }

        // withdraw() may throw InvalidAmountException or
        // InsufficientBalanceException — both propagate up
        withdraw(amount);

        // Directly modify receiver's balance (same package access)
        receiver.balance += amount;

        System.out.println("Transfer successful.");
    }


    // --------------------------------------------------------
    // TOPIC: Boolean Return Method (PIN Verification)
    // --------------------------------------------------------
    // Returns true if the entered PIN matches the stored PIN.
    // The actual pin value is never exposed — only a yes/no.
    // This is another form of data protection via encapsulation.
    // --------------------------------------------------------
    public boolean checkPin(int enteredPin) {
        return enteredPin == pin;
    }
}

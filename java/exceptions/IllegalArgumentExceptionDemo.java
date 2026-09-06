// ─────────────────────────────────────────────
//  IllegalArgumentException
//  Thrown when a method receives an argument
//  that is inappropriate or out of allowed range.
//  Commonly thrown manually to validate inputs.
// ─────────────────────────────────────────────

public class IllegalArgumentExceptionDemo {

    // ── A class that enforces its own rules ─────────────────────────────
    static class BankAccount {
        private String owner;
        private double balance;

        BankAccount(String owner, double initialBalance) {
            if (owner == null || owner.isBlank()) {
                throw new IllegalArgumentException("Owner name cannot be empty.");
            }
            if (initialBalance < 0) {
                throw new IllegalArgumentException(
                    "Initial balance cannot be negative: " + initialBalance);
            }
            this.owner   = owner;
            this.balance = initialBalance;
        }

        void deposit(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException(
                    "Deposit amount must be positive, got: " + amount);
            }
            balance += amount;
            System.out.printf("Deposited $%.2f → Balance: $%.2f%n", amount, balance);
        }

        void withdraw(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException(
                    "Withdrawal amount must be positive, got: " + amount);
            }
            if (amount > balance) {
                throw new IllegalArgumentException(
                    "Insufficient funds. Requested $" + amount + ", balance is $" + balance);
            }
            balance -= amount;
            System.out.printf("Withdrew $%.2f → Balance: $%.2f%n", amount, balance);
        }

        double getBalance() { return balance; }
    }

    // ── A method with an allowed range ──────────────────────────────────
    static int setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException(
                "Age must be between 0 and 150, got: " + age);
        }
        return age;
    }

    // ── Thread.sleep also throws IAE for negative millis ────────────────
    static void sleepDemo(long millis) {
        try {
            Thread.sleep(millis);  // throws IAE if millis < 0
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IAE from Thread.sleep: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {

        // ── Valid account creation ──────────────────────────────────────
        System.out.println("=== Valid account creation ===");
        BankAccount account = new BankAccount("Alice", 500.00);
        account.deposit(200.00);
        account.withdraw(100.00);

        // ── Invalid initial balance ─────────────────────────────────────
        System.out.println("\n=== Example 1: Negative initial balance ===");
        try {
            BankAccount bad = new BankAccount("Bob", -100);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // ── Invalid deposit ─────────────────────────────────────────────
        System.out.println("\n=== Example 2: Zero deposit ===");
        try {
            account.deposit(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // ── Overdraft attempt ───────────────────────────────────────────
        System.out.println("\n=== Example 3: Overdraft ===");
        try {
            account.withdraw(9999);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // ── Invalid age ─────────────────────────────────────────────────
        System.out.println("\n=== Example 4: Invalid age ===");
        try {
            setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        try {
            setAge(200);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println("Valid age: " + setAge(25));

        // ── Thread.sleep with negative value ───────────────────────────
        System.out.println("\n=== Example 5: Thread.sleep with negative ms ===");
        sleepDemo(-500);
    }
}

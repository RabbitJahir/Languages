import java.util.*;
import java.io.*;

// javac Main.java
// java Main

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

class BankAccount {

    private int    accountNumber;
    private String customerName;
    private double balance;
    private int    pin;

    public BankAccount(int accountNumber, String customerName,
                       double balance, int pin) {
        this.accountNumber = accountNumber;
        this.customerName  = customerName;
        this.balance       = balance;
        this.pin           = pin;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void deposit(double amount)
            throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Deposit amount cannot be negative or zero.");
        }
        balance += amount;
        System.out.println("Deposit successful.");
        System.out.println("New Balance: " + balance);
    }

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

    public void transferMoney(BankAccount receiver, double amount)
            throws AccountNotFoundException,
                   InvalidAmountException,
                   InsufficientBalanceException {
        if (receiver == null) {
            throw new AccountNotFoundException(
                    "Receiver account not found.");
        }
        withdraw(amount);
        receiver.balance += amount;
        System.out.println("Transfer successful.");
    }

    public boolean checkPin(int enteredPin) {
        return enteredPin == pin;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount acc1 = new BankAccount(101, "rabbit", 10000, 1234);
        BankAccount acc2 = new BankAccount(102, "ictcell", 10000, 5678);

        int choice;

        do {
            System.out.println("\n===== SMART ATM SYSTEM =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Interest Calculation");
            System.out.println("6. Read Customer File");
            System.out.println("7. ATM Login");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter amount: ");
                        double depositAmount = sc.nextDouble();
                        acc1.deposit(depositAmount);
                        break;

                    case 2:
                        System.out.print("Enter withdraw amount: ");
                        double withdrawAmount = sc.nextDouble();
                        acc1.withdraw(withdrawAmount);
                        break;

                    case 3:
                        System.out.print("Enter transfer amount: ");
                        double transferAmount = sc.nextDouble();

                        try {
                            System.out.print("Enter receiver account number: ");
                            int receiverAcc = sc.nextInt();

                            BankAccount receiver = null;
                            if (receiverAcc == 102) {
                                receiver = acc2;
                            }

                            acc1.transferMoney(receiver, transferAmount);

                        } catch (AccountNotFoundException e) {
                            System.out.println("Transfer Error: " + e.getMessage());
                        }

                        break;

                    case 4:
                        acc1.checkBalance();
                        break;

                    case 5:
                        System.out.print("Enter years: ");
                        int years = sc.nextInt();
                        double interest = 1000 / years;
                        System.out.println("Calculated Interest: " + interest);
                        break;

                    case 6:
                        readCustomerFile();
                        break;

                    case 7:
                        atmLogin(sc, acc1);
                        break;

                    case 0:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (InvalidAmountException e) {
                System.out.println("Invalid Amount Error: " + e.getMessage());

            } catch (InsufficientBalanceException e) {
                System.out.println("Balance Error: " + e.getMessage());

            } catch (ArithmeticException e) {
                System.out.println("Math Error: Cannot divide by zero.");

            } catch (Exception e) {
                System.out.println("General Error: " + e.getMessage());

            } finally {
                System.out.println("Transaction process completed.");
            }

        } while (choice != 0);

        sc.close();
    }

    public static void readCustomerFile() throws IOException {
        File           file = new File("customer.txt");
        FileReader     fr   = new FileReader(file);
        BufferedReader br   = new BufferedReader(fr);
        System.out.println(br.readLine());
        br.close();
    }

    public static void atmLogin(Scanner sc, BankAccount acc) {

        int attempts = 0;

        while (attempts < 3) {
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            if (acc.checkPin(pin)) {
                System.out.println("Login Successful");
                return;
            } else {
                attempts++;
                System.out.println("Wrong PIN. Attempts left: " + (3 - attempts));
            }
        }

        throw new SecurityException(
                "ATM blocked after 3 failed attempts.");
    }
}
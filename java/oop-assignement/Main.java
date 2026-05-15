import java.util.*;
import java.io.*;

// ============================================================
// FILE: Main.java
// ------------------------------------------------------------
// This is the entry point of the Smart ATM System.
// It demonstrates the following Java Exception Handling topics:
//
//   1. try-catch-finally block
//   2. Multiple catch blocks
//   3. Nested try block
//   4. throws keyword (checked exceptions)
//   5. throw keyword (unchecked / runtime exceptions)
//   6. ArithmeticException (built-in)
//   7. IOException (checked, file handling)
//   8. SecurityException (runtime, ATM lockout)
//   9. Custom exceptions (see individual .java files)
// ============================================================

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        // ----------------------------------------------------
        // TOPIC: Object Creation
        // ----------------------------------------------------
        // Two BankAccount objects are created using the 'new'
        // keyword, which calls the constructor defined in
        // BankAccount.java.
        //   Parameters: accountNumber, name, balance, pin
        // ----------------------------------------------------
        BankAccount acc1 = new BankAccount(101, "Rahim", 10000, 1234);
        BankAccount acc2 = new BankAccount(102, "Karim", 5000,  5678);

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


            // ------------------------------------------------
            // TOPIC: try-catch-finally Block
            // ------------------------------------------------
            // try     → code that might throw an exception
            // catch   → handles specific exception types
            // finally → always runs, whether or not an
            //           exception occurred (used for cleanup)
            // ------------------------------------------------
            try {

                switch (choice) {

                    case 1:
                        // ------------------------------------------
                        // TOPIC: Calling a method that throws
                        // ------------------------------------------
                        // deposit() declares 'throws InvalidAmountException'
                        // so we must handle it here in a catch block.
                        // ------------------------------------------
                        System.out.print("Enter amount: ");
                        double depositAmount = sc.nextDouble();
                        acc1.deposit(depositAmount);
                        break;


                    case 2:
                        // withdraw() throws InvalidAmountException
                        // AND InsufficientBalanceException — both are
                        // caught separately in the catch blocks below.
                        System.out.print("Enter withdraw amount: ");
                        double withdrawAmount = sc.nextDouble();
                        acc1.withdraw(withdrawAmount);
                        break;


                    case 3:
                        System.out.print("Enter transfer amount: ");
                        double transferAmount = sc.nextDouble();

                        // --------------------------------------------
                        // TOPIC: Nested try Block
                        // --------------------------------------------
                        // A try block inside another try block.
                        // Used here to separately handle
                        // AccountNotFoundException (receiver not found)
                        // without interrupting the outer try block's
                        // handling of other exceptions.
                        // --------------------------------------------
                        try {

                            System.out.print("Enter receiver account number: ");
                            int receiverAcc = sc.nextInt();

                            // Determine the receiver account
                            BankAccount receiver = null;
                            if (receiverAcc == 102) {
                                receiver = acc2;
                            }

                            // If receiver is null, AccountNotFoundException
                            // is thrown inside transferMoney()
                            acc1.transferMoney(receiver, transferAmount);

                        } catch (AccountNotFoundException e) {
                            // This catch only handles the inner try block
                            System.out.println("Transfer Error: " + e.getMessage());
                        }

                        break;


                    case 4:
                        acc1.checkBalance();
                        break;


                    case 5:
                        // --------------------------------------------
                        // TOPIC: ArithmeticException (Built-in)
                        // --------------------------------------------
                        // ArithmeticException is a RuntimeException —
                        // it does NOT need to be declared with 'throws'.
                        // It is thrown automatically by the JVM when
                        // integer division by zero occurs.
                        //
                        // Note: 1000 / 0 (int) → throws exception
                        //       1000.0 / 0 (double) → returns Infinity
                        // --------------------------------------------
                        System.out.print("Enter years: ");
                        int years = sc.nextInt();

                        // If years == 0, JVM throws ArithmeticException
                        double interest = 1000 / years;

                        System.out.println("Calculated Interest: " + interest);
                        break;


                    case 6:
                        // --------------------------------------------
                        // TOPIC: IOException & throws (Checked Exception)
                        // --------------------------------------------
                        // readCustomerFile() is declared with 'throws
                        // IOException' because file operations can fail.
                        // IOException is a checked exception — the
                        // compiler forces you to handle it.
                        // --------------------------------------------
                        readCustomerFile();
                        break;


                    case 7:
                        // --------------------------------------------
                        // TOPIC: SecurityException (Runtime / Unchecked)
                        // --------------------------------------------
                        // atmLogin() throws SecurityException after 3
                        // failed PIN attempts. Since SecurityException
                        // extends RuntimeException, it does NOT need
                        // 'throws' in the signature — but it still
                        // needs to be caught to prevent a crash.
                        // It is caught by the generic catch(Exception e)
                        // block below.
                        // --------------------------------------------
                        atmLogin(sc, acc1);
                        break;


                    case 0:
                        System.out.println("Thank you!");
                        break;


                    default:
                        System.out.println("Invalid choice.");
                }

            }


            // ------------------------------------------------
            // TOPIC: Multiple catch Blocks
            // ------------------------------------------------
            // Java checks catch blocks TOP to BOTTOM.
            // More specific exceptions must come BEFORE
            // more general ones (Exception is the most general).
            //
            // Each catch block handles a different error type,
            // allowing custom messages for each situation.
            // ------------------------------------------------

            catch (InvalidAmountException e) {
                // Handles invalid deposit/withdrawal amounts
                System.out.println("Invalid Amount Error: " + e.getMessage());
            }

            catch (InsufficientBalanceException e) {
                // Handles overdraft attempts
                System.out.println("Balance Error: " + e.getMessage());
            }

            catch (ArithmeticException e) {
                // Handles division by zero in interest calculation
                System.out.println("Math Error: Cannot divide by zero.");
            }

            catch (Exception e) {
                // ------------------------------------------------
                // TOPIC: Generic catch Block
                // ------------------------------------------------
                // Catches any other exception not handled above.
                // This includes IOException and SecurityException.
                // Always placed LAST because Exception is the
                // parent of all exceptions — placing it first
                // would prevent specific catches from running.
                // ------------------------------------------------
                System.out.println("General Error: " + e.getMessage());
            }


            // ------------------------------------------------
            // TOPIC: finally Block
            // ------------------------------------------------
            // Runs ALWAYS — even if an exception was thrown
            // or even if a return statement was hit.
            // Typically used for cleanup: closing files,
            // releasing connections, printing summaries, etc.
            // ------------------------------------------------
            finally {
                System.out.println("Transaction process completed.");
            }

        } while (choice != 0);

        sc.close();
    }


    // --------------------------------------------------------
    // TOPIC: throws Keyword (Checked Exception Declaration)
    // --------------------------------------------------------
    // 'throws IOException' tells the compiler and caller that
    // this method might throw an IOException (a checked
    // exception). The caller must either:
    //   1. Handle it with try-catch, OR
    //   2. Also declare 'throws IOException' in their signature
    //
    // Here, Main.main() handles it via the generic catch block.
    // --------------------------------------------------------
    public static void readCustomerFile() throws IOException {

        // File object represents the path "customer.txt"
        // FileReader opens the file for character reading
        // BufferedReader wraps FileReader for line-by-line reading
        File         file = new File("customer.txt");
        FileReader   fr   = new FileReader(file);   // throws FileNotFoundException (subclass of IOException)
        BufferedReader br  = new BufferedReader(fr);

        System.out.println(br.readLine());

        br.close(); // Always close streams to free resources
    }


    // --------------------------------------------------------
    // TOPIC: throw Keyword (Manually Throwing RuntimeException)
    // --------------------------------------------------------
    // Unlike checked exceptions, RuntimeExceptions (like
    // SecurityException) do NOT need 'throws' in the signature.
    // But we can still manually throw them using 'throw new'.
    //
    // Here, after 3 wrong PIN attempts, we throw a
    // SecurityException to lock the ATM — simulating real
    // bank security behavior.
    // --------------------------------------------------------
    public static void atmLogin(Scanner sc, BankAccount acc) {

        int attempts = 0;

        while (attempts < 3) {

            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            if (acc.checkPin(pin)) {
                System.out.println("Login Successful");
                return; // Exit immediately on success
            } else {
                attempts++;
                System.out.println("Wrong PIN. Attempts left: " + (3 - attempts));
            }
        }

        // All 3 attempts used — lock the ATM
        // This is an UNCHECKED exception (no 'throws' needed)
        throw new SecurityException(
                "ATM blocked after 3 failed attempts.");
    }
}

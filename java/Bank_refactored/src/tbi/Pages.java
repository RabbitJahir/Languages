package tbi;

import core.Transaction;
import core.UsersStorage;

import java.util.List;

public class Pages {

    public void homeScreen() {
        System.out.println("-----------------------------");
        System.out.println("     WELCOME TO BANK");
        System.out.println("-----------------------------");
        System.out.println("1. Login\n");
        System.out.println("2. Create account\n");
        System.out.println("3. Change password\n");
        System.out.println("0. Exit\n");
        System.out.print("Enter your choice: ");
    }

    public void userHub() {
        System.out.println("\033[1m1. Detailed Information\033[0m");
        System.out.println("\033[1m2. Check Balance\033[0m");
        System.out.println("\033[1m3. Take Loan\033[0m");
        System.out.println("\033[1m4. Repay Loan\033[0m");
        System.out.println("\033[1m5. Withdraw from Balance\033[0m");
        System.out.println("\033[1m6. Deposit into Balance\033[0m");
        System.out.println("\033[1m7. Transfer Balance\033[0m");
        System.out.println("\033[1m8. Transaction History (sort/search)\033[0m");
        System.out.println("\033[1m9. Exit\n\033[0m");
        System.out.print("Choose: ");
    }

    public void loginScreen() {
        System.out.println("-----------------------------");
        System.out.println("  LOGGING IN");
        System.out.println("-----------------------------");
    }

    public void createScreen() {
        System.out.println("-----------------------------");
        System.out.println("  CREATING ACCOUNT");
        System.out.println("-----------------------------");
        System.out.println("1. Personal account: ");
        System.out.println("- $500 initial deposit.\n");
        System.out.println("2. Savings account: ");
        System.out.println("- No initial deposit.\n");
    }

    public static void changePassword() {
        System.out.println("-----------------------------");
        System.out.println("  CHANGING PASSWORD");
        System.out.println("-----------------------------");
    }

    public void loanRulesScreenPersonal() {
        System.out.println("1. A user can only have one active loan at a time.");
        System.out.println("2. Loan amount must be between $100 and $50,000.");
        System.out.println("3. A fixed 20% interest is added once when the loan is approved.");
        System.out.println("4. Loan durations are 3, 6, 12, 24 months.");
        System.out.println("\033[1mEnter 0 to go back.\033[0m");
    }

    public void loanRulesScreenSavings() {
        System.out.println("1. A user can only have one active loan at a time.");
        System.out.println("2. Loan amount must be between $100 and $7,000.");
        System.out.println("3. A fixed 13% interest is added once when the loan is approved.");
        System.out.println("4. Loan durations are 3, 6, 12, 24 months.");
        System.out.println("\033[1mEnter 0 to go back.\033[0m");
    }

    public void invalidInput() {
        System.out.println("\033[1m\033[31mInvalid Input\033[0m");
    }

    public void error(String message) {
        System.out.println("\033[1m\033[31m" + message + "\033[0m");
    }

    public void success(String message) {
        System.out.println("\033[1m\033[32m" + message + "\033[0m");
    }

    public void repayLoanScreen() {
        System.out.println("1. Pay using cash");
        System.out.println("2. Pay using bank balance");
        System.out.println("\033[1mEnter 0 to go back.\033[0m\n");
        System.out.print("Option: ");
    }

    public void showBalance(String currentUser, UsersStorage accountCheck) {
        System.out.printf("\n\033[34mCurrent balance :\033[0m %.2f\n\n", accountCheck.balance(currentUser));
    }

    public void showLoan(String currentUser, UsersStorage accountCheck) {
        System.out.printf("Current loan is: %.2f\n\n", accountCheck.loan(currentUser));
    }

    public void historyMenu() {
        System.out.println("-----------------------------");
        System.out.println("  TRANSACTION HISTORY");
        System.out.println("-----------------------------");
        System.out.println("1. Sort by amount");
        System.out.println("2. Sort by date");
        System.out.println("3. Search by exact amount (binary search)");
        System.out.println("4. Search by type (linear search)");
        System.out.println("\033[1mEnter 0 to go back.\033[0m\n");
        System.out.print("Choose: ");
    }

    public void printHistory(List<Transaction> list) {
        if (list.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        for (Transaction t : list) System.out.println(t);
    }
}

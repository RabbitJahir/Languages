package pages;

public class Pages {

    // Home screen
    public void homeScreen() {
        System.out.println("-----------------------------");
        System.out.println("     WELCOME TO BANK");
        System.out.println("-----------------------------");
        System.out.println("1. Login\n");
        System.out.println("2. Create account\n");
        System.out.println("3. Exit\n");
        System.out.print("Enter your choice: ");
    }

     //USER HUB, after logging in
    public void userHub() {
        System.out.println("\033[1m1. Detailed Information\033[0m");
        System.out.println("\033[1m2. Check Balance\033[0m");
        System.out.println("\033[1m3. Take Loan\033[0m");
        System.out.println("\033[1m4. Repay Loan\033[0m");
        System.out.println("\033[1m5. Withdraw from Balance\033[0m");
        System.out.println("\033[1m6. Deposit into Balance\033[0m");
        System.out.println("\033[1m7. Transfer Balance\033[0m");
        System.out.println("\033[1m8. Exit\n\033[0m");
        System.out.print("Choose: ");
    }

    // login screen
    public void loginScreen() {
        System.out.println("-----------------------------");
        System.out.println("  LOGGING IN");
        System.out.println("-----------------------------");
    }

    // create screen
    public void createScreen(){
        System.out.println("-----------------------------");
        System.out.println("  CREATING ACCOUNT");
        System.out.println("-----------------------------");
    }

    // loan screen
    public void loanRulesScreen(){
        System.out.println("1. A user can only have one active loan at a time.");
        System.out.println("2. Loan amount must be between $100 and $50,000.");
        System.out.println("3. A fixed 20% interest is added once when the loan is approved.");
        System.out.println("4. The total payable amount is divided into equal monthly payments. Loan durations are 3, 6, 12, 24 months.");
        System.out.println("5.  Monthly payments must be paid before due date otherwise 10% interest will be added.");
        System.out.println("6. Users cannot take another loan until the current loan is fully paid.");
        System.out.println("");

    }

}   
package pages;

public class Pages implements PageTypes {

    public void homeScreen() {
        System.out.println("-----------------------------");
        System.out.println("     WELCOME TO BANK");
        System.out.println("-----------------------------");
        System.out.println("1. Login\n");
        System.out.println("2. Create account\n");
        System.out.print("Enter your choice: ");
    }

     //USER HUB
    public void userHub() {
        System.out.println("1. Detailed Information");
        System.out.println("2. Check Balance");
        System.out.println("3. Take Loan");
        System.out.println("4. Repay Loan");
        System.out.println("5. Withdraw from Balance");
        System.out.println("6. Deposit into Balance");
        System.out.println("7. Transfer Balance");
        System.out.println("8. Exit\n");
        System.out.print("Choose: ");
    }

    public void loginScreen() {
        System.out.println("-----------------------------");
        System.out.println("  LOGGING IN");
        System.out.println("-----------------------------");
    }

    public void createScreen(){
        System.out.println("-----------------------------");
        System.out.println("  CREATING ACCOUNT");
        System.out.println("-----------------------------");
    }

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
// pages
import pages.Pages;
import users.Login;
import users.UsersStorage;
import ui.UI;

// utils
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);

            // Building objects
            Pages page = new Pages();
            UsersStorage accountCheck = new UsersStorage();
            

            String currentUser = null;

            //-----------------------------------
            // LOGIN LOOP
            
            while (true) {

                UI.clearScreen();
                page.homeScreen();

                int accountType = sc.nextInt();
                sc.nextLine();

                UI.clearScreen();

                switch (accountType) {
                    case 1 -> {
                        page.loginScreen();
                        currentUser = Login.handleLogin(sc, accountCheck);
                    }
                    case 2 -> {
                        page.createScreen();
                        System.out.print("Enter username: ");
                        String username = sc.nextLine();

                        System.out.print("Enter password: ");
                        String password = sc.nextLine();

                        System.out.print("Enter account type: ");
                        String type = sc.nextLine();

                        System.out.print("Enter mobile number: ");
                        String mobile = sc.nextLine();

                        boolean created = accountCheck.createUser(username, password, type, mobile, 0.0, 0.0);

                        if (created) {
                            accountCheck.saveToFile(); 
                        }

                        UI.pause(sc);
                    }
                    default -> {
                        System.out.println("Invalid option.");
                        UI.pause(sc);
                        continue;
                    }
                }

                if (currentUser != null) {
                    break; 
                } else {
                    UI.pause(sc);
                }
            }

            //-----------------------------------
            // USER MENU LOOP
            boolean userLoop = true;

            while (userLoop) {

                UI.clearScreen();
                System.out.println("-----------------------------");
                System.out.printf("Welcome %s\n", currentUser);
                System.out.println("-----------------------------");
                page.userHub();
                int userHubChoose = sc.nextInt();
                sc.nextLine();

                switch (userHubChoose) {

                    // USER HUB
                    case 1 -> {
                        //Details
                        UsersStorage.User user = accountCheck.getUser(currentUser); 
                        System.out.println("---------------------------"); 
                        System.out.printf("Username      :  %s\n", user.username); 
                        System.out.printf("Phone         :  %s\n", user.mobile); 
                        System.out.printf("Account Type  :  %s\n ", user.accountType); 
                        System.out.printf("Balance       :  %s\n", money.format(user.balance)); 
                        System.out.printf("Loan          :  %s\n", user.loan);
                        System.out.println("---------------------------");
                        UI.pause(sc);
                    }
                    case 2 -> {
                        //balance
                        double balance = accountCheck.balance(currentUser);
                        System.out.printf("Current balance is: %s\n\n", money.format(balance));
                        UI.pause(sc);
                    }

                    case 3 ->{
                        // take Loan
                        double loan = accountCheck.loan(currentUser);
                        System.out.printf("Current loan is: %s\n\n", loan);

                        page.loanRulesScreen();

                        System.out.print("Amount for loan: ");
                        double newLoan = sc.nextDouble();
                        sc.nextLine();

                        if(newLoan<0){
                            System.out.print("\nNegative amount is loan is not acceptable.");
                            UI.pause(sc);
                            continue;
                        } else if(newLoan <100 || newLoan > 50000){
                            System.out.print("\nLoan amount must be between $100 and $50,000.");
                            UI.pause(sc);
                            continue;
                        } else{
                            loan += newLoan;
                            accountCheck.updateLoan(currentUser, newLoan);
                            accountCheck.saveToFile();
                        }

                        System.out.print("\nTotal duration to repay the loan in months(3, 6, 12, 25): ");
                        int timeLoan = sc.nextInt();
                        sc.nextLine();
                        if(timeLoan != 3 || timeLoan != 6 || timeLoan != 12 || timeLoan != 24){
                            System.out.print("\nPlese choose from the given range (3, 6, 12, 24).");
                            UI.pause(sc);
                            continue;
                        } else {

                        }
                        System.out.printf("\nCurrent loan is: %s\n\n", money.format(newLoan));
                        UI.pause(sc);
                    }

                    case 4 ->{
                        // repay loan
                        double loan = accountCheck.loan(currentUser);

                        System.out.printf("Total loan: %s\n", money.format(loan));

                        System.out.print("Amount to be repayed: \n");
                        System.out.print("Amount repaying: \n");
                        double repayLoan = sc.nextDouble();
                        if(repayLoan<0){
                            System.out.println("Can not repay loan in negative");
                        }
                        else{
                            System.out.println("loan repayed.");
                        }
                        UI.pause(sc);
                    }

                    case 5 -> {
                        //withdraw
                        double balance = accountCheck.balance(currentUser);
                        System.out.printf("Current balance is: %s\n\n", money.format(balance));

                        System.out.print("Give an amount to withdraw: ");
                        double withdraw = sc.nextDouble();
                        sc.nextLine();

                        if (withdraw >= balance || balance - withdraw < 100) {
                            System.out.println("\n\nCannot withdraw more than balance (keep minimum $100).");
                        } else if (withdraw < 0) {
                            System.out.println("Cannot withdraw negative amount.");
                        } else {
                            balance -= withdraw;
                            accountCheck.updateBalance(currentUser, balance);
                            accountCheck.saveToFile();
                        }

                        System.out.printf("\nCurrent balance is: %s\n", money.format(balance));
                        UI.pause(sc);
                    }

                    case 6 -> {
                        //deposit
                        double balance = accountCheck.balance(currentUser);
                        System.out.printf("Current balance is: %s\n\n", money.format(balance));

                        System.out.print("Give an amount to deposit: ");
                        double deposit = sc.nextDouble();
                        sc.nextLine();

                        if (deposit < 0) {
                            System.out.println("Cannot deposit negative amount.");
                        } else {
                            balance += deposit;
                            accountCheck.updateBalance(currentUser, balance);
                            accountCheck.saveToFile();
                        }

                        System.out.printf("\nCurrent balance is: %s\n", money.format(balance));
                        UI.pause(sc);
                    }

                    case 7 -> {
                        //transfer
                        System.out.println("Transfer feature coming soon...");
                        UI.pause(sc);
                    }

                    case 8 -> {
                        //exit
                        UI.clearScreen();
                        System.out.println("Exiting.\nThank you for trusting us!");
                        userLoop = false;
                    }

                    default -> {
                        System.out.println("Wrong input");
                        UI.pause(sc);
                    }
                }
            }
        }
    }
}
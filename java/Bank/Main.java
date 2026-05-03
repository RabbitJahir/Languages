// pages 
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import pages.Pages;
import ui.UI;
import users.Login; // locale is used for money showing
import users.UsersStorage;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            // shows dollar sign
            NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);

            // Building objects
            Pages page = new Pages();
            UsersStorage accountCheck = new UsersStorage();
            

                // to use lator on, so entire screen knows currentuser
            String currentUser = null;

            //-----------------------------------
            // LOGIN LOOP
            
            boolean loop_1 = true;
            while (loop_1) {

                UI.clearScreen();
                page.homeScreen(); //calls home screen from pages

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
                            accountCheck.saveToFile();  // save to file goes to users storage
                        }

                        UI.pause(sc);
                    }
                    case 3 -> {
                        System.out.print("Logging out...");
                        UI.pause(sc);
                        System.exit(0); // ends the system, succesfully. Here 0 means normal/succesfully 
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
            // boolean userLoop = true;

            while (true) {

                UI.clearScreen();
                System.out.println("\033[1m-----------------------------");
                System.out.printf("    Welcome %s\n", currentUser);
                System.out.println("-----------------------------\033[0m");
                page.userHub();
                int userHubChoose = sc.nextInt();
                sc.nextLine();

                switch (userHubChoose) {

                    // USER HUB
                    case 1 -> {
                        //Details
                        UsersStorage.User user = accountCheck.getUser(currentUser); 
                        System.out.println("---------------------------"); 
                        System.out.printf(" Username      :  %s\n", user.username); 
                        System.out.printf(" Phone         :  %s\n", user.mobile); 
                        System.out.printf(" Account Type  :  %s\n ", user.accountType); 
                        System.out.printf("Balance       :  %s\n", money.format(user.balance)); 
                        System.out.printf(" Loan          :  %s\n", user.loan);
                        System.out.println("---------------------------");
                        UI.pause(sc);
                    }
                    case 2 -> {
                        //balance
                        double balance = accountCheck.balance(currentUser);
                        System.out.printf("\n\033[34mCurrent balance :\033[0m %s\n\n", money.format(balance));
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
                            System.out.print("\nTotal duration to repay the loan in months(3, 6, 12, 24): ");
                            int timeLoan = sc.nextInt();
                            sc.nextLine();

                                if(timeLoan == 3 || timeLoan == 6 || timeLoan == 12 || timeLoan == 24){
                                    double addLoan = accountCheck.loan(currentUser);
                                    newLoan+=addLoan;
                                    accountCheck.updateLoan(currentUser, newLoan);
                                    accountCheck.saveToFile();
                                    System.out.println("Succesfully loan given.");
                                } else {
                                    System.out.print("\nPlese choose from the given range (3, 6, 12, 24).");
                                }
                        }
                        
                        double loanCheck = accountCheck.loan(currentUser);
                        System.out.printf("\nCurrent loan : %s\n\n", money.format(loanCheck));
                        UI.pause(sc);
                    }

                    case 4 ->{
                        // repay loan
                        double loan = accountCheck.loan(currentUser);

                        System.out.printf("Total loan: %s\n", money.format(loan));

                        System.out.print("\n\nAmount repaying: ");
                        double repayLoan = sc.nextDouble();
                        sc.nextLine();
                        
                        if(repayLoan<0){
                            System.out.println("Can not repay loan in negative");
                        }
                        else{
                            double minusLoan = accountCheck.loan(currentUser);
                            minusLoan-=repayLoan;
                            accountCheck.updateLoan(currentUser, minusLoan);
                            accountCheck.saveToFile();
                            System.out.println("Loan repayed.");    
                        }
                        double loanCheck = accountCheck.loan(currentUser);
                        System.out.printf("\nCurrent loan : %s\n\n", money.format(loanCheck));
                        UI.pause(sc);
                    }

                    case 5 -> {
                        //withdraw
                        double balance = accountCheck.balance(currentUser);
                        System.out.printf("\033[1mCurrent balance :\033[0m %s\n\n", money.format(balance));

                        System.out.print("Give an amount to withdraw: ");
                        double withdraw = sc.nextDouble();
                        sc.nextLine();

                        if (withdraw >= balance ) {
                            System.out.println("\n\n\033[1m\033[31mCannot withdraw more than balance \033[0m");
                        } else if (withdraw < 0) {
                            System.out.println("\n\n\033[1m\033[31mCannot withdraw negative amount.\033[0m");
                        } else if(balance - withdraw < 100){
                            System.out.println("\n\n\033[1m\033[31mCannot withdraw everything\033[0m \033[1m(keep minimum $100).\033[0m");
                        } else{
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
                        System.out.println("\n\n\n\033[32m\033[1mThank you for trusting us!\033[0m");
                        System.exit(0);
                    }

                    default -> {
                        System.out.println("\033[31mWrong input\033[0m");
                        UI.pause(sc);
                    }
                }
            }
        }
    }
}
// importing packages
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import pages.Pages;
import pages.bankExceptions.existingLoan;
import pages.bankExceptions.insufficientBalance;
import pages.bankExceptions.invalidAmount;
import pages.bankExceptions.invalidInput;
import pages.bankExceptions.similarUser;
import ui.UI;
import users.Creating;
import users.Loan;
import users.Login;
import users.UsersStorage;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            // shows dollar sign
            NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);

            // Building objects
            Pages page = new Pages();
            UsersStorage accountCheck = new UsersStorage();
            Loan loanLogic = new Loan(accountCheck);
            

                // to use lator on, so entire screen knows currentuser
            String currentUser = null;
            String currentAccount = null;
            double balance = 0;
            //-----------------------------------
            // LOGIN LOOP
            
            boolean loop_1 = true;
            while (loop_1) {

                UI.clearScreen();
                page.homeScreen(); //calls home screen from pages

                try{
                     int homeScreenPage = sc.nextInt();
                sc.nextLine();

                UI.clearScreen();

                switch (homeScreenPage) {
                    case 0->{
                        System.out.print("Logging out...");
                        System.out.println("\n\n\n\033[32m\033[1mThank you for trusting us!\033[0m");
                        UI.pause(sc);
                        System.exit(0); // ends the system, succesfully. Here 0 means normal/succesfully 
                    }
                    case 1 -> {
                        page.loginScreen();         
                        Login.Account result = Login.handleLogin(sc, accountCheck);

                        if (result != null) {
                            currentUser = result.currentUser;
                            currentAccount = result.currentAccount;
                            balance = accountCheck.balance(currentUser);
                        }
                    }
                    case 2 -> {
                        page.createScreen();
                        System.out.print("Select account type: ");
                        try{
                            int selectAccountType = sc.nextInt();
                            sc.nextLine();
                            if(selectAccountType==1||selectAccountType==2){
                                Creating.creating(sc,accountCheck, selectAccountType);
                            } else {
                                page.invalidInput();
                            }
                        } catch(Exception e){
                            page.invalidInput();
                            UI.pause(sc);
                        }

                        
                    }
                    case 3 -> {
                        accountCheck.changePassword(sc);
                        UI.pause(sc);
                    }
                    default -> {
                        continue;
                    }
                }
                } catch(Exception e){
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

                
                try {
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
                        System.out.printf(" Account Type  :  %s\n ", currentAccount); 
                        System.out.printf("Balance       :  %s\n", money.format(user.balance)); 
                        System.out.printf(" Loan          :  %s\n", user.loan);
                        System.out.println("---------------------------");
                        UI.pause(sc);
                    }
                    case 2 -> {
                        //balance
                        page.showBalance(currentUser, accountCheck);
                        UI.pause(sc);
                    }

                    case 3 -> {
                        //take loan
                        double loan = accountCheck.loan(currentUser);
                        page.showLoan(currentUser, accountCheck);

                        try {
                            if (loan != 0) { throw new existingLoan(); }
                            loanLogic.takingLoan(sc, currentUser, currentAccount);
                        } catch (existingLoan e) {
                            System.out.println(e.getMessage());
                        }
                        UI.pause(sc);
                    }

                    case 4 ->{
                        // repay loan
                        loanLogic.repayingLoan(sc, currentUser);
                    }

                    case 5 -> {
                        //withdraw
                        page.showBalance(currentUser, accountCheck);
                        System.out.println("\033[1mEnter 0 to go back.\033[0m\n\n");
                        System.out.print("Give an amount to withdraw: ");

                        try {

                            double withdraw = sc.nextDouble();
                            sc.nextLine();
                        
                            balance = accountCheck.balance(currentUser);
                        
                            if (withdraw == 0){ 
                                break; 
                            }
                            else if (withdraw < 0 || withdraw > balance || (balance-withdraw<100)){ 
                                throw new insufficientBalance(); 
                            }
                
                            balance -= withdraw;
                            accountCheck.updateBalance(currentUser, balance);
                            accountCheck.saveToFile();
                        
                        } catch (insufficientBalance e) {
                            System.out.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println(new invalidInput().getMessage());
                            sc.nextLine();
                        }
                        System.out.printf("\nCurrent balance is: %s\n", money.format(accountCheck.balance(currentUser)));
                        UI.pause(sc);
                    }

                    case 6 -> {
                        //deposit
                        page.showBalance(currentUser, accountCheck);
                        System.out.println("\033[1mEnter 0 to go back.\033[0m\n\n");
                        System.out.print("Give an amount to deposit: ");

                        try {
                            double deposit = sc.nextDouble();
                            sc.nextLine();
                        
                            if (deposit == 0)  { break; }
                            if (deposit < 0)   { throw new invalidAmount(); }
                        
                            balance = accountCheck.balance(currentUser);
                            balance += deposit;
                            accountCheck.updateBalance(currentUser, balance);
                            accountCheck.saveToFile();
                        
                        } catch (invalidAmount e) {
                            System.out.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println(new invalidInput().getMessage());
                            sc.nextLine();
                        }
                    
                        System.out.printf("\nCurrent balance is: %s\n", money.format(accountCheck.balance(currentUser)));
                        UI.pause(sc);
                    }

                    case 7 -> {
                        balance = accountCheck.balance(currentUser);
                        System.out.printf("Current balance is: %s\n\n", money.format(balance));
                        System.out.println("\033[1mEnter \"back\" to go back.\033[0m");

                        while (true) {
                            System.out.print("Enter username of the recipient: ");
                        
                            try {
                                String recipient = sc.nextLine();
                            
                                if (recipient.isEmpty()) {
                                    throw new invalidInput();
                                } else if (recipient.equals("back")) {
                                    break;
                                } else if (recipient.equals(currentUser)) {
                                    throw new similarUser();
                                }
                            
                                if (!accountCheck.recipientCheck(recipient)) {
                                    System.out.println("\033[1m\033[31mUser not found.\033[0m");
                                    continue;
                                }
                            
                                System.out.println("\033[1m\033[32mUser found!\033[0m");
                                System.out.print("Enter amount to transfer: ");
                            
                                double payRecipient = sc.nextDouble();
                                sc.nextLine();
                            
                                if (payRecipient > balance) {
                                    throw new insufficientBalance();
                                }
                            
                                balance -= payRecipient;
                                accountCheck.updateBalance(currentUser, balance);
                                accountCheck.updateBalance(recipient, accountCheck.balance(recipient) + payRecipient);
                                accountCheck.saveToFile();
                                System.out.println("\033[1m\033[32mTransfer successful.\033[0m");
                                break;
                            
                            } catch (InputMismatchException e) {
                                System.out.println("\033[1m\033[31mNumbers only.\033[0m");
                                sc.nextLine();
                            } catch (insufficientBalance | similarUser | invalidInput e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    
                        double balanceRecheck = accountCheck.balance(currentUser);
                        System.out.printf("\nCurrent balance is: %s\n", money.format(balanceRecheck));
                        UI.pause(sc);
                    }

                    case 8 -> {
                        //exit
                        UI.clearScreen();
                        System.out.println("\n\n\n\033[32m\033[1mThank you for trusting us!\033[0m");
                        System.exit(0);
                    }

                    default -> {
                        page.invalidInput();
                        UI.pause(sc);
                    }
                }
                } catch (Exception e) {
                    UI.pause(sc);
                }
                
            }
        }
    }
}
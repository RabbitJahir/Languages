// importing packages
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import pages.Pages;
import ui.UI;
import users.Creating;
import users.Login;
import users.UsersStorage;
import users.Loan;

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
                            }
                            page.invalidInput();
                        } catch(Exception e){
                            page.invalidInput();
                            UI.pause(sc);
                        }

                        
                    }
                    case 3 -> {
                        System.out.println("soon");
                    }
                    default -> {
                        page.invalidInput();
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

                    case 3 ->{
                        // take Loan
                        double loan = accountCheck.loan(currentUser);
                        page.showLoan(currentUser, accountCheck);
                        
                        if(loan!=0){
                            System.out.println("\033[1m\033[31mPay previous loan first!");
                           
                        } else {

                            if(currentAccount.equals("personal")){

                                loanLogic.takingLoan(sc, currentUser, currentAccount);

                            } else if(currentAccount.equals("saving")){

                                loanLogic.takingLoan(sc, currentUser, currentAccount);
                            }
                        
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
                        
                        try{
                            double withdraw = sc.nextDouble();
                            sc.nextLine();

                             if (withdraw >= balance ) {
                            System.out.println("\n\n\033[1m\033[31mInsufficient balance.\033[0m");
                            } else if(withdraw==0){
                            break;
                            } else if (withdraw < 0) {
                                page.invalidInput();
                            } else if(balance - withdraw < 100){
                                System.out.println("\n\n\033[1m\033[31mCannot withdraw everything\033[0m \033[1m(keep minimum $100).\033[0m");
                            } else{
                                balance -= withdraw;
                                accountCheck.updateBalance(currentUser, balance);
                                accountCheck.saveToFile();
                            }
                        } catch(Exception e){
                            page.invalidInput();
                            sc.nextLine(); // catches the lingering exception
                        }
                       

                        System.out.printf("\nCurrent balance is: %s\n", money.format(balance));
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
                        if (deposit < 0) {
                            System.out.println("\033[1m\033[31mCannot deposit negative amount.\033[0m");
                        } else if(deposit==0){
                            break;
                        } else {
                            balance += deposit;
                            accountCheck.updateBalance(currentUser, balance);
                            accountCheck.saveToFile();
                        }

                        } catch (Exception e) {
                            page.invalidInput();
                            sc.nextLine(); // catches thel ingering exception to prevent from going into UI.pause
                        }

                        System.out.printf("\nCurrent balance is: %s\n", money.format(balance));
                        UI.pause(sc);
                    }

                    case 7 -> {
                        //transfer
                        System.out.printf("Current balance is: %s\n\n", money.format(balance));
                        System.out.println("\033[1mEnter \"back\" to go back.\033[0m");

                        while(true){
                            System.out.print("Enter username of the recipient: ");
                            
                            String recipient = sc.nextLine();

                            if(recipient.isEmpty()){
                                System.out.println("\033[1m\033[31mUsername can not be empty.\033[0m");
                            } else if(recipient.equals("back")){
                            break;
                            } else{
                                
                                if(accountCheck.recipientCheck(recipient) == true){
                                    System.out.println("\033[1m\033[32mUser found!\033[0m");

                                
                                    try{
                                        System.out.print("Enter amount to transfer: ");
                                        Double payRecipient = sc.nextDouble();
                                        sc.nextLine();
                                        if (payRecipient>balance) {
                                            System.out.println("\033[1m\033[33mInsufficient balance.\033[0m");
                                        } else {
                                            balance -= payRecipient;
                                        accountCheck.updateBalance(currentUser, balance);
                                        
                                        payRecipient += accountCheck.balance(recipient);
                                        accountCheck.updateBalance(recipient, payRecipient);
                                        accountCheck.saveToFile();
                                        }
                                        
                                    } catch(Exception e) {
                                        page.invalidInput();
                                        sc.nextLine(); // catches thel ingering exception to prevent from going into UI.pause
                                    }
                                    
                                    break;
                                } else {
                                    System.out.println("\033[1m\033[31mUser not found\033[0m");
                                    
                                    break;
                                }
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
                        System.out.println("\033[31mWrong input\033[0m");
                        UI.pause(sc);
                    }
                }
            }
        }
    }
}
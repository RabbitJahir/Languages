// pages
import backend.Login;
import pages.Pages;
import users.Users;
import backend.UsersStorage;
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
            Users accounts = new Users();
            Pages page = new Pages();
            Login backLogic = new Login();
            UsersStorage accountCheck = new UsersStorage();

            String currentUser = null;

            // HOME PAGE
            
            UI.clearScreen();
            page.homePage();

            int accountType = sc.nextInt();
            sc.nextLine();

            
            // LOGIN SCREEN 
            
            UI.clearScreen();

            switch (accountType) {
                case 1 -> {
                    accounts.shared();
                    currentUser = Users.handleLogin(sc, backLogic, accountCheck);
                }
                case 2 -> {
                    accounts.personal();
                    currentUser = Users.handleLogin(sc, backLogic, accountCheck);
                }
                default -> {
                    System.out.println("Invalid choice");
                    return;
                }
            }

            if (currentUser == null) return;

            // USER MENU LOOP
            
            boolean userLoop = true;

            while (userLoop) {

                UI.clearScreen();

                accounts.userHub();
                int userHubChoose = sc.nextInt();
                sc.nextLine();

                switch (userHubChoose) {
                    case 1 -> {
                        // show balance
                        double balance = accounts.balance(currentUser);
                        System.out.println("Current Balance: "+money.format(balance));
                        UI.pause(sc);
                    }

                    case 2 -> {
                        //show account type
                        String accType = accounts.accType(currentUser);
                        System.out.println("Account type: " + accType);
                        UI.pause(sc);
                    }

                    case 3 -> {
                        //shows balance
                        double balance = accounts.balance(currentUser);
                        System.out.printf("Current balance is: %.2f\n\n", balance);
                        // withdraw
                        System.out.print("Give an amount to withdraw: ");
                        double withdraw = sc.nextDouble();
                        sc.nextLine();
                        //withdraw logic
                        if(withdraw>=balance){
                            System.out.println("Can not withdraw more than available balance, must have at least $ 100 left in balance");
                        } else if(withdraw<0){
                            System.out.println("Can not withdraw in negative amounts.");
                        } else {
                            balance-=withdraw;
                        }
                        System.out.printf("\nCurrent balance is: %.2f\n", balance);
                        UI.pause(sc);
                    }

                    case 4 -> {
                         //shows balance
                        double balance = accounts.balance(currentUser);
                        System.out.printf("Current balance is: %.2f\n\n", balance);
                        // deposit
                        System.out.print("Give an amount to deposit: ");
                        double deposit = sc.nextDouble();
                        sc.nextLine();
                        //deposit logic
                        if(deposit<0){
                            System.out.println("Can not deposit negative numbers.");
                        } else {
                            balance+=deposit;
                        }
                        System.out.printf("\nCurrent balance is: %.2f\n", balance);
                        UI.pause(sc);
                    }

                    case 5 -> {
                        System.out.println("transfer");
                        UI.pause(sc);
                    }

                    case 6 -> {
                        UI.clearScreen();
                        System.out.println("Exiting.\nThank you for trusting us!");
                        userLoop = false;
                    }

                    default -> {
                        System.out.println("wrong input");
                        UI.pause(sc);
                    }
                }
            }
        }
    }
}
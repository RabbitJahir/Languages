package users;

import java.util.Scanner;

import backend.Login;
import backend.UsersStorage;

public class Users implements AccountTypes{

    public void shared(){
        System.out.print("-----------------------------\n");
        System.out.print("  SHARED ACCOUNTS\n");
        System.out.print("-----------------------------\n");
    }

    public void personal(){
        System.out.print("-----------------------------\n");
        System.out.print("  PERSONAL ACCOUNTS\n");
        System.out.print("-----------------------------\n");
    }

    //user hub, user ra ja ja dekhbe
    public void userHub(){
        System.out.print("1. Check Balance\n");
        System.out.print("2. Check Account Type\n");
        System.out.print("3. Withdraw from Balance\n");
        System.out.print("4. Deposit into Balance\n");
        System.out.print("5. Transfer Balance\n");
        System.out.print("6. Exit\n\n");
        System.out.print("Choose: ");
    }
    //BALANCE dekhbe
        private user[] balance ={
        new user("Kamrul", "10x", 12000),
        new user("Rabbit", "Rabbit",20000),
        new user("Mamunur", "Hyped",20000),
        new user("Ismail", "Owl",20000),
    };

    class user{
        String currentUser;
        String accountType;
        double balance;
        user(String currentUser, String accountType, double balance){
            this.currentUser = currentUser;
            this.accountType = accountType;
            this.balance = balance;
        }
    }

     // LOGIN HANDLER
    public static String handleLogin(Scanner sc, Login backLogic, UsersStorage accountCheck) {

        backLogic.accountName();
        String username = sc.nextLine();

        backLogic.password();
        String password = sc.nextLine();

        String currentUser = accountCheck.login(username, password);

        if (currentUser != null) {
            System.out.println("-----------------------------");
            System.out.printf("Welcome %s \n", currentUser);
            System.out.println("-----------------------------");
            return currentUser;
        } else {
            System.out.println("User not found or password wrong.");
            return null;
        }
    }
    //Balance show
    public double balance(String currentUser){
        for(user bal : balance){
            if(bal.currentUser.equals(currentUser)){
                return bal.balance;
            }
        }
        return -1;
    }
    //Account type show
    public String accType(String currentUser){
        for(user bal : balance){
            if(bal.currentUser.equals(currentUser)){
                return bal.accountType;
            }
        }
        return null;
    }
}
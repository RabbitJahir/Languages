package users;

import java.util.Scanner;

public class Login {   

    public static class Account {
    public String currentUser;
    public String currentAccount;

    public Account(String currentUser, String currentAccount){
        this.currentUser = currentUser;
        this.currentAccount = currentAccount;
    }
}

    // LOGIN HANDLER method
    public static Account handleLogin(Scanner sc, UsersStorage accountCheck) {

        System.out.print("Enter Account Name: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        String currentUser = accountCheck.login(username, password);
         
        if (currentUser != null) {
            String currentAccount = accountCheck.accountType(username);
            return new Account(currentUser, currentAccount);
        } else {
            System.out.println("\n\033[31m\033[1mUser not found or password wrong.\033[0m");
            System.out.println("\n\033[1m\033[31mLogin failed. Try again.\033[0m");
            return null;
        }
    }

   
}
package users;

import java.util.Scanner;

public class Login {   

    // LOGIN HANDLER
    public static String handleLogin(Scanner sc, UsersStorage accountCheck) {

        System.out.print("Enter Account Name: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        String currentUser = accountCheck.login(username, password);

        if (currentUser != null) {
            
            return currentUser;
        } else {
            System.out.println("\n\033[31m\033[1mUser not found or password wrong.\033[0m");
            System.out.println("\n\033[1m\033[31mLogin failed. Try again.\033[0m");
            return null;
        }
    }

   
}
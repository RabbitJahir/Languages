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
            System.out.println("\nUser not found or password wrong.");
            System.out.println("Login failed. Try again.");
            return null;
        }
    }

   
}
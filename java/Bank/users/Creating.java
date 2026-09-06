package users;

import java.util.Scanner;

public class Creating {
    public static void creating(Scanner sc, UsersStorage accountCheck, int selectAccountType) {

        String username;
        while (true) {
            System.out.print("Enter username: ");
            username = sc.nextLine().trim();
            if (!username.isEmpty()) break;
            System.out.println("Username cannot be empty!");
        }

        String password;
        while (true) {
            System.out.print("Enter password: ");
            password = sc.nextLine().trim();
            if (!password.isEmpty()) break;
            System.out.println("Password cannot be empty!");
        }

        String mobile;
        while (true) {
            System.out.print("Enter mobile number: ");
            mobile = sc.nextLine().trim();

// \d = 0,1,2,3,4,5,6,7,8,9 | \\ to represent \ | d+ can contain more than one digits, but must contain  digits
            if (!mobile.isEmpty() && mobile.matches("\\d+")) {
                break;
            }

            System.out.println("Mobile must contain numbers only and cannot be empty!");
        }
        
        String type="";
        double balance=0;
        switch(selectAccountType){
            case 1 ->{    
                type = "personal";
                while(true){
                    System.out.print("Deposit $ 500: ");
                    balance = sc.nextDouble();
                if(balance>=500){
                    break;
                }
                System.out.println("Must deposit more than $ 500.");
                }
            }
            case 2->{
                type = "saving";
                break;
            }
        }

        boolean created = accountCheck.createUser(username, password, type, mobile, balance, 0.0);

        if (created) {
            accountCheck.saveToFile();
        }

    }

}
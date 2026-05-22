package users;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class UsersStorage {


    final private HashMap<String, User> users = new HashMap<>();

    // used in Login, Creating, main, to display or get information/ balance / loan
    public UsersStorage() {

        loadFromFile();
    }

    public void saveToFile() {

        //java.io.FileWriter; 
        // creates a single string, in a row
        // FileWriter overrides the entire system every time its changed / saved
        try (FileWriter fw = new FileWriter("users.txt")) {

            for (User u : users.values()) {
                fw.write(
                    u.username + "," +
                    u.password + "," +
                    u.accountType + "," +
                    u.mobile + "," +
                    u.balance + ","+
                    u.loan + "\n"
                );
            }

            System.out.println("\033[32mData saved successfully.\033[0m");

        } catch (IOException error) {
            System.out.println("\033[31mError saving file.\033[0m");
        }
    }

    // used in UsersStorage
    public void loadFromFile() {

        //FileReader opens the file, BufferedReader reads line by line
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {

            String line;

            // reads single lines at a time
            while ((line = br.readLine()) != null) {

                // splits each line using commas, making an array data[]
                String data[] = line.split(",");

                //checks to make sure each line has 6 inputs
                if (data.length == 6) {

                    users.put(data[0], new User(
                            data[0],
                            data[1],
                            data[2],
                            data[3],
                            //converts text back to double
                            Double.parseDouble(data[4]),
                            Double.parseDouble(data[5])
                    ));
                }
            }

        } catch (IOException e) {
            System.out.println("No previous data found.");
        }
    }



    // USER CLASS, making a blueprint for all users
    public class User {
        public String username;
        String password;
        public String accountType;
        public String mobile;
        public double balance;
        public double loan;

    User(String username, String password, String accountType, String mobile, double balance, double loan) {
            this.username = username;
            this.password = password;
            this.accountType = accountType;
            this.mobile = mobile;
            this.balance = balance;
            this.loan = loan;
        }
    }

    // used in Login page
    public String login(String username, String password) {

        // goes to User class, and matches in HashMap users
        User u = users.get(username);

        // u.password = user input password .matches(stored password)
        if (u != null && u.password.equals(password)) {
            return username;
        }

        return null;
    }

    public String accountType(String currentUser){
        User u = users.get(currentUser);
        return (u!=null)? u.accountType:null;
    }
     // USER INTERFACES
     // Balance
    public double balance(String currentUser) {
        User u = users.get(currentUser);
        return (u != null) ? u.balance : 0.0;
    }

    //LOAnnnn
     public double loan(String currentUser){
        User u = users.get(currentUser);
        return (u != null) ? u.loan : 0.0;
    }

    //Blance update
    public void updateBalance(String currentUser, double newBalance) {
        User u = users.get(currentUser);
        if (u != null) {
            u.balance = newBalance;
        }
    }

    // loan update
    public void updateLoan(String currentUser, double minusLoan){
        User u = users.get(currentUser);
        if(u!=null){
            u.loan= minusLoan;
        }
    }

    
    public User getUser(String username) {
        return users.get(username);
    }

    public void changePassword(Scanner sc){
        pages.Pages.changePassword();
        System.out.print("Enter username: ");
        String usernameCheck = sc.nextLine();

        System.out.print("Enter mobile number: ");
        String mobileNumber = sc.nextLine();

        User u = users.get(usernameCheck);

        if (u != null && u.mobile.equals(mobileNumber)) {

            System.out.print("Enter new password: ");
            String newPass = sc.nextLine();

            u.password = newPass;

            saveToFile();

            System.out.println("\033[1m\033[33mSuccessfully changed password\033[0m");

        } else {
            System.out.println("\033[1m\033[31mMobile number or Username does not match.\033[0m");
        }
    }

    // creating
     public boolean createUser(String username, String password, String accountType, String mobile, Double balance, Double loan) {

        //checking usernames, containsKey is a method of HashMap
        if (users.containsKey(username)) {
            System.out.println("\033[31mUsername already exists!\033[0m");
            return false;
        }

        User newUser = new User(username, password, accountType, mobile, balance, 0.0);

        users.put(username, newUser);

        System.out.println("\033[32mAccount created successfully!\033[0m");

        return true;
    }

    public boolean recipientCheck(String recipient){
        User u = users.get(recipient);
        if(u!=null){
            return true;
        } else {
            return false;
        }
    }
   

}
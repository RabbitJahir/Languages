package users;

import java.util.HashMap;
import java.io.*;

public class UsersStorage {


    private HashMap<String, User> users = new HashMap<>();

    public UsersStorage() {

        loadFromFile();
    }

    public void saveToFile() {

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

            System.out.println("Data saved successfully.");

        } catch (IOException error) {
            System.out.println("Error saving file.");
        }
    }

    public void loadFromFile() {

        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {

                String data[] = line.split(",");

                if (data.length == 6) {

                    users.put(data[0], new User(
                            data[0],
                            data[1],
                            data[2],
                            data[3],
                            Double.parseDouble(data[4]),
                            Double.parseDouble(data[5])
                    ));
                }
            }

        } catch (IOException e) {
            System.out.println("No previous data found.");
        }
    }



    // USER CLASS
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

    public String login(String username, String password) {

        User u = users.get(username);

        if (u != null && u.password.equals(password)) {
            return username;
        }

        return null;
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
        return u.loan;
    }

    //Blance update
    public void updateBalance(String currentUser, double newBalance) {
        User u = users.get(currentUser);
        if (u != null) {
            u.balance = newBalance;
        }
    }

    // loan update
    public void updateLoan(String currentUser, double newLoan){
        User u = users.get(currentUser);
        if(u!=null){
            u.loan= newLoan;
        }
    }

    
    public User getUser(String username) {
        return users.get(username);
    }

    // creating
     public boolean createUser(String username, String password, String accountType, String mobile, Double balance, Double loan) {

        if (users.containsKey(username)) {
            System.out.println("Username already exists!");
            return false;
        }

        User newUser = new User(username, password, accountType, mobile, 0.0, 0.0);

        users.put(username, newUser);

        System.out.println("Account created successfully!");

        return true;
    }

   

}
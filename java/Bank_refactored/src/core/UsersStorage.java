package core;

import core.BankException.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Repository + business rules for users. No console I/O here at all -
 * both the terminal UI and the JavaFX UI call these same methods and
 * decide for themselves how to display the result.
 */
public class UsersStorage {

    private static final String USERS_FILE = "users.txt";
    private static final String TX_FILE = "transactions.txt";

    private final Map<String, User> users = new HashMap<>();

    public UsersStorage() {
        loadFromFile();
        loadTransactions();
    }

    // ---------- persistence ----------

    public void saveToFile() {
        try (FileWriter fw = new FileWriter(USERS_FILE)) {
            for (User u : users.values()) {
                fw.write(u.username + "," + u.password + "," + u.accountType + "," +
                        u.mobile + "," + u.balance + "," + u.loan + "\n");
            }
        } catch (IOException e) {
            throw new BankException("Could not save user data: " + e.getMessage());
        }
        saveTransactions();
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d.length == 6) {
                    users.put(d[0], new User(d[0], d[1], d[2], d[3],
                            Double.parseDouble(d[4]), Double.parseDouble(d[5])));
                }
            }
        } catch (IOException e) {
            // no previous data - fine on first run
        }
    }

    private void saveTransactions() {
        try (FileWriter fw = new FileWriter(TX_FILE)) {
            for (User u : users.values()) {
                for (Transaction t : u.history) {
                    fw.write(u.username + "~" + t.toCsv() + "\n");
                }
            }
        } catch (IOException e) {
            throw new BankException("Could not save transaction history: " + e.getMessage());
        }
    }

    private void loadTransactions() {
        try (BufferedReader br = new BufferedReader(new FileReader(TX_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                int idx = line.indexOf('~');
                if (idx < 0) continue;
                String username = line.substring(0, idx);
                User u = users.get(username);
                if (u != null) {
                    try {
                        u.history.add(Transaction.fromCsv(line.substring(idx + 1)));
                    } catch (Exception ignored) { /* skip malformed line */ }
                }
            }
        } catch (IOException e) {
            // no previous data - fine on first run
        }
    }

    // ---------- lookups ----------

    public User getUser(String username) {
        return users.get(username);
    }

    public String login(String username, String password) {
        User u = users.get(username);
        if (u != null && u.password.equals(password)) return username;
        return null;
    }

    public String accountType(String username) {
        User u = users.get(username);
        return (u != null) ? u.accountType : null;
    }

    public double balance(String username) {
        User u = users.get(username);
        return (u != null) ? u.balance : 0.0;
    }

    public double loan(String username) {
        User u = users.get(username);
        return (u != null) ? u.loan : 0.0;
    }

    public boolean recipientCheck(String recipient) {
        return users.get(recipient) != null;
    }

    // ---------- mutations ----------

    public void updateBalance(String username, double newBalance) {
        User u = users.get(username);
        if (u != null) u.balance = newBalance;
    }

    public void updateLoan(String username, double newLoan) {
        User u = users.get(username);
        if (u != null) u.loan = newLoan;
    }

    /** Records a transaction against the user's history using their CURRENT balance as balanceAfter. */
    public void addTransaction(String username, String type, double amount) {
        User u = users.get(username);
        if (u == null) return;
        u.history.add(new Transaction(type, amount, LocalDateTime.now(), u.balance));
    }

    public boolean createUser(String username, String password, String accountType,
                               String mobile, double balance, double loan) {
        if (users.containsKey(username)) {
            throw new UserExistsException();
        }
        users.put(username, new User(username, password, accountType, mobile, balance, loan));
        return true;
    }

    /** Changes password after verifying username+mobile match. Throws if they don't. */
    public void changePassword(String username, String mobile, String newPassword) {
        User u = users.get(username);
        if (u == null || !u.mobile.equals(mobile)) {
            throw new BankException("Mobile number or username does not match.");
        }
        u.password = newPassword;
        saveToFile();
    }
}

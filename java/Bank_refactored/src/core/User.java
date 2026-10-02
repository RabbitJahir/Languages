package core;

import java.util.ArrayList;
import java.util.List;

public class User {
    public final String username;
    String password;
    public final String accountType;
    public final String mobile;
    public double balance;
    public double loan;
    public final List<Transaction> history = new ArrayList<>();

    public User(String username, String password, String accountType, String mobile,
                double balance, double loan) {
        this.username = username;
        this.password = password;
        this.accountType = accountType;
        this.mobile = mobile;
        this.balance = balance;
        this.loan = loan;
    }
}

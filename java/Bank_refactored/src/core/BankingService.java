package core;

import core.BankException.*;

public class BankingService {

    private final UsersStorage storage;

    public BankingService(UsersStorage storage) {
        this.storage = storage;
    }

    public void deposit(String username, double amount) {
        if (amount <= 0) throw new InvalidAmountException();
        double balance = storage.balance(username) + amount;
        storage.updateBalance(username, balance);
        storage.addTransaction(username, "DEPOSIT", amount);
        storage.saveToFile();
    }

    /** Keeps a $100 minimum balance, matching the original rule. */
    public void withdraw(String username, double amount) {
        double balance = storage.balance(username);
        if (amount <= 0 || amount > balance || (balance - amount) < 100) {
            throw new InsufficientBalanceException();
        }
        storage.updateBalance(username, balance - amount);
        storage.addTransaction(username, "WITHDRAW", amount);
        storage.saveToFile();
    }

    public void transfer(String sender, String recipient, double amount) {
        if (recipient.equals(sender)) throw new SimilarUserException();
        if (!storage.recipientCheck(recipient)) throw new UserNotFoundException();

        double senderBalance = storage.balance(sender);
        if (amount <= 0 || amount > senderBalance) throw new InsufficientBalanceException();

        storage.updateBalance(sender, senderBalance - amount);
        storage.updateBalance(recipient, storage.balance(recipient) + amount);
        storage.addTransaction(sender, "TRANSFER_OUT", amount);
        storage.addTransaction(recipient, "TRANSFER_IN", amount);
        storage.saveToFile();
    }

    public void changePassword(String username, String mobile, String newPassword) {
        storage.changePassword(username, mobile, newPassword);
    }
}

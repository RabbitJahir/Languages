package core;

import core.BankException.*;

public class Loan {

    private final UsersStorage storage;

    public Loan(UsersStorage storage) {
        this.storage = storage;
    }

    /**
     * Issues a loan to a user.
     * @throws ExistingLoanException  user already has an active loan
     * @throws InvalidAmountException amount out of range for the account type
     * @throws InvalidDurationException duration not one of 3/6/12/24
     */
    public void takingLoan(String username, String accountType, double amount, int months) {
        if (storage.loan(username) != 0) throw new ExistingLoanException();

        double min = 100;
        double max = accountType.equals("personal") ? 50000 : 7000;
        if (amount < min || amount > max) throw new InvalidAmountException();

        if (months != 3 && months != 6 && months != 12 && months != 24) {
            throw new InvalidDurationException();
        }

        double rate = accountType.equals("personal") ? 0.20 : 0.13;
        double totalPayable = amount + (amount * rate);

        storage.updateLoan(username, totalPayable);
        storage.addTransaction(username, "LOAN", amount);
        storage.saveToFile();
    }

    /**
     * Repays part or all of an active loan.
     * @param fromBalance if true, amount is also deducted from the user's balance;
     *                    if false, caller is paying in cash (balance untouched)
     * @throws InvalidAmountException amount <= 0 or greater than remaining loan
     * @throws InsufficientBalanceException paying from balance but balance too low
     */
    public void repayingLoan(String username, double amount, boolean fromBalance) {
        double loan = storage.loan(username);
        if (loan == 0) throw new InvalidAmountException("No active loan to repay.");
        if (amount <= 0 || amount > loan) throw new InvalidAmountException();

        if (fromBalance) {
            double balance = storage.balance(username);
            if (amount > balance) throw new InsufficientBalanceException();
            storage.updateBalance(username, balance - amount);
        }

        storage.updateLoan(username, loan - amount);
        storage.addTransaction(username, "REPAYMENT", amount);
        storage.saveToFile();
    }
}

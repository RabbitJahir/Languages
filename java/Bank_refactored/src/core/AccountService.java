package core;

import core.BankException.InvalidAmountException;
import core.BankException.InvalidInputException;

public class AccountService {

    public static final int PERSONAL = 1;
    public static final int SAVINGS = 2;
    public static final double PERSONAL_MIN_DEPOSIT = 500;

    /**
     * Validates and creates a new account.
     * @param accountTypeChoice PERSONAL (1) or SAVINGS (2)
     * @param initialDeposit    only used/required for PERSONAL accounts
     * @throws InvalidInputException  bad username/password/mobile/account type
     * @throws InvalidAmountException personal account deposit below minimum
     * @throws core.BankException.UserExistsException username taken
     */
    public static void createAccount(UsersStorage storage, String username, String password,
                                      String mobile, int accountTypeChoice, double initialDeposit) {

        if (username == null || username.isBlank()) 
            throw new InvalidInputException("Username cannot be empty.");
        if (password == null || password.isBlank()) 
            throw new InvalidInputException("Password cannot be empty.");
        if (mobile == null || !mobile.matches("\\d+")) {
            throw new InvalidInputException(
                "Mobile must contain digits only and cannot be empty.");
        }

        String type;
        double balance;

        if (accountTypeChoice == PERSONAL) {
            type = "personal";
            if (initialDeposit < PERSONAL_MIN_DEPOSIT) {
                throw new InvalidAmountException("Personal account requires a deposit of at least $" + (int) PERSONAL_MIN_DEPOSIT + ".");
            }
            balance = initialDeposit;
        } else if (accountTypeChoice == SAVINGS) {
            type = "saving";
            balance = 0;
        } else {
            throw new InvalidInputException("Invalid account type.");
        }

        storage.createUser(username.trim(), password.trim(), type, mobile.trim(), balance, 0.0);
        storage.saveToFile();
    }
}

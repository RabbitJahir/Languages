package core;

import core.BankException.InvalidCredentialsException;

public class AuthService {

    public static class Session {
        public final String username;
        public final String accountType;
        public Session(String username, String accountType) {
            this.username = username;
            this.accountType = accountType;
        }
    }

    /** @throws InvalidCredentialsException if login fails */
    public static Session login(UsersStorage storage, String username, String password) {
        String result = storage.login(username, password);
        if (result == null) throw new InvalidCredentialsException();
        return new Session(result, storage.accountType(result));
    }
}

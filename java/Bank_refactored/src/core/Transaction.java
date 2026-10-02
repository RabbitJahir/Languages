package core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** One entry in a user's transaction history. Immutable value object. */
public class Transaction {

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public final String type;      // "DEPOSIT", "WITHDRAW", "TRANSFER_OUT", "TRANSFER_IN", "LOAN", "REPAYMENT"
    public final double amount;
    public final LocalDateTime time;
    public final double balanceAfter;

    public Transaction(String type, double amount, LocalDateTime time, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.time = time;
        this.balanceAfter = balanceAfter;
    }

    public String toCsv() {
        return type + "|" + amount + "|" + time.format(FMT) + "|" + balanceAfter;
    }

    public static Transaction fromCsv(String csv) {
        String[] p = csv.split("\\|");
        return new Transaction(p[0], Double.parseDouble(p[1]),
                LocalDateTime.parse(p[2], FMT), Double.parseDouble(p[3]));
    }

    @Override
    public String toString() {
        return String.format("[%s] %-12s %10.2f  (balance after: %.2f)",
                time.format(FMT), type, amount, balanceAfter);
    }
}

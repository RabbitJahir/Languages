# Bank App

## Layout
```
src/
  Main.java        launcher - asks GUI or Terminal, then hands off
  core/             business logic only, NO Scanner/println. Shared by both UIs.
    BankException.java        all custom exceptions (plain messages, no ANSI)
    User.java                 data model, holds transaction history
    Transaction.java          one history entry (type, amount, time, balanceAfter)
    UsersStorage.java         repository: load/save users.txt + transactions.txt
    AuthService.java          login
    AccountService.java       account creation + validation
    BankingService.java       deposit / withdraw / transfer
    Loan.java                 take loan / repay loan
    TransactionAlgorithms.java  hand-written merge sort (by amount, by date),
                                 binary search (by amount), linear search (by type)
  tbi/              terminal UI - println/Scanner only, calls core/
    TerminalApp.java, Pages.java, UI.java
  gui/              JavaFX UI - Scenes/Alerts only, calls the SAME core/ classes
    BankApp.java
```

Why split this way: the GUI and terminal interface never duplicate business
rules - both call `core.BankingService`, `core.Loan`, etc. If you change a
loan rule, you change it once in `core/Loan.java` and both UIs pick it up.

## Compile
Needs a JDK and the OpenJFX SDK/jmods (for the GUI half).

```
javac -d out --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls $(find src -name "*.java")
```

On Ubuntu you can `sudo apt install openjfx` and the module path is
`/usr/share/openjfx/lib`. On Windows/Mac, download the JavaFX SDK from
https://openjfx.io and point `--module-path` at its `lib` folder.

## Run
```
java --module-path /usr/share/openjfx/lib --add-modules javafx.controls -cp out Main
```
It will ask you to pick `1` (GUI) or `2` (Terminal) - both work off the same
`users.txt` / `transactions.txt` data files, so you can create an account in
one mode and log in from the other.

## Sorting & searching (for the report)
`core/TransactionAlgorithms.java`:
- **Merge sort** by amount and by date - O(n log n) time, O(n) space, stable.
- **Binary search** by exact amount - O(log n), requires the amount-sorted list.
- **Linear search** by transaction type - O(n), no pre-sort needed.

Exercised from menu option 8 in the terminal, and the "Transaction History"
screen in the GUI (sort/search buttons over a `TableView`).

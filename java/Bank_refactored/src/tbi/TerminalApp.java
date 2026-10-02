package tbi;

import core.*;
import core.BankException.*;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TerminalApp {

    public static void run(Scanner sc, UsersStorage accountCheck) {

        NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);
        Pages page = new Pages();
        Loan loanLogic = new Loan(accountCheck);
        BankingService bank = new BankingService(accountCheck);

        String currentUser = null;
        String currentAccount = null;

        // ---------------- LOGIN LOOP ----------------
        while (true) {
            UI.clearScreen();
            page.homeScreen();

            try {
                int choice = sc.nextInt();
                sc.nextLine();
                UI.clearScreen();

                switch (choice) {
                    case 0 -> {
                        System.out.println("\n\n\n\033[32m\033[1mThank you for trusting us!\033[0m");
                        UI.pause(sc);
                        System.exit(0);
                    }
                    case 1 -> {
                        page.loginScreen();
                        System.out.print("Enter Account Name: ");
                        String username = sc.nextLine();
                        System.out.print("Enter Password: ");
                        String password = sc.nextLine();
                        try {
                            AuthService.Session s = AuthService.login(accountCheck, username, password);
                            currentUser = s.username;
                            currentAccount = s.accountType;
                        } catch (InvalidCredentialsException e) {
                            page.error(e.getMessage());
                        }
                    }
                    case 2 -> {
                        page.createScreen();
                        System.out.print("Select account type: ");
                        try {
                            int type = sc.nextInt();
                            sc.nextLine();
                            String username, password, mobile;
                            System.out.print("Enter username: ");
                            username = sc.nextLine();
                            System.out.print("Enter password: ");
                            password = sc.nextLine();
                            System.out.print("Enter mobile number: ");
                            mobile = sc.nextLine();

                            double deposit = 0;
                            if (type == AccountService.PERSONAL) {
                                System.out.print("Deposit $500 or more: ");
                                deposit = sc.nextDouble();
                                sc.nextLine();
                            }

                            AccountService.createAccount(accountCheck, username, password, mobile, type, deposit);
                            page.success("Account created successfully!");
                        } catch (BankException e) {
                            page.error(e.getMessage());
                        } catch (InputMismatchException e) {
                            page.invalidInput();
                            sc.nextLine();
                        }
                    }
                    case 3 -> {
                        Pages.changePassword();
                        System.out.print("Enter username: ");
                        String u = sc.nextLine();
                        System.out.print("Enter mobile number: ");
                        String m = sc.nextLine();
                        System.out.print("Enter new password: ");
                        String p = sc.nextLine();
                        try {
                            accountCheck.changePassword(u, m, p);
                            page.success("Successfully changed password");
                        } catch (BankException e) {
                            page.error(e.getMessage());
                        }
                    }
                    default -> { continue; }
                }
            } catch (Exception e) {
                sc.nextLine();
            }

            if (currentUser != null) break;
            else UI.pause(sc);
        }

        // ---------------- USER MENU LOOP ----------------
        while (true) {
            try {
                UI.clearScreen();
                System.out.println("\033[1m-----------------------------");
                System.out.printf("    Welcome %s\n", currentUser);
                System.out.println("-----------------------------\033[0m");
                page.userHub();
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        User user = accountCheck.getUser(currentUser);
                        System.out.println("---------------------------");
                        System.out.printf(" Username      :  %s\n", user.username);
                        System.out.printf(" Phone         :  %s\n", user.mobile);
                        System.out.printf(" Account Type  :  %s\n", currentAccount);
                        System.out.printf(" Balance       :  %s\n", money.format(user.balance));
                        System.out.printf(" Loan          :  %s\n", user.loan);
                        System.out.println("---------------------------");
                        UI.pause(sc);
                    }
                    case 2 -> {
                        page.showBalance(currentUser, accountCheck);
                        UI.pause(sc);
                    }
                    case 3 -> {
                        if (currentAccount.equals("personal")) page.loanRulesScreenPersonal();
                        else page.loanRulesScreenSavings();
                        try {
                            System.out.print("\n\nAmount for loan: ");
                            double amount = sc.nextDouble();
                            sc.nextLine();
                            if (amount != 0) {
                                System.out.print("\nDuration in months (3, 6, 12, 24): ");
                                int months = sc.nextInt();
                                sc.nextLine();
                                loanLogic.takingLoan(currentUser, currentAccount, amount, months);
                                page.success("Successfully loan given.");
                            }
                        } catch (BankException e) {
                            page.error(e.getMessage());
                        } catch (InputMismatchException e) {
                            page.error("Numbers only.");
                            sc.nextLine();
                        }
                        page.showBalance(currentUser, accountCheck);
                        page.showLoan(currentUser, accountCheck);
                        UI.pause(sc);
                    }
                    case 4 -> {
                        double loan = accountCheck.loan(currentUser);
                        if (loan == 0) {
                            page.error("Currently no loan.");
                        } else {
                            page.showLoan(currentUser, accountCheck);
                            page.repayLoanScreen();
                            int option = sc.nextInt();
                            sc.nextLine();
                            if (option != 0) {
                                page.showBalance(currentUser, accountCheck);
                                System.out.print("Amount repaying: ");
                                try {
                                    double amount = sc.nextDouble();
                                    sc.nextLine();
                                    if (amount != 0) {
                                        loanLogic.repayingLoan(currentUser, amount, option != 1);
                                        page.success("Loan repaid.");
                                    }
                                } catch (BankException e) {
                                    page.error(e.getMessage());
                                } catch (InputMismatchException e) {
                                    page.error("Numbers only.");
                                    sc.nextLine();
                                }
                            }
                        }
                        page.showLoan(currentUser, accountCheck);
                        page.showBalance(currentUser, accountCheck);
                        UI.pause(sc);
                    }
                    case 5 -> {
                        page.showBalance(currentUser, accountCheck);
                        System.out.println("\033[1mEnter 0 to go back.\033[0m\n");
                        System.out.print("Give an amount to withdraw: ");
                        try {
                            double amount = sc.nextDouble();
                            sc.nextLine();
                            if (amount != 0) bank.withdraw(currentUser, amount);
                        } catch (BankException e) {
                            page.error(e.getMessage());
                        } catch (InputMismatchException e) {
                            page.invalidInput();
                            sc.nextLine();
                        }
                        System.out.printf("\nCurrent balance is: %s\n", money.format(accountCheck.balance(currentUser)));
                        UI.pause(sc);
                    }
                    case 6 -> {
                        page.showBalance(currentUser, accountCheck);
                        System.out.println("\033[1mEnter 0 to go back.\033[0m\n");
                        System.out.print("Give an amount to deposit: ");
                        try {
                            double amount = sc.nextDouble();
                            sc.nextLine();
                            if (amount != 0) bank.deposit(currentUser, amount);
                        } catch (BankException e) {
                            page.error(e.getMessage());
                        } catch (InputMismatchException e) {
                            page.invalidInput();
                            sc.nextLine();
                        }
                        System.out.printf("\nCurrent balance is: %s\n", money.format(accountCheck.balance(currentUser)));
                        UI.pause(sc);
                    }
                    case 7 -> {
                        System.out.printf("Current balance is: %s\n\n", money.format(accountCheck.balance(currentUser)));
                        System.out.println("\033[1mEnter \"back\" to go back.\033[0m");
                        while (true) {
                            System.out.print("Enter username of the recipient: ");
                            String recipient = sc.nextLine();
                            if (recipient.equals("back")) break;
                            try {
                                System.out.print("Enter amount to transfer: ");
                                double amount = sc.nextDouble();
                                sc.nextLine();
                                bank.transfer(currentUser, recipient, amount);
                                page.success("Transfer successful.");
                                break;
                            } catch (BankException e) {
                                page.error(e.getMessage());
                            } catch (InputMismatchException e) {
                                page.error("Numbers only.");
                                sc.nextLine();
                            }
                        }
                        System.out.printf("\nCurrent balance is: %s\n", money.format(accountCheck.balance(currentUser)));
                        UI.pause(sc);
                    }
                    case 8 -> {
                        List<Transaction> history = accountCheck.getUser(currentUser).history;
                        boolean back = false;
                        while (!back) {
                            UI.clearScreen();
                            page.historyMenu();
                            int hChoice = sc.nextInt();
                            sc.nextLine();
                            try {
                                switch (hChoice) {
                                    case 0 -> back = true;
                                    case 1 -> page.printHistory(TransactionAlgorithms.mergeSortByAmount(history));
                                    case 2 -> page.printHistory(TransactionAlgorithms.mergeSortByDate(history));
                                    case 3 -> {
                                        System.out.print("Amount to find: ");
                                        double amt = sc.nextDouble();
                                        sc.nextLine();
                                        List<Transaction> sorted = TransactionAlgorithms.mergeSortByAmount(history);
                                        page.printHistory(TransactionAlgorithms.binarySearchByAmount(sorted, amt));
                                    }
                                    case 4 -> {
                                        System.out.print("Type to find (DEPOSIT/WITHDRAW/TRANSFER_OUT/TRANSFER_IN/LOAN/REPAYMENT): ");
                                        String type = sc.nextLine();
                                        page.printHistory(TransactionAlgorithms.linearSearchByType(history, type));
                                    }
                                    default -> page.invalidInput();
                                }
                            } catch (InputMismatchException e) {
                                page.error("Numbers only.");
                                sc.nextLine();
                            }
                            if (!back) UI.pause(sc);
                        }
                    }
                    case 9 -> {
                        UI.clearScreen();
                        System.out.println("\n\n\n\033[32m\033[1mThank you for trusting us!\033[0m");
                        System.exit(0);
                    }
                    default -> {
                        page.invalidInput();
                        UI.pause(sc);
                    }
                }
            } catch (Exception e) {
                sc.nextLine();
                UI.pause(sc);
            }
        }
    }
}

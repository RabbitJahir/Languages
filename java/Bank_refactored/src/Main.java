import core.UsersStorage;
import gui.BankApp;
import tbi.TerminalApp;
import javafx.application.Application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------------------------");
        System.out.println("   Choose interface");
        System.out.println("-----------------------------");
        System.out.println("1. GUI (JavaFX)");
        System.out.println("2. Terminal");
        System.out.print("Enter your choice: ");

        int choice;
        try {
            choice = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            choice = 2; // default to terminal on bad input
        }

        if (choice == 1) {
            Application.launch(BankApp.class, args);
        } else {
            TerminalApp.run(sc, new UsersStorage());
        }
    }
}

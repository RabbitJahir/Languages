package ui;

import java.util.Scanner;

public class UI {
      // CLEAR SCREEN
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // PAUSE 
    public static void pause(Scanner sc) {
        System.out.println("\nPress Enter to continue...");
        sc.nextLine();
        // sc.nextLine();
        clearScreen();
    }
}

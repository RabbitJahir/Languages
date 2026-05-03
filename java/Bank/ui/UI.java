package ui;

import java.util.Scanner;

public class UI {
      // CLEAR SCREEN, clears the screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // PAUSE , need to enter something and then clearscreen
    public static void pause(Scanner sc) {
        System.out.println("\n\033[32m\033[1mPress Enter to continue...\033[0m");
        sc.nextLine();
        clearScreen();
    }
}

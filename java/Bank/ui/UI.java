package ui;

import java.util.Scanner;

public class UI {
      // CLEAR SCREEN, clears the screen

    public static void clearScreen() {
         try {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
        // \033 -> esc | \033[H -> moves cursor to top left | \033[2J -> clears the screen
            System.out.print("\033[H\033[2J");
        // flush stores the output that is to be shown and print them immediately
            System.out.flush();
        }
    } catch (Exception e) {
        System.out.println();
    }
    }

    // PAUSE , need to enter something and then clearscreen
    public static void pause(Scanner sc) {
        System.out.println("\n\033[32m\033[1mPress Enter to continue...\033[0m");
        sc.nextLine();
        clearScreen();
    }
}

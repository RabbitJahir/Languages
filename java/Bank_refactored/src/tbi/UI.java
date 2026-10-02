package tbi;

import java.util.Scanner;

public class UI {

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println();
        }
    }

    public static void pause(Scanner sc) {
        System.out.println("\n\033[32m\033[1mPress Enter to continue...\033[0m");
        sc.nextLine();
        clearScreen();
    }
}

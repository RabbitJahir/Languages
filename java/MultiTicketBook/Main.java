import java.util.Scanner;

import pages.HomePage;
import ui.UI;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        HomePage pages = new HomePage();
        
        UI.clearScreen();

        boolean loop_1 = true;        
        while(loop_1){
           
            pages.homePage();
            int pageSelect = sc.nextInt();
            sc.nextLine();

            switch(pageSelect){
                case 1 -> {
                    UI.clearScreen();
                    pages.moviePage(sc);
                    UI.pause(sc);
                }
                case 2 -> {
                    System.out.print("Soon...");
                    UI.pause(sc);
                }
                case 3 -> {
                    UI.clearScreen();
                    pages.airplanePage(sc);
                    UI.pause(sc);
                }
                case 4 -> {
                    UI.clearScreen();
                    pages.busPage(sc);

                    UI.pause(sc);
                }
                case 5 -> {
                    System.out.print("\nThank you for being with us.\n");   
                    UI.pause(sc);
                    loop_1 = false; 
                }
                default -> {
                    System.out.print("Choose between given numbers");
                    UI.pause(sc);
                    continue;
                }
            }
        }
        

        sc.close();
    }
}
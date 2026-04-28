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

            switch(pageSelect){
                case 1 -> {
                    System.out.print("1");
                    UI.pause(sc);
                }
                case 2 -> {
                    System.out.print("2");
                    UI.pause(sc);
                }
                case 3 -> {
                    System.out.print("3");
                    UI.pause(sc);
                }
                case 4 -> {
                    System.out.print("4");
                    UI.pause(sc);
                }
                case 5 -> {
                    System.out.print("Exiting");    
                    UI.pause(sc);
                    loop_1=false;
                }
                default -> {
                    System.out.print("default");
                }
            }
            UI.pause(sc);
        }


        UI.clearScreen();
        

        sc.close();
    }
}
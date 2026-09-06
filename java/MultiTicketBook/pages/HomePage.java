package pages;

import java.util.Scanner;
import java.util.Random;

public class HomePage {
    Random rand = new Random();

    public void homePage(){
        System.out.print("---------------------------------------------\n");
        System.out.print("   WELCOME TO ONLINE MULTI TICKET BOOKER\n");
        System.out.print("---------------------------------------------\n");
        System.out.print("1. Movie Tickets\n");
        System.out.print("\n2. Nationl Flights\n");
        System.out.print("\n3. International Flights\n");
        System.out.print("\n4. Bus Tickets\n");
        System.out.print("\n5. Exit\n\n");
        System.out.print("Option: ");
    }

    public void busPage(Scanner sc){
        System.out.print("---------------------------------------------\n");
        System.out.print("   WELCOME TO ONLINE BUS TICKET BOOKER\n");
        System.out.print("---------------------------------------------\n");
        System.out.print("\n1. Bus to America  - $ 100  \n");
        System.out.print("\n2. Bus to Japan    - $ 100  \n");
        System.out.print("\n3. Bus to Germany  - $ 100  \n");
        System.out.print("\n\nChoose a ticket number: ");

        int busTicket = sc.nextInt();
        sc.nextLine();
        System.out.println("\nTicket has been bought.");
        int ticketNumber = rand.nextInt(100) + 1;

        System.out.println("Your ticket number is: " + ticketNumber);
    }

    public void airplanePage(Scanner sc){
        System.out.print("---------------------------------------------\n");
        System.out.print("  WELCOME TO ONLINE AIRPLANE TICKET BOOKER\n");
        System.out.print("---------------------------------------------\n");
        System.out.print("\n1. Plane to America  - $ 100  \n");
        System.out.print("\n2. Plane to Japan    - $ 100  \n");
        System.out.print("\n3. Plane to Germany  - $ 100  \n");
        System.out.print("\n\nChoose a ticket number: ");

        int planeTicket = sc.nextInt();
        sc.nextLine();
        System.out.println("\nTicket has been bought.");
        int ticketNumber = rand.nextInt(100) + 1;

        System.out.println("Your ticket number is: " + ticketNumber); 
    }

    public void moviePage(Scanner sc){
        System.out.print("---------------------------------------------\n");
        System.out.print("  WELCOME TO MOVIE ONLINE TICKET BOOKER\n");
        System.out.print("---------------------------------------------\n");
        System.out.print("\n1. James Bond  - $ 100  \n");
        System.out.print("\n2. Rocky       - $ 100  \n");
        System.out.print("\n3. Legos       - $ 100  \n");
        System.out.print("\n\nChoose a ticket number: ");

        int movieTicket = sc.nextInt();
        sc.nextLine();
        System.out.println("\nTicket has been bought.");
        int ticketNumber = rand.nextInt(100) + 1;

        System.out.println("Your ticket number is: " + ticketNumber); 
    }
}

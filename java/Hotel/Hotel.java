import java.util.*;

public class Hotel {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Hotel");
        System.out.println("nijer aro line");

        ArrayList<Integer> available = availableRooms();


        System.out.println("\nChoose a room number: ");
        int roomChoose = input.nextInt();

        if (available.contains(roomChoose)) {

        System.out.println("Room " + roomChoose + " is available.");

        // second input step (for project style)
        System.out.println("\nSelect pricing type:");
        System.out.println("1. Standard (1–5)");
        System.out.println("2. Deluxe (6–15)");
        System.out.println("3. Premium (16–20)");

    int choice = input.nextInt();

    int price = 0;

    if (choice == 1) {
        price = 2000;
    } 
    else if (choice == 2) {
        price = 4000;
    } 
    else if (choice == 3) {
        price = 10000;
    } 
    else {
        System.out.println("Invalid choice!");
    }

    if (price != 0) {
        System.out.println("Price per night: " + price + " BDT");
        System.out.println("Booking confirmed for room " + roomChoose);
    }

} else {
    System.out.println("Sorry, room not available.");
}

        input.close();
    }

    public static ArrayList<Integer> availableRooms() {

        ArrayList<Integer> rooms = new ArrayList<>();
        ArrayList<Integer> booked = new ArrayList<>(Arrays.asList(1,6,7,12,13,17,18));

        for (int i = 1; i <= 20; i++) {
            rooms.add(i);
        }

        rooms.removeAll(booked);

        System.out.println("\nAvailable Rooms:");

        for (int room : rooms) {
            System.out.println(room);
        }

        // returns rooms, that is checked with available
        return rooms; 
    }
}
import java.util.Arrays;
import java.util.Scanner;

class wtf{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String currentUser = null;

        String users[] = {"rabbit", "kamrul", "mamu", "smile"};
        System.out.print("Enter UserName (Capitalization matters): ");
        String user = sc.nextLine();

        if (Arrays.asList(users).contains(user)) {
            currentUser = user;
    System.out.println("UserName: " + currentUser);
} else {
    System.out.println("User not found");
}


    sc.close();
    }
}
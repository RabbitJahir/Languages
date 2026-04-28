package pages;

public class Pages implements PageTypes {

    public void homePage() {
        System.out.println("-----------------------------");
        System.out.println("     WELCOME TO BANK");
        System.out.println("-----------------------------");
        System.out.println("1. Shared accounts");
        System.out.println("2. Personal accounts\n");
        System.out.print("Enter your account type: ");
    }
}   
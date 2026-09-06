import java.util.Scanner;
interface cashIn{
    void cashIn();
}

interface cashOut{
    void cashOut();
}


class Bkash implements cashIn, cashOut{
 
    @Override
    public void cashIn(){
        System.out.println("Cash in by bkash");
    }
    @Override
    public void cashOut(){
        System.out.println("Cash out by bkash");
    }
}

public class inter {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Boolean loop = true;

       Bkash cashApp = new Bkash(); 

        System.out.println("---------------------------\nWelcome to Cash App. Choose your number:\nChoose 1 for Customer 1324\nChoose 2 for Customer 5464" ); 
        int customer = sc.nextInt();

        switch(customer){
            case 1-> System.out.println("Welcome Customer 1");
            case 2-> System.out.println("Welcome Customer 2");
        }

        System.out.println("\nPress 1 For Cash in \nPress 2 For Cash out \nPress 3 for exit");
        int input = sc.nextInt();

        while(loop){
       switch(input){
        
        case 1-> cashApp.cashIn(); 
        case 2-> cashApp.cashOut(); 
        case 3-> loop =false;
        default-> System.out.println("Choose from the given numbers.");
       }
    }

        sc.close();
    }
}   

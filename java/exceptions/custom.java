import java.util.Scanner;
import java.util.InputMismatchException;

public class custom {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            double deposit = 0;

        try{
            System.out.println("Enter amount to deposit: ");
            deposit = sc.nextDouble();

            try {
                if(deposit < 0){
                    throw new letterInputs();
                } else if(deposit >1000){
                    throw new nonono();
                }
            } catch(letterInputs | nonono e) {
                return;
            }

            System.out.printf("Deposited %.2f", deposit);
        }catch(InputMismatchException e) {
            System.out.println("Error: Invalid input");
        }

      
        }
    }
}

class letterInputs extends Exception {
    public letterInputs() {
        System.out.println("Cannot enter negative");
    }
    
    public letterInputs(String message) {
        super(message);
    }

}

class nonono extends Exception{
    public nonono(){
        System.out.println("Cannot enter higher");
    }
    
    public nonono(String message) {
        super(message);
    }
}

import java.util.Scanner;

public class amount_for_credits{
    public static void main(String[] args){
     
        try (Scanner input = new Scanner(System.in)) {
            double per_credit = 3500, waiver, credit;
            System.out.println("Per credit = " + per_credit + " BDT\n");
            System.out.print("Enter your waiver in %: ");
            waiver = input.nextDouble() / 100;
            System.out.print("Enter your total credit: ");
            credit = input.nextDouble();
            double after_waiver = per_credit -(waiver * per_credit);
            System.out.println("\nAfter waiver, per credit is: " + after_waiver + " BDT");
            System.out.println("Total amount for " + credit + " is : " + (credit * after_waiver) + " BDT");
            System.out.println("");
            System.out.println("Extra 6000 per semester, bus fare, lab etc.\nTotal after adding extra :" + (credit *after_waiver + 6000));
        }     
    }
}
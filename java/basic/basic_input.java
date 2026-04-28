package basic;
import java.util.Scanner;

public class basic_input {
  public static void main(String[] args){

    Scanner input = new Scanner(System.in); 
    //Scanner is the class
    //input: a varibale for the class.
    //new: a keyword that makes memory for
    //Scanner(): constructor.
    //System.in: The work this class does. System.input, takes input.

    float num = input.nextFloat();
    input.nextLine(); //To consume \n
    String name = input.nextLine();

    System.out.println("when using a num : " + num + " before string : "+name+", better to use a scanner, because int and float tends to leak the \n after that lingers to the next String.");

    System.out.print(500/2+"\n");
    System.out.printf("%d\n", 50+60);

    input.close(); //!!!!!!!! MUST be CLOSED!!!!!!!!!!!!
  }
}

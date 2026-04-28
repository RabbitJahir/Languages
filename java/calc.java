import java.util.Scanner;

public class calc {
  public static void main(String[] args){
    
      try (Scanner input = new Scanner(System.in)) {
        
          System.out.print("Enter operators from here (/ , * , + , - ): ");
          String function = input.nextLine();
          
          System.out.println("Enter 2 numbers: ");
          Double num1 = input.nextDouble();
          Double num2 = input.nextDouble();
          
          switch(function){
              case "+" : System.out.println(num1+num2);
              case "-" : System.out.println(num1-num2);
              case "*" : System.out.println(num1*num2);
              case "/" :  if(num2==0)
                  System.out.println("Anything divide zero is infinity.");
              else
                  System.out.println(num1/num2);
          } }
  }
}

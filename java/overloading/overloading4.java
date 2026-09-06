package overloading;
import java.util.Scanner;

class calculator{ 
    float add(float a, float b){
    System.out.println("Adding two integers");
    return a+b;
  }
  float sub(float a, float b){
    System.out.println("Subtracting two integers");
    return a-b;
  }
  float mult(float a, float b){
    System.out.println("Multiplying two integers");
    return a*b;
  }
  float div(float a, float b){
    System.out.println("Dividing two integers");
    return a/b;
  }
}

public class overloading4 {
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    System.out.print("Enter 2 numbers :");
    float x = input.nextFloat();
    float y = input.nextFloat();

    calculator calc = new calculator();
    System.out.println("Results : " +calc.add(x,y));
    System.out.println("Results : " +calc.sub(x,y));
    System.out.println("Results : " +calc.mult(x,y));
    System.out.println("Results : " +calc.div(x,y));

    input.close();
  }
}


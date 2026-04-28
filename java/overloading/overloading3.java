package overloading;
//using the same class with different methods, having the compiler select the correct method based on the arguements passed
//arguements are the values that are passed, parameters are the variables that are defined, acts as placeholder

//method overloading
class Calculator{
  float add(int a, int b){
    System.out.println("Adding two integers");
    return a+b;
  }
  float sub(int a, int b){
    System.out.println("Subtracting two integers");
    return a-b;
  }
  float mult(int a, int b){
    System.out.println("Multiplying two integers");
    return a*b;
  }
  float div(int a, int b){
    System.out.println("Dividing two integers");
    return a/b;
  }
}

public class overloading3 {
  public static void main(String[] args){

    Calculator calc = new Calculator();
    System.out.println("Results : " +calc.add(5,10));
    System.out.println("Results : " +calc.sub(5,10));
    System.out.println("Results : " +calc.mult(5,10));
    System.out.println("Results : " +calc.div(5,10));
  }
}


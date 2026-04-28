import java.util.Scanner;

public class three {
  public static void main(String[] args){
    Scanner s= new Scanner(System.in);
    int a = s.nextInt();
    int b= s.nextInt();
    System.out.println("Before: a = " + a + " b = " + b);
    int z=a;
    a=b;
    b=z;
    System.out.println("After: a = " + a + " b = " + b);

    s.close();
  } 
}

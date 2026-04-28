import java.util.Scanner;
public class five {
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    int sum = 0;

    for(int i=1;i<=5;i++){
      int number = input.nextInt();
        sum+=number;
    }

    int avg = sum/5;

    System.out.println("The sum of 5 no is : " + sum);
    System.out.println("The average is : " + avg);

    input.close();
  }
  
}

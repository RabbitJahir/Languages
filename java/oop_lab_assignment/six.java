import java.util.Scanner;
public class six {
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    int n = input.nextInt();

    int j = 1;
    int sum = 0;

    for(int i=1;i<=n;i++){
     System.out.println(j);
     sum+=j;
     j+=2;
    }

    System.out.println("The Sum of odd Natural Number upto " + n + " is : " + sum);

    input.close();
  }
}

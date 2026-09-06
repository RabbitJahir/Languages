import java.util.Scanner;
public class seven {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    int size = input.nextInt();
    float[] array = new float[size];

    float num=0;

    for(int i=0; i<array.length; i++){
      array[i] = input.nextFloat();
      num+=array[i];
    }

    System.out.println("Sum of array is: "+num);
    input.close();
  }
}

package array;
import java.util.Scanner;
 
public class loop_array {
  
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
   
    System.out.print("Number of Students : ");
    int loop = input.nextInt();

    int id[] = new int[loop];
    String name[] = new String[loop];

    for(int i=0; i<loop; i++){
      System.out.println();
      System.out.print("Enter ID for index " + (i+1) + "   : " );
        id[i] = input.nextInt();
      input.nextLine();
      System.out.printf("Enter name for index %d : ", (i+1));
        name[i] = input.nextLine();
    }

    for(int i=0; i<loop; i++){
      System.out.println();
      System.out.println("ID of " + (i+1) + "   : " + id[i]);
      System.out.printf("Name of %d : %s\n",(i+1) ,name[i]);
      
    }

    input.close();
  }
}

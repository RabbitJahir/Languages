package Stack;
import java.util.Stack;
import java.util.Scanner;

public class StackExample {
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    Stack<Integer> student_ids = new Stack<>();
    Stack<String> student_names = new Stack<>();

    System.out.print("Number of Students : ");
    int n = input.nextInt();
    input.nextLine();

    for(int i = 0; i < n; i++){
      System.out.print("Students id : ");
      student_ids.push(input.nextInt());
      input.nextLine();
      System.out.print("Students name : ");
      student_names.push(input.nextLine());
    }

    for(int i=0; i<n; i++){
      System.out.printf("ID and Name : %d, %s\n", student_ids.get(i), student_names.get(i));
    }

    input.close();
  }
}
import java.util.Scanner;

class Student{

  String name;
  int rollNo;
  double marks;

  void display(){
    System.out.println(name);
    System.out.println(rollNo);
    System.out.println(marks);
  }
}


public class ten {
  public static void main(String[] args){

      Scanner input = new Scanner(System.in);
      Student student_one = new Student();

      System.out.print("Enter name: ");
      student_one.name = input.nextLine();
      System.out.print("Enter roll: ");
      student_one.rollNo = input.nextInt();
      System.out.print("Enter marks: ");
      student_one.marks = input.nextDouble();
      System.out.println("");

      student_one.display();

      input.close();
  }
}

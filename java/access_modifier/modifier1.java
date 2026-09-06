package access_modifier;
import java.util.Scanner;

class Student_details{
  String name;
  String mail;
  private int number; //privated, so cant show normally

  Student_details(String n, String m, int num){
    name =n;
    mail =m;
    number =num;
  }

   void showNumber(){
    System.out.println(number); //need to use method to show
  }
}

public class modifier1 {
  public static void main(String[] args){
    
    Scanner input = new Scanner(System.in);

    System.out.print("Enter your name: ");
      String name = input.nextLine();
    System.out.print("Enter your mail: ");
      String mail = input.nextLine();
    System.out.print("Enter your number: ");
      int number = input.nextInt();

    Student_details student1 = new Student_details(name, mail, number); //sending to class

    System.out.println(student1.name);
    System.out.println(student1.mail);

    System.out.print("\nOnly teachers are allowed to see student numbers. \nEnter 1 if you are a teacher, 0 if you are not: ");
    
    int teacher = input.nextInt();
    input.nextLine();

    switch (teacher){
      case 1: 
        System.out.print("Enter password: ");
        String password = input.nextLine();

          if(("helo").equals(password)) //String .equals input
            student1.showNumber(); //calls the method
          else 
            System.out.println("seriously?");
        break;

      case 0: 
        System.out.println("alright");
        break;
    
    default: // if any of the case does not match
      System.out.println("dumb much?");
      break;
    }


    input.close();
  }
}

package learning_constructor;

import java.util.Scanner;
import java.util.ArrayList;

class Volunteer{
  String name;
  int id;
  Volunteer(String name, int id){
    this.name=name;
    this.id = id;
  }
}
public class Voluntee{
  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter name and id with space in between: ");
    

    ArrayList<Volunteer> volunteers= new ArrayList<Volunteer>();

    String name = sc.next().toLowerCase();
    int id = sc.nextInt();

    volunteers.add(new Volunteer(name, id));

    for(Volunteer print: volunteers){
      System.out.printf("%s %d\n", print.name, print.id);
    }

    sc.close();
  }
}
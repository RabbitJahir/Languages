package learning_constructor;

import java.util.ArrayList;
class Teacher{
  String name;
  String subject;
  double salary;
  Teacher(String name, String subject, double salary){
    this.name = name;
    this.subject = subject;
    this.salary = salary;
  }
}

public class teacher {
  public static void main(String[] args){
  
    ArrayList<Teacher> teachers = new ArrayList<>();

    teachers.add(new Teacher("esty", "wad", 12000));
    teachers.add(new Teacher("esty", "wad", 12000));


    for(Teacher print: teachers){
      System.out.printf("%s %s %.0f\n", print.name, print.subject, print.salary);
    }
  }
}
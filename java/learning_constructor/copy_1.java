package learning_constructor;

class Student{
  String name;
  int id;

  Student(String n, int roll){
    name = n;
    id = roll;
  }

  Student(Student s1){
    name = s1.name;
    id = s1.id;
  }

  void display(){
    System.out.println(name);
    System.out.println(id);
  }
}

public class copy_1 {
  public static void main(String[] args){
    String name="rabbit";
    int id=1006;

    Student s1 = new Student(name, id);
    Student s2 = new Student(s1);

    s1.display();
    s2.display();
  } 
}

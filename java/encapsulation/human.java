package encapsulation;

class Human{
  int age;
  String name;
  
  Human(int a, String n){
    age = a;
    name = n;
  }
  Human(String n, int a){
    age = a;
    name =n;
  }
}

public class human {
  public static void main(String[] args){

    Human one = new Human(56, "hooter");
    Human two = new Human("rabbit", 69);

    System.out.println(one.name +" : " +one.age);
    System.out.println(two.name +" : " +two.age);

  }
}

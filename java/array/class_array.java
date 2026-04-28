package array;

class Section{
  String name;
  int marks;
}


public class class_array {
 public static void main(String array[]){

  Section a = new Section();

  a.name = "rabbit";
  a.marks = 12;

  Section b = new Section();

  b.name = "ahona";
  b.marks = 010;

  Section students[] = new Section[2];

  students[0]= a;
  students[1]= b;

  for(Section print: students){
    System.out.println(print.name + ": " + print.marks);
  }

 } 
}

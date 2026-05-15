import java.util.Scanner;
abstract class B{
  double cgpa;
  String name; 
  B(double j,String k){
    cgpa=j;
    name=k;
  }
  void bbbb(Double cgpa, String name){
  System.out.println("cgpa :" + cgpa);
  System.out.println("name:" + name);
  }
  void sum(int x,int y){
   int result = x+y;
   System.out.println("result = " + result);
  }
}

interface test{
   void study();
   void study2();
   void study3();
}

class myMain extends B implements test{
  myMain(double cgpa,String name){
    // super(cgpa, name);
    this.cgpa=cgpa;
  }
 
  public void study(){
    System.out.println("pormo nh");
  }
  public void study2(){
    System .out.println("lekha pora");

  }
  public void study3(){
    System.out.println("vlo lage nh");
  }
}
public class Main{
  public static void main(String[] args) {
    Scanner vvv=new Scanner(System.in);
    System.out.println("enter the cgpa");
    double cgpa=vvv.nextDouble();
    vvv.nextLine();
    System.out.println("enter the name");
    String name=vvv.nextLine();
    System.out.println("enter the first number");
    int a=vvv.nextInt();
    System.out.println("enter the second number");
    int c=vvv.nextInt();
    vvv.close();

    myMain S1=new myMain (cgpa,name);
    S1.bbbb(cgpa, name);
    S1.sum(a,c);
    S1.study();
    S1.study2();
    S1.study3();



  }
}
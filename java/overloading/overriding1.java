package overloading;

class A{

  public void display(){
    System.out.println("in A");
  }
}

class B{

  public void display(){
    System.out.println("in B");
  }
}

public class overriding1 {
  public static void main(String[] args){

    A obj = new A();
    obj.display();
  }
}

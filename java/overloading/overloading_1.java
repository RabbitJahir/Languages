package overloading;
//overloading is using one class to print different methods, through different arguements or parameters
//this is constructor overloading.
class Room {
  float length, breadth;

  Room(float x, float y){ 
    length = x;
    breadth = x;
    System.out.println(length*breadth);
  }

  Room(float x){
    length = breadth = x;
  }

  Room(float x, float y, float z){}

  float area(){
    return (length*breadth);
  }
}

public class overloading_1 {
  public static void main(String[] args){
    float length = 5, breadth = 7, height = 10;

    Room room1 = new Room(length, breadth); //using more than one constructor in same class
    Room room2 = new Room(length);
    Room room3 = new Room(length, breadth, height);

    System.out.println(room1);
    System.out.println(room2.area());
    System.out.println(room3.area());

  }
}

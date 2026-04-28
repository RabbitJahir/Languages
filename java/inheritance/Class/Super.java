package inheritance.Class;

class Ground{
  int number; String name;
  Ground(int number, String name){
    this.number = number;
    this.name = name;
  }
  void floor(){
        System.out.printf("Number = %d , Name = %s", number, name);
  }
}

class Floor extends Ground{
  Floor(int number, String name){
    super(number, name);
  }
}

public class Super {
  public static void main(String[] args){

    Floor f1Room1= new Floor(4,"na");
    Floor f1Room2= new Floor(4,"na");

    f1Room1.floor();
    f1Room2.floor();

  }
}

package inheritance.Class;

class House{
  final int h=10;
  int l, b;
  String roomName;
  House(int l, int b, String roomName){
    this.l = l;
    this.b = b;
    this.roomName = roomName;
  }
  int area(){
    return l*b*h;
  }
}

class guestRoom extends House{
  guestRoom(int l, int b, String gR){
    super(l,b,gR);
  }
  void print(){
    System.out.printf("Area = %d of %s", area(), roomName);
  }
}

class masterRoom extends House{
  masterRoom(int l, int b, String mR){
    super(l,b,mR);
  }
  void print(){
    System.out.printf("Area = %d of %s", area(), roomName);

  }
}

public class Build {
  public static void main(String[] args){
    guestRoom guestroom = new guestRoom(5,6,"guestRoom");
    guestroom.print();

    masterRoom masterroom = new masterRoom(5,6,"masterRoom");
    masterroom.print();
  }
}

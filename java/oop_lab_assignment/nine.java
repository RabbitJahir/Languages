class Box{
  double volume;

  Box(double length,double height, double width){
    volume = length*height* width;
  }

  void display(){
    System.out.println("Volume is : " + volume);
  }
}

public class nine {
  public static void main(String[] args){

    double length =6.5, height=6, width=8;
    Box volume = new Box(length, height, width);
    volume.display();
  }
} 

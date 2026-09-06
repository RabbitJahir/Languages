package inheritance.Class;

class square{
  int l,h;
  int vol(int l, int h){
    this.l = l;
    this.h = h;

    return l*h;
  }
}

class rect extends square{
  int l,h,b;

  int vol(int l, int b, int h){
    this.l = l;
    this.h = h;
    this.b = b;

    return l*b*h;
  }
}

public class jaha2 {
  public static void main(String[] args){
    rect volume = new rect();

    System.out.println("Vol of rect is = " + (volume.vol(5,6,2 )));
    System.out.println("Vol of rect is = " +(volume.vol(5,6)));

  }
}

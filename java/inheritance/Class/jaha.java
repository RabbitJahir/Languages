package inheritance.Class;

class A{
  int a, b, sumA;
  void calcA(int a, int b){
    sumA=a+b;
    System.out.println("sum =" +sumA);
  }
}

class B extends A{
  int c,d, sumB;
  //@Override
  void calcB(int c, int b){
  sumB =c+d;
    System.out.println("sum = "+sumB );
  }
}

class jaha{
  public static void main(String[] args){
    B wtf = new B();
    wtf.calcB(10,5);
    wtf.calcA(5,5);
  }
}
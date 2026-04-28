package inheritance.inherit_calc;

public class calc {
  public static void main(String[] args){

    Calc_sci obj = new Calc_sci();

    double add = obj.add(5,6);
    double sub = obj.sub(5,6);
    double multi = obj.multi(5,6);
    double div = obj.div(5,6);
    double power = obj.power(4, 2);


    System.out.println(sub + ", "+ add + "," + multi +", "+ div + ", " + power);
  }
}

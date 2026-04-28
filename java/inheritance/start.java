package inheritance;

class Calc1{
    int a , b, sum;
    void calcSum(int a, int b){
        sum = a+b;
        System.out.println(sum);
    }
}

class Calc2 extends Calc1{
    int a,b,minus;
    void calcMinus(int a, int b){
        minus = a-b;
        System.out.println(minus);
    }
}

class Calc3 extends Calc2{
    int a,b,multi;
    void calcMulti(int a, int b){
        multi = a*b;
        System.out.println(multi);
    }
}


public class start {
    public static void main(String[] args) {

        Calc3 calc = new Calc3();

        calc.calcSum(4,5);
        calc.calcMinus(4,5);
        calc.calcMulti(4,5);

    }
}

abstract class Employee{
    abstract void calculateSalary();
}

class FullTimeEmployee extends Employee{
    @Override
    public void calculateSalary(){
        System.out.println("full time");
    }
}

public class twoA {
    public static void main(String[] args){
        // cannot make an object of abstract class Employee, An abstract class is meant to be an incomplete blueprint. It can contain abstract methods—methods that have a declaration but no implementation. Java wouldn't know what code to execute because Employee doesn't provide an implementation.
        FullTimeEmployee calling = new FullTimeEmployee();

        calling.calculateSalary();
    }
}

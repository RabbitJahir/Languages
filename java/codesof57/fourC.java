class BankAccount {
    double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    protected void calculateInterest() {
        System.out.println("Calculating base interest");
    }
}

class SavingsAccount extends BankAccount {


    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    protected void calculateInterest() {
        System.out.println("Calculating savings account interest");
    }

    public void showInterest() {
        calculateInterest(); 
    }
}

public class fourC {
    public static void main(String[] args) {

        SavingsAccount mine = new SavingsAccount(-0);

        mine.showInterest();
    }
}
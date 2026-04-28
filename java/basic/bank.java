package basic;
import java.util.Scanner;
class bank{
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    
    double balance = 123.123, deposit, withdraw;
    String name = "Hello";
    int ID = 1235124;

    while(true){
    System.out.print("Welcome to Home's Bank.\nChoose a service:\n1)Account\n2)Deposit\n3)Withdraw\n4)Exit\n--> ");

    int user = input.nextInt();

    switch(user)
    {
      case 1: System.out.println("Name: " +name);
              System.out.println("Account_No: " + ID);
              System.out.println("Balance: "+balance);
              System.out.println();
              break;

      case 2: System.out.print("Enter amount to Deposit: ");
              deposit = input.nextDouble();
              System.out.println("New balance: "+ (deposit + balance) );
              break;

        
      case 3: System.out.print("Enter amount to withdraw: ");
              withdraw = input.nextDouble();
              if(withdraw>balance)
              {
                System.out.println("Cannot withdraw more than what you have.");
                System.out.println();
              }
              else
              {
                System.out.println("New balance: "+ (balance-withdraw) );
                System.out.println();
              }
                break;
              
            
            case 4: input.close();
            return;

          }
             
    }
        
      }
    }
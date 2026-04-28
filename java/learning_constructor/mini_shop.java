package learning_constructor;
import java.util.Scanner;

class Shop{
  
  public void Ram(int dollar){
    if(dollar == 150){
      System.out.println( "\n1 Ram 8Gb has been purchased for 150$.\nThank you!");
    }
    else if(dollar >150){
      System.out.println( "\n1 Ram 8GB has been purchased for 150$.\nThank you for tips!");
    }
    else{
      System.out.println( "\ncome on man... ram is getting expensive we know.");
    }
  }

   public void Ssd(int dollar){
    if(dollar == 100){
      System.out.println( "\n1 SSD 256GB has been purchased for 100$.\nThank you!");
    }
    else if(dollar >100){
      System.out.println( "\n1 Ram 8GB has been purchased for 100$.\nThank you for tips!");
    }
    else{
      System.out.println( "\nnope.");
    }
  }
  
    public void Carrot(int dollar){
    if(dollar == 1010){
      System.out.println("\n1 Carrot has been purchased for 1010$.\nThank you!");
    }
    else if(dollar >1010){
      System.out.println("\n1 Carrot has been purchased for 1010$.\nThank you for tips!");
    }
    else{
      System.out.println("\nyeah carrots are expensize");
    }

  }
   public void Banana(int dollar){
    if(dollar == 999){
      System.out.println( "\n1 Banana has been purchased for 999$.\nThank you!");
    }
    else if(dollar >999){
      System.out.println( "\n1 Banana has been purchased for 999$.\nThank you for tips!");
    }
    else{
      System.out.println( "\nnope.");
    }

  }
}

public class mini_shop{
  public static void main(String[] a){

    Scanner items = new Scanner(System.in);

    System.out.print("\nWelcome to Rabbits Mall!\n\nType: \n1 for electronic.\n2 for foods.\nChoose: ");
    int choose = items.nextInt();

    Shop electronics = new Shop();
    Shop foods = new Shop();

    switch(choose){
      
      case 1:
        System.out.print("\n\nElectronics\n\nType:\n-> 1 for Ram 8GB: $150\n-> 2 for SSD 256GB: $100\nChoose: ");
        int electronic = items.nextInt();
          if(electronic == 1){
            System.out.print("Please give the shown amount of dollar: ");
            int dollars = items.nextInt();
            electronics.Ram(dollars);
          }
          else if(electronic == 2){
            System.out.print("Please give the shown amount of dollar: ");
            int dollars = items.nextInt();
            electronics.Ssd(dollars);
          }
          else{
        System.out.println("idiot");
          }
          break;
      case 2:
        System.out.print("\n\nFoods\n\nType:\n-> 1 for Carrot: $1010\n-> 2 for Banana: $999\nChoose: ");
        int food = items.nextInt();
        if(food == 1){
            System.out.print("Please give the shown amount of dollar: ");
            int dollars = items.nextInt();
            foods.Carrot(dollars);
          }
          else if(food == 2){
            System.out.print("Please give the shown amount of dollar: ");
            int dollars = items.nextInt();
            foods.Banana(dollars);
          }
          else{
        System.out.println("idiot");
          }
          break;
      default:
        System.out.println("idiot");
        break;
    }
   

    items.close();
  }
}
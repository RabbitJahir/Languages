package array;
import java.util.Scanner;

class Ram{
  String item;
  double price;
  int inv;
}

class Ssd{
  String item;
  double price;
  double size;
  int inv;
}

public class array_shop {
  public static void main(String wtf[]){
    Scanner scan = new Scanner(System.in);

      //SSD-------------------------------------------------------------
    Ssd one = new Ssd();
    one.item = "128 GB";
    one.price = 29.99;
    one.size = 2.5;
    one.inv = 12;

    Ssd one_noinch = new Ssd();
    one_noinch.item = "128 GB";
    one_noinch.price = 29.99;
    one_noinch.inv = 12;

    Ssd two = new Ssd();
    two.item = "256 GB";
    two.price = 29.99;
    two.size = 2.5;
    two.inv = 12;
   
    Ssd ssd_buy[] = new Ssd[3];
    ssd_buy[0] = one;
    ssd_buy[1] = one_noinch;
    ssd_buy[2] = two;


      //RAM---------------------------------------------------------------
    Ram eight = new Ram();
    eight.item = "8 GB";
    eight.price = 199.99;
    eight.inv = 4;

    Ram ram_buy[] = new Ram[1];
    ram_buy[0]= eight;

    //////////////////////////////////////////////////////////////////////////////
  
    System.out.printf("\n\nWelcome to Electronics Mall\n");

    System.out.printf("Choose: \n1 for ram\n2 for ssd\n");
    int product = scan.nextInt();

    switch(product){
      case 1: for(Ram print: ram_buy){
      System.out.printf("\n%s : $ %.2f : %d", print.item, print.price, print.inv);
    }
      break;
      case 2:
    for(Ssd print: ssd_buy){
      System.out.printf("\n%s : $ %.2f : %.1f inch : %d", print.item, print.price, print.size, print.inv);
    }
       break;
  }
    scan.close();
  }
}

package overloading;

class Cars{
  String brand, model, type;

  Cars(String b, String m, String t){
    brand = b;
    model = m;
    type = t;
    
    //Toyota
    if(brand.equals("Toyota") || model.equals("Corolla") || type.equals("Sedan") || type.equals("Saloon") ){
      System.out.println("");
      System.out.println("Manufacturer : Toyota \nModel : Corolla \nType : Sedan \nEngine : I4,1.5L ");
    }
    if(brand.equals("Toyota") || model.equals("RAV4") ||type.equals("SUV") || type.equals("Saloon")  ){
      System.out.println("");
      System.out.println("Manufacturer : Toyota \nModel : RAV4 \nType : SUV \nEngine : V8, large ");
    }
    if(brand.equals("Toyota") || model.equals("Corolla") ||type.equals("Hatchback") || type.equals("Saloon")  ){
      System.out.println("");
      System.out.println("Manufacturer : Toyota \nModel : Corolla \nType : Hatchback \nEngine: I4, 2L ");
    }
    //Honda
    if(brand.equals("Honda") || model.equals("Civic") ||type.equals("Sedan") || type.equals("Saloon")  ){
      System.out.println("");
      System.out.println("Manufacturer : Honda \nModel : Civic \nType : Sedan, compact \nEngine: I4 ");
    }
    if(brand.equals("Honda") || model.equals("Accord") ||type.equals("Sedan") || type.equals("Saloon")  ){
      System.out.println("");
      System.out.println("Manufacturer : Honda \nModel : Civic \nType : Sedan, mid-size \nEngine: I4, V6 ");
    }



  }
}
public class overloading2 {
  public static void main(String[] args){

    Cars car1 = new Cars("Honda", "", "Sedan");

  }
}

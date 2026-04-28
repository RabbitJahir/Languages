package overloading;

class Animal{
    String AnimalType;
    Animal(String AnimalType){
        this.AnimalType = AnimalType;
    }

    void display(){
        System.out.println("Animal Type: " + AnimalType);
    }
}
class Bird extends Animal{
    String BirdName;
    Bird(String BirdName, String AnimalType){
        super (AnimalType);
        this.BirdName = BirdName;
    }

    void display(){
        super.display();
        System.out.println("Bird Name: " + BirdName);
    }
}

class Mammal extends Animal{
    String MammalName;
    Mammal(String AnimalType, String MammalName){
        super(AnimalType);
        this.MammalName = MammalName;
    }
    void display(){
        super.display();
        System.out.println("Mammal Name: " + MammalName);
    }
}


public class over{
    public static void main(String[] args){

        Bird birdnames = new Bird("Doyel", "Bird");
        Mammal fox = new Mammal("Mammal", "fox");
        birdnames.display();
        fox.display();

        
    }
}

package inheritance;

class Animal{
    String animalName;

    Animal(String animalName){
        this.animalName = animalName;
    }
    void animalName(){
        System.out.println(animalName); 
    }
}

class Bird extends Animal{
    String birdName;

    Bird(String animalName, String birdName){
        super(animalName);
        this.birdName = birdName;
    }
    void animalName(){
        super.animalName();
        System.out.println(birdName); 
    }
}

public class start1{
    public static void main(String[] args){
        Bird bird1 = new Bird("Bird", "Eagle");

        bird1.animalName();
    }
}
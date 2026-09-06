interface Eat {
    void eat();
}

interface Sleep {
    void sleep();
}

interface Play {
    void play();
}

abstract class Animal implements Eat, Sleep, Play {

    String name;

    Animal(String name) {
        this.name = name;
    }

    void showName() {
        System.out.println("Animal: " + name);
    }
}

class Dog extends Animal {

    Dog(String name) {
        super(name);
    }
    
    @Override
    public void eat() {
        System.out.println(name + " is eating");
    }

    @Override
    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    @Override
    public void play() {
        System.out.println(name + " is playing");
    }
}

class Parrot extends Animal {

    Parrot(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating");
    }

    @Override
    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    @Override
    public void play() {
        System.out.println(name + " is playing");
    }
}

public class advanced1 {

    public static void main(String[] args) {

        Dog dog = new Dog("Dog name: Holio");
        Parrot parrot = new Parrot("Parrot name: Diver");

        dog.showName();
        dog.eat();
        dog.sleep();
        dog.play();

        System.out.println();

        parrot.showName();
        parrot.eat();
        parrot.sleep();
        parrot.play();
    }
}
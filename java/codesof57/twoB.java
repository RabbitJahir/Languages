class Vehicle {
    String manufacturer;
    int year;

    Vehicle(String manufacturer, int year) {
        this.manufacturer = manufacturer;
        this.year = year;
    }

    void startEngine() {
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Year: " + year);
    }
}

class Car extends Vehicle {
    String model;
    int numDoors;

    Car(String manufacturer, int year, String model, int numDoors) {
        super(manufacturer, year);
        this.model = model;
        this.numDoors = numDoors;
    }

    void drive() {
        System.out.println("Model: " + model);
        System.out.println("Doors: " + numDoors);
    }
}

class ElectricCar extends Car {
    int batteryCapacity;

    ElectricCar(String manufacturer, int year, String model, int numDoors, int batteryCapacity) {
        super(manufacturer, year, model, numDoors);
        this.batteryCapacity = batteryCapacity;
    }

    void charge() {
        System.out.println("Battery Capacity: " + batteryCapacity);
    }
}

public class twoB {
    public static void main(String[] args) {

        ElectricCar car1 = new ElectricCar("Tesla",2025,"Model 3",4,75);

        car1.startEngine();
        car1.drive();
        car1.charge();
    }
}
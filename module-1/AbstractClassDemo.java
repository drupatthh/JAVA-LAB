abstract class Vehicle {
    abstract void start();

    void display() {
        System.out.println("This is a vehicle");
    }
}

class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car starts with a key");
    }
}

class Bike extends Vehicle {
    @Override
    void start() {
        System.out.println("Bike starts with a button");
    }
}

public class AbstractClassDemo {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.display();
        car.start();

        Vehicle bike = new Bike();
        bike.display();
        bike.start();
    }
}

package eu.deic.oop;

// Interface
interface Animal {
    void makeSound();

    double maxSpeed();
}

// Base class
class Feline implements Animal {
    private float weight;

    public Feline() {
        this.weight = 0.0f;
    }

    public Feline(float weight) {
        this.weight = weight;
    }

    @Override
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }

    @Override
    public double maxSpeed() {
        System.out.println("Animal has max speed");
        return 0.0;
    }

    public void display() {
        System.out.println("Feline::display() " + this + ", weight = " + this.weight);
    }
}

// Derived class 1
class Cat extends Feline {
    private double speed;

    public Cat() {
        super(0.0f);
        this.speed = 0;
    }

    public Cat(float weight, double speed) {
        super(0.0f);
        this.speed = speed;
    }

    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }

    @Override
    public double maxSpeed() {
        System.out.println("Cat has max speed 50km/h");
        return 50.0;
    }

    @Override
    public void display() {
        System.out.println("Cat::display() " + this);
    }
}

// Derived class 2
class Tiger extends Feline {
    private double speed;
    private String color;

    public Tiger(float weight, double speed, String color) {
        super(weight);
        this.speed = speed;
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println("Tiger roars");
    }

    @Override
    public double maxSpeed() {
        System.out.println("Tiger has max speed 65km/h");
        return 65.0;
    }

    @Override
    public void display() {
        System.out.println("Tiger::display() " + this);
    }
}

public class ProgMainPoly {
    public static void main(String[] args) {
        // Using "pure" polymorphism/runtime polymorphism
        Animal cat = new Cat(3, 50);
        Animal tiger = new Tiger(500, 63, "white");

        cat.makeSound(); // Output: Cat meows
        tiger.makeSound(); // Output: Tiger roars

        // class cast exception:
        Animal a0;
        a0 = tiger; // Tiger -> Animal - up-cast (implicit)
        // 270 lines of code
        try {
            cat = (Cat) a0; // Animal -> Cat - down-cast (explicit)
        } catch (ClassCastException cce) {
            System.out.println("Error: " + cce);
        }
    }
}

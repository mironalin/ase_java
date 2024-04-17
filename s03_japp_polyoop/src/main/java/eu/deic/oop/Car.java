package eu.deic.oop;

public class Car extends Vehicle implements Cloneable, AutoCloseable {
    private static int noCars;
    private int doorsNo;

    public Car(float weight, int doorsNo) {
        super(weight);
        this.doorsNo = doorsNo;
        Car.noCars++;
    }

    public Object clone() throws CloneNotSupportedException {
        Car r = (Car) super.clone();
        r.setWeight(this.getWeight());
        r.doorsNo = this.doorsNo;
        Car.noCars++;
        return r;
    }

    @Override
    public void close() throws Exception {
        Car.noCars--;
    }

    public static int getNoCars() {
        return Car.noCars;
    }

    public void display() {
        System.out.println("Car obj @ " + this + ", with weight: " + this.getWeight() + ", doorsNo = " + this.doorsNo);
    }

}

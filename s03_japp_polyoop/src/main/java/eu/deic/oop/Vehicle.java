package eu.deic.oop;

public class Vehicle implements IMovement, Cloneable {
    private float weight;

    public Vehicle() {
        // super();
        // this.weight = 0.0f;
    }

    public Vehicle(float weight) {
        this.weight = weight;
    }

    @Override
    public void startEngine() {
        System.out.println("Vehicle::startEngine()");
    }

    @Override
    public void stopEngine() {
        System.out.println("Vehicle::stopEngine()");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Vehicle r = null;
        r = (Vehicle) super.clone();
        r.weight = this.weight;
        return r;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return this.weight;
    }

    public void display() {
        System.out.println("Vehicle obj @ " + this + ", with weight: " + this.weight);
    }

}

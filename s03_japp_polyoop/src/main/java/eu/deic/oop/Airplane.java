package eu.deic.oop;

public class Airplane extends Vehicle {
    private float capacityOfTransport;
    private int enginesNo;

    public Airplane(float weight, float capacityOfTransport, int enginesNo) {
        super(weight);
        this.capacityOfTransport = capacityOfTransport;
        this.enginesNo = enginesNo;
    }

    public float getCapacityOfTransport() {
        return capacityOfTransport;
    }

    public void setCapacityOfTransport(float capacityOfTransport) {
        this.capacityOfTransport = capacityOfTransport;
    }

    public int getEnginesNo() {
        return enginesNo;
    }

    public void setEnginesNo(int enginesNo) {
        this.enginesNo = enginesNo;
    }

    @Override
    public void display() {
        System.out.println("Airplane obj @ " + this + ", with weight: " + this.getWeight() + ", capacityOfTransport = "
                + this.capacityOfTransport
                + ", enginesNo = " + this.enginesNo);
    }

}

package eu.deic.oop;

public class ProgMain {
    public static void main(String[] args) {
        Vehicle v = null;
        Car objc = new Car(2300, 5);
        Airplane obja = new Airplane(12000, 14, 2);

        v = objc;
        v.display();
        v = obja;
        v.display();

        System.out.println();

        Vehicle v0 = null;
        v0 = objc;
        try {
            obja = (Airplane) v0;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        // Car objCar = null;
        // try {
        // objCar = new Car(2500, 5);
        try (Car objCar = new Car(2500, 5);) {
            objCar.display();
            System.out.printf("# of Car objs = %d", Car.getNoCars());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        // objCar = null;
        // System.gc();
        System.out.printf("\n# of Car objs = %d\n", Car.getNoCars());

    }
}

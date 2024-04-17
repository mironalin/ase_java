package eu.deic.oop;

public class ProgMainIoOop {
    public static void main(String[] args) {
        int[] units = { 40, 50, 100 };
        double[] prices = new double[] { 12.99, 9.55, 16.89 };
        String[] descs = new String[] { "Pen", "Mug", "T-Shirt" };

        Invoice invoiceObj1 = new Invoice(units, prices, descs);

        invoiceObj1.saveInvoiceToFile("invoice2.txt");

        System.out.println("totalInFile = " + invoiceObj1.readInvoiceFromFile("invoice2.txt"));
    }
}
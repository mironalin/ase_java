package eu.deic.oop;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Invoice {
    private int[] units;
    private double[] prices;
    private String[] descs;

    public Invoice(int[] units, double[] prices, String[] descs) {
        this.units = units;
        this.prices = prices;
        this.descs = descs;
    }

    public int[] getUnits() {
        return this.units;
    }

    public void setUnits(int[] units) {
        this.units = units;
    }

    public double[] getPrices() {
        return this.prices;
    }

    public void setPrices(double[] prices) {
        this.prices = prices;
    }

    public String[] getDescs() {
        return this.descs;
    }

    public void setDescs(String[] descs) {
        this.descs = descs;
    }

    public void saveInvoiceToFile(String pathToInvoice) {
        DataOutputStream out = null;

        try {
            FileOutputStream fos = new FileOutputStream(pathToInvoice);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            out = new DataOutputStream(bos);

            for (int i = 0; i < units.length; i++) {
                out.writeInt(units[i]);
                out.writeDouble(prices[i]);
                out.writeUTF(descs[i]);
            }

            out.close();
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }

    }

    public double readInvoiceFromFile(String pathToInvoice) {
        DataInputStream in = null;
        double total = 0.0;
        try {
            in = new DataInputStream(new BufferedInputStream(new FileInputStream(pathToInvoice)));

            int unit = 0;
            double price = 0.0;
            String desc = null;
            try {
                while (true) {
                    unit = in.readInt();
                    price = in.readDouble();
                    desc = in.readUTF();

                    total += unit * price;
                    System.out.printf("\nRead record: %s, unit = %d, price = %f", desc, unit, price);
                }
            } catch (Exception eofe) {
                System.out.println("\nInvoice total = " + total);
                in.close();
            }
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
        return total;
    }
}

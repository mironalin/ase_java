package eu.deic.oop;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ProgMainIo {
    public static void main(String[] args) {
        int[] units = { 40, 50, 100 };
        double[] prices = new double[] { 12.99, 9.55, 16.89 };
        String[] descs = new String[] { "Pen", "Mug", "T-Shirt" };

        DataOutputStream out = null;
        DataInputStream in = null;

        try {
            FileOutputStream fos = new FileOutputStream("./invoice1.txt");
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

        try {
            in = new DataInputStream(new BufferedInputStream(new FileInputStream("./invoice1.txt")));

            int unit = 0;
            double price = 0.0;
            String desc = null;
            double total = 0.0;

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
    }
}

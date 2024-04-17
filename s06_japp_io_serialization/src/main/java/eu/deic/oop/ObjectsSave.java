package eu.deic.oop;

import java.net.URL;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class ObjectsSave {
    public static void main(String[] args) {
        try {
            System.out.println("Saving objects <=> Serialization");

            FileOutputStream fos = new FileOutputStream("objects4.txt");
            ObjectOutputStream out = new ObjectOutputStream(fos);

            URL op1 = new URL("http://www.ism.ase.ro");
            URL op2 = op1;
            URL op3 = op1;

            ObjectsGraph og = new ObjectsGraph(op1, op2);
            out.writeObject(og);
            out.writeObject(op3);

            out.flush();

            System.out.println("og = " + og);
            System.out.println("op3 = " + op3);

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

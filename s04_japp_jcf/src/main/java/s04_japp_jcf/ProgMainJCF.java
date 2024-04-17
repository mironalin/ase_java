package s04_japp_jcf;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class Patient implements Cloneable {
    private int id; // not ssn or CNP
    private String name;

    public Patient(int idRegistrationFromHospital, String name) {
        this.id = idRegistrationFromHospital;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Patient c = (Patient) super.clone();
        c.id = this.id;
        c.name = this.name;
        return c;
    }

    public void print() {
        System.out.printf("Patient id: %d | Has name: %s | Patient obj = %s\n", this.id, this.name, this);
    }
}

public class ProgMainJCF {
    public static void main(String[] args) {
        // Patient patient = new Patient(12, "Jake");
        // patient.print();

        List<Patient> patientList = new ArrayList<>();
        for (var i = 0; i < 100_000; i++) {
            // Patient itemInList = new Patient(101 + i, "Patient " + i);
            patientList.add(new Patient(101 + i, "Patient " + i));
        }

        long start = 0, stop = 0;

        System.out.println("\nStd normal iteration: ");
        start = System.currentTimeMillis();
        for (int i = 0; i < patientList.size(); i++) {
            if (i == 0) {
                patientList.get(i).print();
            }
        }
        stop = System.currentTimeMillis();
        System.out.println("1. speed = " + (stop - start));

        System.out.println("\nFor-each iteration: ");
        start = System.currentTimeMillis();
        int i = 0;
        for (Patient patient : patientList) {
            if (i == 0) {
                patient.print();
            }
            i++;
        }
        stop = System.currentTimeMillis();
        System.out.println("2. speed = " + (stop - start));

        System.out.println("\nIteration with iterator object: ");
        start = System.currentTimeMillis();
        i = 0;
        for (Iterator<Patient> iterator = patientList.iterator(); iterator.hasNext();) {
            var person = iterator.next();
            if (i == 0) {
                person.print();
            }
            i++;
        }
        stop = System.currentTimeMillis();
        System.out.println("3. speed = " + (stop - start));

    }
}
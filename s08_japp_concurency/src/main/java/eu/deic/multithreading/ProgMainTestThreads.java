package eu.deic.multithreading;

class HelloThread extends Thread {
    public HelloThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Thread = " + name);
    }
}

class HelloRunnable extends Object implements Runnable {
    private String name;

    public HelloRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        String nameT = Thread.currentThread().getName();
        System.out.println("Runnable  = " + this.name + ", Thread = " + nameT);
    }
}

public class ProgMainTestThreads {

    public static void main(String[] args) {
        HelloThread t1 = new HelloThread("NameT01");
        t1.start();

        HelloRunnable r2 = new HelloRunnable("NameR02");

        Thread t2 = new Thread(r2);
        t2.start();

        Runnable rTask3 = () -> {
            String nameT = Thread.currentThread().getName();
            System.out.println("Runnable - Thread = " + nameT);
        };

        Thread t3 = new Thread(rTask3);
        t3.start();
        System.out.println("main method - aka Main thread finished!!!");
    }
}
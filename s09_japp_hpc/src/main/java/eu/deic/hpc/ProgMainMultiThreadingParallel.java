package eu.deic.hpc;

class RArray implements Runnable {

    private int[] a1;
    private int[] a2;
    private int[] aOut;
    private int startIndex;
    private int stopIndex;

    public RArray(int[] array1, int[] array2, int[] arrayResult, int startIndex, int stopindex) {
        this.a1 = array1;
        this.a2 = array2;
        this.aOut = arrayResult;
        this.startIndex = startIndex;
        this.stopIndex = stopindex;
    }

    @Override
    public void run() {
        for (var i = this.startIndex; i < stopIndex; i++) {
            this.aOut[i] = a1[i] + a2[i];
        }
    }

}

public class ProgMainMultiThreadingParallel {

    public static void main(String[] args) {
        int NTH = 4;
        int size = 40_000_000;

        int[] v1 = new int[size];
        int[] v2 = new int[size];

        for (var i = 0; i < size; i++) {
            v1[i] = i + 1;
            v2[i] = size - i;
        }

        int[] v3 = new int[size];

        int startIdx = 0;
        int stopIdx = 0;

        long startT = 0;
        long stopT = 0;

        // ! 1. sequential addition of 2 arrays
        startT = System.currentTimeMillis();
        for (var i = 0; i < size; i++) {
            v3[i] = v1[i] + v2[i];
        }
        stopT = System.currentTimeMillis();

        System.out.println(
                "1. sequential ms = " + (stopT - startT) + ", v3[0] = " + v3[0] + ", v3[size - 1] = " + v3[size - 1]);

        // ! 2. Multi-Threading std.
        startT = System.currentTimeMillis();
        RArray[] rA = new RArray[NTH];
        Thread[] tA = new Thread[NTH];

        for (var it = 0; it < NTH; it++) {
            startIdx = it * (v1.length / NTH);
            stopIdx = (it + 1) * (v1.length / NTH) - 1;
            rA[it] = new RArray(v1, v2, v3, startIdx, stopIdx);
            tA[it] = new Thread(rA[it]);
        }

        for (var it = 0; it < NTH; it++) {
            tA[it].start();
        }

        for (var it = 0; it < NTH; it++) {
            try {
                tA[it].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stopT = System.currentTimeMillis();
        System.out.println(
                "2. Multithreading ms = " + (stopT - startT) + ", v3[0] = " + v3[0] + ", v3[size - 1] = "
                        + v3[size - 1]);

    }
}

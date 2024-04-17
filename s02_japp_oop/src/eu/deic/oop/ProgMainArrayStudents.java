package eu.deic.oop;

public class ProgMainArrayStudents {

    public static void main(String[] args) {
        int[][] sMarks = new int[][] {
                    {9, 10, 3},
                    {5, 5, 6}
        };

        float[] sAvg = new float[sMarks.length];

        int i = 0;
        while (i < sMarks.length) {
            int j = 0;
            sAvg[i] = 0.0f;
            while (j < sMarks[i].length) {
                sAvg[i] += sMarks[i][j];
                j++;
            } // end of internal while
            sAvg[i] /= sMarks[i].length;
            i++;
        } // end of external while

        int k = 0;
        while (k < sAvg.length) {
            System.out.printf("\nsAvg[%d] = %f", k, sAvg[k]);
            k++;
        } // average print

//        for (int i = 0; i < sMarks.length; i++) {
//            sAvg[i] = 0.0f;
//            for (int j = 0; j < sMarks[i].length; j++) {
//                sAvg[i] += sMarks[i][j];
//            } // end of internal loop
//            sAvg[i] /= sMarks[i].length;
//        } // end of external for loop
//
//        for (int k = 0; k < sMarks.length; k++) {
//            System.out.println("sAvg[" + k + "] = " + sAvg[k]);
//        } // average print

    } // end of the main method
}  // end of the class

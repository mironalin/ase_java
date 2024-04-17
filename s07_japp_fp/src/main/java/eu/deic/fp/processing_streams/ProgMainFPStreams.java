package eu.deic.fp.processing_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgMainFPStreams {
    public static void main(String[] args) {
        List<String> sList = Arrays.asList("abc", "de", "", "fgh", "", "jklmn", "", "");

        System.out.println();

        long startTime = 0L, stopTime = 0L;
        startTime = System.nanoTime();
        long c0 = 0;
        for (var s : sList) {
            if (s.isEmpty()) {
                c0++;
            }
        }
        stopTime = System.nanoTime();

        System.out.println("c0 = " + c0 + ", nano seconds = " + (stopTime - startTime));

        // streams
        startTime = System.nanoTime();
        long c1 = sList.stream().filter(s -> s.isEmpty()).count();
        stopTime = System.nanoTime();

        System.out.println("c1 = " + c1 + ", nano seconds = " + (stopTime - startTime));
        System.out.println();

        List<String> places = new ArrayList<>();
        places.add("Romania - Bucharest");
        places.add("France - Paris");
        places.add("France - Nisa");
        places.add("UK - London");
        places.add("Italy - Rome");

        places.stream()
                .filter(place -> place.startsWith("France"))
                .map(place -> place.toUpperCase())
                .sorted()
                .forEach(place -> System.out.println(place));
    }
}
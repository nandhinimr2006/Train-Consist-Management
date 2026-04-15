package org.example;

import java.util.*;

public class TrainConsistManagement {

    // UC13 - Loop-based filtering
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();

        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }

        return result;
    }

    // UC13 - Stream-based filtering
    public static List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .toList();
    }

    // UC13 - Measure loop execution time
    public static long measureLoopTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterUsingLoop(bogies);
        long end = System.nanoTime();

        return end - start;
    }

    // UC13 - Measure stream execution time
    public static long measureStreamTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterUsingStream(bogies);
        long end = System.nanoTime();

        return end - start;
    }

    // Demo main method
    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie("Sleeper", i + 50));
        }

        long loopTime = measureLoopTime(bogies);
        long streamTime = measureStreamTime(bogies);

        System.out.println("Loop Time: " + loopTime + " ns");
        System.out.println("Stream Time: " + streamTime + " ns");
    }
}
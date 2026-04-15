package org.example;

import java.util.*;

public class TrainConsistManagement {

    // UC13 - Loop-based filtering
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();

        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {   // ✔ correct usage
                result.add(b);
            }
        }

        return result;
    }

    // UC13 - Stream-based filtering
    public static List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)   // ✔ correct usage
                .toList();
    }

    // UC13 - Measure loop time
    public static long measureLoopTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterUsingLoop(bogies);
        long end = System.nanoTime();
        return end - start;
    }

    // UC13 - Measure stream time
    public static long measureStreamTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterUsingStream(bogies);
        long end = System.nanoTime();
        return end - start;
    }

    // Optional main method (for demo)
    public static void main(String[] args) throws InvalidCapacityException {

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC", 50));
        bogies.add(new Bogie("Chair", 80));

        System.out.println("Loop Result:");
        System.out.println(filterUsingLoop(bogies));

        System.out.println("Stream Result:");
        System.out.println(filterUsingStream(bogies));

        System.out.println("Loop Time: " + measureLoopTime(bogies));
        System.out.println("Stream Time: " + measureStreamTime(bogies));
    }
}
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TrainConsistManagementTest {

    // UC13 - Loop test
    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 70),
                new Bogie("AC", 50),
                new Bogie("Chair", 80)
        );

        List<Bogie> result = TrainConsistManagement.filterUsingLoop(bogies);

        assertEquals(2, result.size());
    }

    // UC13 - Stream test
    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 70),
                new Bogie("AC", 50),
                new Bogie("Chair", 80)
        );

        List<Bogie> result = TrainConsistManagement.filterUsingStream(bogies);

        assertEquals(2, result.size());
    }

    // Compare results
    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 70),
                new Bogie("AC", 50),
                new Bogie("Chair", 80)
        );

        List<Bogie> loopResult = TrainConsistManagement.filterUsingLoop(bogies);
        List<Bogie> streamResult = TrainConsistManagement.filterUsingStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    // Time check
    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 70),
                new Bogie("AC", 50),
                new Bogie("Chair", 80)
        );

        long loopTime = TrainConsistManagement.measureLoopTime(bogies);
        long streamTime = TrainConsistManagement.measureStreamTime(bogies);

        assertTrue(loopTime > 0);
        assertTrue(streamTime > 0);
    }

    // Large dataset test
    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie("Sleeper", i + 50));
        }

        List<Bogie> result = TrainConsistManagement.filterUsingStream(bogies);

        assertTrue(result.size() > 0);
    }
}
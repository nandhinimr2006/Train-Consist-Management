package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TrainConsistManagementTest {

    // UC13
    @Test
    void testLoopFilteringLogic() throws InvalidCapacityException {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 70),
                new Bogie("AC", 50),
                new Bogie("Chair", 80)
        );

        assertEquals(2, TrainConsistManagement.filterUsingLoop(bogies).size());
    }

    @Test
    void testStreamFilteringLogic() throws InvalidCapacityException {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 70),
                new Bogie("AC", 50),
                new Bogie("Chair", 80)
        );

        assertEquals(2, TrainConsistManagement.filterUsingStream(bogies).size());
    }

    @Test
    void testExecutionTimeMeasurement() throws InvalidCapacityException {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 70),
                new Bogie("AC", 50),
                new Bogie("Chair", 80)
        );

        assertTrue(TrainConsistManagement.measureLoopTime(bogies) > 0);
        assertTrue(TrainConsistManagement.measureStreamTime(bogies) > 0);
    }

    // UC14
    @Test
    void testException_NegativeCapacityThrowsException() {
        assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Sleeper", -10);
        });
    }

    // UC15
    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie b = new GoodsBogie("Cylindrical");

        b.assignCargo("Petroleum");

        assertEquals("Petroleum", b.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie b = new GoodsBogie("Rectangular");

        b.assignCargo("Petroleum");

        assertNull(b.getCargo());
    }
}
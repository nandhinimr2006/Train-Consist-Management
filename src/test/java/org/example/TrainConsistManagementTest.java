// ---------- UC14 Tests ----------
package org.example;
import org.example.Bogie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementTest {

    // ---------- UC14 Tests ----------

    @Test
    void testException_ValidCapacityCreation() throws InvalidCapacityException {
        Bogie b = new Bogie("Sleeper", 50);
        assertNotNull(b);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Sleeper", -10);
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Sleeper", 0);
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("AC", 0);
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        Bogie b = new Bogie("First Class", 80);

        assertEquals("First Class", b.getType());
        assertEquals(80, b.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        Bogie b1 = new Bogie("Sleeper", 60);
        Bogie b2 = new Bogie("AC", 70);

        assertNotNull(b1);
        assertNotNull(b2);
    }
}
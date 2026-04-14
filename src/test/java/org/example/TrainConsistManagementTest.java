import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementTest {

    private List<Bogie> getSampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 50),
                new Bogie("Sleeper", 80)
        );
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.getCapacity() > 70)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        // capacity = 60 should NOT be included
        assertFalse(result.stream().anyMatch(b -> b.getCapacity() == 60));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertFalse(result.stream().anyMatch(b -> b.getCapacity() < 60));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.getCapacity() > 100)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.getCapacity() > 40)
                .collect(Collectors.toList());

        assertEquals(4, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> emptyList = new ArrayList<>();

        List<Bogie> result = emptyList.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();
        int originalSize = original.size();

        List<Bogie> result = original.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertEquals(originalSize, original.size());
    }
}

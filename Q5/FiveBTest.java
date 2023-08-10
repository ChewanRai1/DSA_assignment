package Q5;
// Define the package for the fifth question

// Import required testing classes
import org.junit.Test;
import static org.junit.Assert.assertEquals;

// Define the testing class for the fifth question
public class FiveBTest {
    // Test case to check the minReorder method
    @Test
    public void testMinReorder() {
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        int expectedMinReversals = 3; // The expected minimum number of reversals required.

        // Call the minReorder method and compare with the expected result
        int result = FiveII.minReorder(n, connections);
        assertEquals(expectedMinReversals, result);
    }
}

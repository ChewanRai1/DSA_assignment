package Q1;// Import the required testing classes
import org.junit.Test;
import static org.junit.Assert.assertEquals;

// Define a testing class for the functionality of calculating minimum coins
public class OneBTest {

    // Define a test method to test the calculation of minimum coins
    @Test
    public void testMinimumCoins() {
        // Define an array of ratings
        int[] ratings = {1, 0, 2};

        // Define the expected minimum number of coins required based on the given ratings
        int expectedMinimumCoins = 5; // The minimum number of coins required based on the given ratings.

        // Calculate the result using the method for calculating minimum coins
        int result = AminCoinsDist.AminCoinsDist(ratings);

        // Assert that the calculated result matches the expected minimum number of coins
        assertEquals(expectedMinimumCoins, result);
    }
}

package Q1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Define a testing class for the functionality of calculating minimum cost
public class OneATest {
    
    // Define a test method to test the calculation of minimum cost
    @Test
    public void testMinimumCost() {
        // Define a matrix of clothing prices
        int[][] price = {
                {14, 4, 11},
                {11, 14, 3},
                {14, 2, 10}
        };
        
        // Define the expected minimum cost achieved by selecting specific clothing items
        int expectedMinimumCost = 9; // The minimum cost is achieved by selecting clothing 1, clothing 3, and clothing 3.

        // Calculate the result using the method for calculating minimum cost
        int result = AminCostCloth.minimumCost(price);
        
        // Assert that the calculated result matches the expected minimum cost
        assertEquals(expectedMinimumCost, result);
    }
}

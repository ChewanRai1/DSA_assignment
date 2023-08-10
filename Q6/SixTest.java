package Q6;
// Define the package for the test class


// Import required Java classes
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

// Define the test class for ParallelMergeSort
public class SixTest {

    // Test method to check the correctness of parallel merge sort
    @Test
    public void testParallelMergeSort() {
        // Define an input array and the expected sorted array
        int[] inputArray = {5, 3, 9, 1, 7, 2, 8, 4, 6};
        int[] expectedSortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Perform parallel merge sort on the input array
        Six.parallelMergeSort(inputArray);

        // Compare the sorted array with the expected sorted array
        assertArrayEquals(expectedSortedArray, inputArray);
    }
}

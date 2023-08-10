// Define the package for the fifth question
package Q5;

// Import required testing classes
import org.junit.Test;
import static org.junit.Assert.assertEquals;

// Define the testing class for the fifth question
public class FiveATest {
    // Test evaluating a solution that matches the target
    @Test
    public void evaluateWithMatchingSolution() {
        char[] solution = "Hello, World!".toCharArray();
        int result = FiveI.evaluate(solution);
        assertEquals(0, result); // Expected result is 0 because the solution matches the target
    }

    // Test evaluating a solution that differs from the target
    @Test
    public void evaluateWithDifferentSolution() {
        char[] solution = "Hdllo, Wwrld!".toCharArray();
        int result = FiveI.evaluate(solution);
        assertEquals(10, result); // Expected result is 10, which is the sum of absolute differences between ASCII values
    }

    // Test evaluating an empty solution
    @Test
    public void evaluateWithEmptySolution() {
        char[] solution = new char[0];
        int result = FiveI.evaluate(solution);
        assertEquals(0, result); // Expected result is 0 since there's nothing to evaluate
    }
}

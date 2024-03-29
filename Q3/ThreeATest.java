package Q3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreeATest {
    @Test
    public void testMaxPoints() {
        int[] targets = {3, 1, 5, 8};
        int expectedMaxPoints = 167; // The maximum points achievable by shooting at the targets.

        int result = ThreeI.maxPoints(targets);
        assertEquals(expectedMaxPoints, result);
    }
}
package Q4;
// Define the package for the fourth question

// Import required testing classes
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// Define the testing class for the fourth question
public class FourBTest {
    // Test positive case for areBrothers method
    @Test
    public void testAreBrothersPositive() {
        // Create a binary tree
        FourII.TreeNode root = new FourII.TreeNode(1);
        root.left = new FourII.TreeNode(2);
        root.right = new FourII.TreeNode(3);
        root.left.left = new FourII.TreeNode(4);

        int x = 2;
        int y = 3;

        // Create FourII instance and test if nodes are brothers
        FourII solution = new FourII();
        boolean result = solution.areBrothers(root, x, y);
        assertTrue("Nodes " + x + " and " + y + " are expected to be brothers.", result);
    }

    // Test negative case for areBrothers method
    @Test
    public void testAreBrothersNegative() {
        // Create a binary tree
        FourII.TreeNode root = new FourII.TreeNode(1);
        root.left = new FourII.TreeNode(2);
        root.right = new FourII.TreeNode(3);
        root.left.left = new FourII.TreeNode(4);

        int x = 2;
        int y = 4;

        // Create FourII instance and test if nodes are not brothers
        FourII solution = new FourII();
        boolean result = solution.areBrothers(root, x, y);
        assertFalse("Nodes " + x + " and " + y + " are not expected to be brothers.", result);
    }
}

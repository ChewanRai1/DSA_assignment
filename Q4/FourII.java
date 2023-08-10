// Define a package for the fourth question
package Q4;

// Define the FourII class for checking if two nodes are brothers in a binary tree
public class FourII {
    // Definition of TreeNode class
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Initialize variables to store depth and parent nodes for comparison
    private int xDepth = -1;
    private int yDepth = -1;
    private TreeNode xParent = null;
    private TreeNode yParent = null;

    // Method to check if two nodes are brothers
    public boolean areBrothers(TreeNode root, int x, int y) {
        // Find the nodes and their depth and parent nodes
        findNodes(root, null, 0, x, y);
        // Check if they have the same depth and different parent nodes
        return xDepth == yDepth && xParent != yParent;
    }

    // Recursive method to find nodes, depth, and parent nodes
    private void findNodes(TreeNode node, TreeNode parent, int depth, int x, int y) {
        if (node == null) {
            return;
        }

        if (node.val == x) {
            xDepth = depth;
            xParent = parent;
        } else if (node.val == y) {
            yDepth = depth;
            yParent = parent;
        }

        findNodes(node.left, node, depth + 1, x, y);
        findNodes(node.right, node, depth + 1, x, y);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        int x = 4;
        int y = 3;

        // Create FourII instance and check if nodes are brothers
        FourII solution = new FourII();
        boolean result = solution.areBrothers(root, x, y);
        System.out.println("Nodes " + x + " and " + y + " are brothers: " + result);
    }
}

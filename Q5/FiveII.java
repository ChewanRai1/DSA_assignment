// Define the package for the fifth question
package Q5;

// Import the required Java classes
import java.util.ArrayList;
import java.util.List;

// Define the FiveII class for calculating the minimum number of reversals
public class FiveII {
    // Declare global variables for graph, visited nodes, and reverse counts
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] reverseCount;

    // Method to calculate the minimum number of reversals
    public static int minReorder(int n, int[][] connections) {
        // Initialize the graph with adjacency lists
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Populate the graph with connections and reversed connections
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            graph.get(from).add(to);
            graph.get(to).add(-from); // Negative value to indicate reversed edge
        }

        // Initialize arrays to track visited nodes and reverse counts
        visited = new boolean[n];
        reverseCount = new int[n];

        // Perform DFS to calculate reverse counts
        dfs(0);

        // Count the total number of reversals needed
        int totalReversals = 0;
        for (int count : reverseCount) {
            if (count > 0) {
                totalReversals++;
            }
        }

        return totalReversals;
    }

    // Depth-First Search (DFS) method to calculate reverse counts
    private static void dfs(int node) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[Math.abs(neighbor)]) {
                if (neighbor < 0) {
                    reverseCount[node]++;
                    neighbor = -neighbor;
                }
                dfs(neighbor);
                reverseCount[node] += reverseCount[neighbor];
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        int result = minReorder(n, connections);
        System.out.println("Minimum number of reversals: " + result);
    }
}

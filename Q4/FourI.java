// Define a package for the fourth question
package Q4;

// Import required Java classes
import java.util.*;

// Define the FourA class for calculating minimum steps
public class FourI {

    // Method to calculate the minimum steps to complete tasks
    public static int minSteps(int N, int[][] prerequisites) {
        // Create a graph and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N + 1];

        // Initialize the graph with empty lists
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph and in-degree array based on prerequisites
        for (int[] prereq : prerequisites) {
            int x = prereq[0];
            int y = prereq[1];
            graph.get(x).add(y);
            inDegree[y]++;
        }

        // Create a queue and add nodes with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Initialize steps counter
        int steps = 0;
        // Perform topological sorting using BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int neighbor : graph.get(current)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
            steps++;
        }

        // Check for cycles by examining in-degree array
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] > 0) {
                return -1; // There's a cycle, can't complete all tasks
            }
        }

        return steps; // Return the minimum steps to complete tasks
    }

    // Main method for testing
    public static void main(String[] args) {
        int N = 3;
        int[][] prerequisites = {{1, 3}, {2, 3}};
        int result = minSteps(N, prerequisites);
        System.out.println("Minimum steps: " + result);
    }
}

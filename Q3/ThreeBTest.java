// Define the package for the third question
package Q3;

// Import required testing classes
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// Define the testing class for the third question
public class ThreeBTest {
    // Test the Bellman-Ford algorithm with positive weights
    @Test
    public void testBellmanFordWithPositiveWeights() {
        int vertices = 5;
        int edges = 8;

        ThreeII bellmanFord = new BellmanFord(vertices, edges);
        bellmanFord.addEdge(0, 1, 1);
        bellmanFord.addEdge(0, 2, 4);
        bellmanFord.addEdge(1, 2, 3);
        bellmanFord.addEdge(1, 3, 2);
        bellmanFord.addEdge(1, 4, 2);
        bellmanFord.addEdge(3, 2, 5);
        bellmanFord.addEdge(3, 1, 1);
        bellmanFord.addEdge(4, 3, 3);

        int sourceVertex = 0;
        bellmanFord.bellmanFord(sourceVertex);
    }

    // Test the Bellman-Ford algorithm with negative cycles
    @Test
    public void testBellmanFordWithNegativeCycles() {
        int vertices = 4;
        int edges = 5;

        BellmanFord bellmanFord = new BellmanFord(vertices, edges);
        bellmanFord.addEdge(0, 1, 1);
        bellmanFord.addEdge(1, 2, -3);
        bellmanFord.addEdge(2, 3, -2);
        bellmanFord.addEdge(3, 1, 2);
        bellmanFord.addEdge(3, 0, -4);

        int sourceVertex = 0;
        bellmanFord.bellmanFord(sourceVertex);
    }

    // Test the MaxHeapPriorityQueue class
    @Test
    public void testMaxHeapPriorityQueue() {
        MaxHeapPriorityQueue maxHeap = new MaxHeapPriorityQueue();
        maxHeap.insert(5);
        maxHeap.insert(10);
        maxHeap.insert(2);
        maxHeap.insert(8);
        maxHeap.insert(1);

        // Test extracting max elements and checking if the queue is empty
        assertEquals(10, maxHeap.extractMax());
        assertEquals(8, maxHeap.extractMax());
        assertEquals(5, maxHeap.extractMax());
        assertEquals(2, maxHeap.extractMax());
        assertEquals(1, maxHeap.extractMax());
        assertTrue(maxHeap.isEmpty());
    }
}

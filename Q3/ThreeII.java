package Q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

// Define a class to represent edges with source, destination, and weight
class Edge {
    int source, destination, weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

// Bellman-Ford algorithm to find shortest paths and detect negative cycles
class BellmanFord {
    private int vertices, edges;
    private List<Edge> edgeList;

    // Constructor
    BellmanFord(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        this.edgeList = new ArrayList<>();
    }

    // Add a directed edge to the edge list
    void addEdge(int source, int destination, int weight) {
        edgeList.add(new Edge(source, destination, weight));
    }

    // Run the Bellman-Ford algorithm
    void bellmanFord(int source) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relaxation step: Run (V-1) iterations to find shortest paths
        for (int i = 1; i < vertices; ++i) {
            for (Edge edge : edgeList) {
                int u = edge.source;
                int v = edge.destination;
                int w = edge.weight;
                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edgeList) {
            int u = edge.source;
            int v = edge.destination;
            int w = edge.weight;
            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                System.out.println("Negative cycle detected!");
                return;
            }
        }

        // Print shortest distances
        System.out.println("Vertex\tDistance");
        for (int i = 0; i < vertices; ++i) {
            System.out.println(i + "\t\t" + distance[i]);
        }
    }
}

// MaxHeapPriorityQueue implementation
class MaxHeapPriorityQueue {
    private List<Integer> heap;

    MaxHeapPriorityQueue() {
        heap = new ArrayList<>();
    }

    // Insert a value while maintaining max heap property
    void insert(int value) {
        heap.add(value);
        int currentIndex = heap.size() - 1;
        int parentIndex = (currentIndex - 1) / 2;
        while (currentIndex > 0 && heap.get(currentIndex) > heap.get(parentIndex)) {
            Collections.swap(heap, currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / 2;
        }
    }

    // Extract the maximum element from the heap
    int extractMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty.");
        }

        int maxValue = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);

        int currentIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        while (leftChildIndex < heap.size()) {
            int largestIndex = currentIndex;

            if (heap.get(leftChildIndex) > heap.get(largestIndex)) {
                largestIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(largestIndex)) {
                largestIndex = rightChildIndex;
            }

            if (largestIndex == currentIndex) {
                break;
            }

            Collections.swap(heap, currentIndex, largestIndex);
            currentIndex = largestIndex;
            leftChildIndex = 2 * currentIndex + 1;
            rightChildIndex = 2 * currentIndex + 2;
        }

        return maxValue;
    }

    boolean isEmpty() {
        return heap.isEmpty();
    }
}

// Main class
public class ThreeII {

    public static void main(String[] args) {
        int vertices = 5;
        int edges = 8;

        // Create a BellmanFord instance and add edges
        BellmanFord bellmanFord = new BellmanFord(vertices, edges);
        bellmanFord.addEdge(0, 1, -1);
        // ... (add other edges)

        int sourceVertex = 0;
        bellmanFord.bellmanFord(sourceVertex);

        // Create a MaxHeapPriorityQueue instance and perform operations
        MaxHeapPriorityQueue maxHeap = new MaxHeapPriorityQueue();
        maxHeap.insert(5);
        // ... (insert other values)

        System.out.println("Max heap elements:");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.extractMax());
        }
    }
}

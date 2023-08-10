package Q6;
// Define the package for the sixth question


// Import required Java classes
import java.util.Arrays;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

// Define the ParallelMergeSort class
public class Six {
    // Define the MergeSortTask class that extends RecursiveAction for parallel sorting
    private static class MergeSortTask extends RecursiveAction {
        private final int[] array;
        private final int start;
        private final int end;

        // Constructor to initialize the task
        public MergeSortTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            // Base case: if the subarray size is small, perform regular merge sort
            if (end - start <= 1) {
                return;
            }

            // Calculate the middle index
            int mid = (start + end) / 2;

            // Create subtasks for left and right halves of the array
            MergeSortTask leftTask = new MergeSortTask(array, start, mid);
            MergeSortTask rightTask = new MergeSortTask(array, mid, end);

            // Invoke both subtasks in parallel
            invokeAll(leftTask, rightTask);

            // Merge the sorted halves
            merge(array, start, mid, end);
        }

        // Method to merge two sorted subarrays
        private void merge(int[] array, int start, int mid, int end) {
            int[] merged = new int[end - start];
            int leftIndex = start;
            int rightIndex = mid;
            int mergedIndex = 0;

            // Compare elements from left and right subarrays and merge
            while (leftIndex < mid && rightIndex < end) {
                if (array[leftIndex] < array[rightIndex]) {
                    merged[mergedIndex++] = array[leftIndex++];
                } else {
                    merged[mergedIndex++] = array[rightIndex++];
                }
            }

            // Copy remaining elements from the left subarray
            while (leftIndex < mid) {
                merged[mergedIndex++] = array[leftIndex++];
            }

            // Copy remaining elements from the right subarray
            while (rightIndex < end) {
                merged[mergedIndex++] = array[rightIndex++];
            }

            // Copy merged elements back to the original array
            System.arraycopy(merged, 0, array, start, merged.length);
        }
    }

    // Method to perform parallel merge sort
    public static void parallelMergeSort(int[] array) {
        ForkJoinPool pool = new ForkJoinPool();
        MergeSortTask task = new MergeSortTask(array, 0, array.length);
        pool.invoke(task);
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] inputArray = {5, 3, 9, 1, 7, 2, 8, 4, 6};
        parallelMergeSort(inputArray);
        System.out.println("Sorted array: " + Arrays.toString(inputArray));
    }
}

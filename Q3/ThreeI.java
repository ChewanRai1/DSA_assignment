// Define a class for the functionality of calculating maximum points
package Q3;

public class ThreeI {
    // Method to calculate the maximum points
    public static int maxPoints(int[] a) {
        int n = a.length;
        
        // Create an array to hold padded targets for convenience
        int[] paddedTargets = new int[n + 2];
        paddedTargets[0] = paddedTargets[n + 1] = 1;
        System.arraycopy(a, 0, paddedTargets, 1, n);

        // Create a 2D array for dynamic programming
        int[][] dp = new int[n + 2][n + 2];

        // Loop through possible lengths of the subarray
        for (int len = 1; len <= n; len++) {
            // Loop through possible starting positions of the subarray
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                // Loop through possible splitting points within the subarray
                for (int i = left; i <= right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                            dp[left][i - 1] + paddedTargets[left - 1] * paddedTargets[i] * paddedTargets[right + 1] + dp[i + 1][right]);
                }
            }
        }

        return dp[1][n]; // Return the maximum points for the entire array
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] a = {3, 1, 5, 8};
        int result = maxPoints(a);
        System.out.println("Maximum points: " + result);
    }
}

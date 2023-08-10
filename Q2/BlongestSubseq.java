package Q2;
import java.util.Arrays; // Import the Arrays class

public class BlongestSubseq {

    public static void main(String[] args) {
        int[] nums = {8, 5, 4, 2, 1, 4, 3, 4, 3, 1, 15}; // Input array
        int k = 3; // Maximum difference allowed
        System.out.println(longestSubsequence(nums, k)); // Print the result of the longest subsequence
    }

    public static int longestSubsequence(int[] nums, int k) {
        int n = nums.length; // Length of the input array
        int[] dp = new int[n]; // Create an array to store the lengths of longest subsequences

        for (int i = 0; i < n; i++) {
            int maxLen = 0; // Initialize the length of the longest subsequence for current element
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j] && nums[j] - nums[i] <= k) {
                    // If the current element is smaller than a previous element and
                    // their difference is within the allowed range
                    maxLen = Math.max(maxLen, dp[j]); // Update the maximum length
                }
            }
            dp[i] = maxLen + 1; // Store the length of longest subsequence ending at current element
        }

        int maxLength = 0; // Initialize the maximum length of all subsequences
        for (int len : dp) {
            maxLength = Math.max(maxLength, len); // Update the maximum length
        }
        System.out.println(Arrays.toString(dp)); // Print the DP array for debugging
        return maxLength; // Return the maximum length of all subsequences
    }
}

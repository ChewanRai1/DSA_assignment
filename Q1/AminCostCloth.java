package Q1;
public class AminCostCloth {

    public static void main(String[] args) {
        // Define the prices of clothing options for each person
        int[][] price = {
            {14, 4, 11},
            {11, 14, 3},
            {14, 2, 10}
        };

        // Calculate the minimum cost required for clothing
        int minimumCost = minimumCost(price);

        // Print the result
        System.out.println("Minimum cost required: " + minimumCost);
    }

    public static int minimumCost(int[][] price) {
        // Initialize variables to track minimum costs for each clothing option
        int minCost1 = 0;
        int minCost2 = 0;
        int minCost3 = 0;

        // Iterate through each person's clothing options
        for (int[] person : price) {
            // Calculate new minimum costs based on previous choices and current person's options
            int newMinCost1 = person[0] + Math.min(minCost2, minCost3);
            int newMinCost2 = person[1] + Math.min(minCost1, minCost3);
            int newMinCost3 = person[2] + Math.min(minCost1, minCost2);

            // Update the minimum costs for the next iteration
            minCost1 = newMinCost1;
            minCost2 = newMinCost2;
            minCost3 = newMinCost3;
        }

        // Return the overall minimum cost among all combinations
        return Math.min(minCost1, Math.min(minCost2, minCost3));
    }
}

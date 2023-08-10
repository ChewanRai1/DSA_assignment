package Q5;
// Define the package for the fifth question


// Import the required Java class
import java.util.Random;

// Define the FiveI class for generating solutions
public class FiveI {
    public static void main(String[] args) {
        // Generate a random initial solution
        char[] best = generateRandomSolution(13);
        // Evaluate the initial solution
        int bestScore = evaluate(best);

        // Infinite loop until the best solution matches the target
        while (true) {
            System.out.println("Best score so far: " + bestScore +
                    " Solution: " + new String(best));

            // If the best score is 0 (solution matches target), exit the loop
            if (bestScore == 0) {
                break;
            }

            // Generate a new solution by mutating the best solution
            char[] newSolution = best.clone();
            mutateSolution(newSolution);

            // Evaluate the new solution
            int score = evaluate(newSolution);

            // If the new solution's score is better, update the best solution
            if (score < bestScore) {
                best = newSolution;
                bestScore = score;
            }
        }
    }

    // Method to generate a random solution of a specified length
    public static char[] generateRandomSolution(int length) {
        char[] solution = new char[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            solution[i] = (char) (random.nextInt(94) + 32);
        }

        return solution;
    }

    // Method to evaluate the difference (score) between a solution and the target string
    public static int evaluate(char[] solution) {
        String target = "Hello, World!";
        int diff = 0;

        for (int i = 0; i < target.length(); i++) {
            char s = solution[i];
            char t = target.charAt(i);
            diff += Math.abs((int) s - (int) t); // Calculate the absolute difference between ASCII values
        }

        return diff;
    }

    // Method to mutate a solution by randomly changing a character
    public static void mutateSolution(char[] solution) {
        Random random = new Random();
        int index = random.nextInt(solution.length);
        solution[index] = (char) (random.nextInt(94) + 32);
    }
}


package Q2;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BrandomPortpick {
    private Set<Integer> whitelist; // Set to store allowed ports
    private Random random; // Random number generator

    public BrandomPortpick(int k, int[] blacklisted_ports) {
        whitelist = new HashSet<>(); // Initialize the set for allowed ports
        for (int i = 0; i < k; i++) {
            whitelist.add(i); // Add ports from 0 to k-1 to the whitelist
        }

        for (int port : blacklisted_ports) {
            whitelist.remove(port); // Remove blacklisted ports from the whitelist
        }

        random = new Random(); // Initialize the random number generator
    }

    public int get() {
        int randomIndex = random.nextInt(whitelist.size()); // Generate a random index within the whitelist size
        int randomPort = 0;
        for (int port : whitelist) {
            if (randomIndex == 0) {
                randomPort = port; // Store the randomly selected port
                break;
            }
            randomIndex--;
        }
        return randomPort; // Return the selected random port
    }

    public static void main(String[] args) {
        int[] blacklisted_ports = {2, 3, 5}; // Array of blacklisted ports
        BrandomPortpick picker = new BrandomPortpick(7, blacklisted_ports); // Create an instance of RandomPortPicker
        System.out.println(picker.get()); // Output: Random allowed port (e.g., 0)
        System.out.println(picker.get()); // Output: Another random allowed port (e.g., 4)
    }
}

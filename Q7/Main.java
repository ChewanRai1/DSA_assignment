package Q7;

import javax.swing.*;

// This is the main class that runs the program
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Q7.AllUserFrame frame = new Q7.AllUserFrame(); // this is the main frame that contains all the users
            frame.setVisible(true);
        });
    }
}

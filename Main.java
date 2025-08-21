import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the visual keyboard frame
        VisualKeyboardFrame a = new VisualKeyboardFrame();

        // Set default close operation to exit the program when the window is closed
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the window size
        a.setSize(865,600);

        // Make the window visible
        a.setVisible(true);

        // Disable resizing
        a.setResizable(false);
    }
}

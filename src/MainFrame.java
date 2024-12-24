import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel currentPanel; // To track the current panel
    private LoginPanel loginPanel;
    private GalleryPanel galleryPanel;

    public MainFrame() {
        // Frame setup: Keeping your original customization
        this.setTitle("Pompompurin's Corner");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setResizable(false);

        // Set icon and background color (your original colors and icon)
        ImageIcon icon = new ImageIcon("resources\\logo.jpg"); // Adjust the path to your logo
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(253, 253, 150)); // Your custom background color

        // Initialize panels
        loginPanel = new LoginPanel(this);
        galleryPanel = new GalleryPanel();

        // Set initial panel to the login panel
        currentPanel = loginPanel;
        this.add(currentPanel);

        this.setVisible(true);
    }

    // Switch to the gallery panel
    public void switchToGalleryPanel() {
        this.remove(currentPanel); // Remove the current panel
        currentPanel = galleryPanel; // Set current panel to gallery panel
        this.add(currentPanel); // Add the gallery panel to the frame
        this.revalidate(); // Refresh the frame
        this.repaint();
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}

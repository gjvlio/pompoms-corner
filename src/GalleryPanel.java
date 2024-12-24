import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GalleryPanel extends JPanel {

    public GalleryPanel() {
        this.setLayout(new GridLayout(2, 3, 10, 10));
        this.setBackground(new Color(253, 253, 150)); // Your custom background color

        // List of image paths (replace with your actual paths)
        String[] imagePaths = {
            "resources\\image1.jpg", "resources\\image2.jpg", "resources\\image3.jpg", "resources\\image4.jpg",
            "resources\\image5.jpg", "resources\\image6.jpg", "resources\\image7.jpg", "resources\\image8.jpg"
        };

        // Add images to the gallery with custom scaling
        for (String path : imagePaths) {
            ImageIcon icon = new ImageIcon(path);
            Image scaledImage = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));

            // Enlarge image on click
            imageLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    displayImage(path);
                }
            });

            this.add(imageLabel);
        }
    }

    // Display a full-size image in a new window
    private void displayImage(String imagePath) {
        JFrame imageFrame = new JFrame("Pompom's Gallery");
        imageFrame.setSize(400, 400);
        imageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set icon for the image frame (same as in MainFrame)
        ImageIcon icon = new ImageIcon("resources\\logo.jpg");  // Replace with your actual icon path
        imageFrame.setIconImage(icon.getImage());

        // Create the image label and set the full-size image
        ImageIcon imageIcon = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(new ImageIcon(imageIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH)));
        imageFrame.add(imageLabel);

        imageFrame.setVisible(true);
    }
}

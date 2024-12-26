import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class GalleryPanel extends JPanel {

    public GalleryPanel() {
        this.setLayout(new GridLayout(2, 3, 10, 10));
        this.setBackground(new Color(253, 253, 150)); // Your custom background color

        // List of image paths (replace with your actual paths)
        String[] imagePaths = {
            "resources\\image1.jpg", "resources\\image2.jpg", "resources\\image3.jpg", "resources\\image4.jpg",
            "resources\\image5.jpg", "resources\\image6.jpg", "resources\\image7.jpg", "resources\\image8.jpg"
        };

        // Map of image paths to descriptions
        Map<String, String> imageDescriptions = new HashMap<>();
        imageDescriptions.put("resources\\image1.jpg", "Pompom pretends like an old man ^~^");
        imageDescriptions.put("resources\\image2.jpg", "What would Pompom taste like if he became a pudding :0");
        imageDescriptions.put("resources\\image3.jpg", "Pompom loves to take a nap with his buddies ^0^");
        imageDescriptions.put("resources\\image4.jpg", "Pompom loves to play with his buddies <3");
        imageDescriptions.put("resources\\image5.jpg", "The sun is out, let's play outside!");
        imageDescriptions.put("resources\\image6.jpg", "Pompom is so silly :P");
        imageDescriptions.put("resources\\image7.jpg", "Pompom is a ramen enthusiast >:0");
        imageDescriptions.put("resources\\image8.jpg", "nyomnyomnyom... Pompom loves to eat a big bao");

        // Add images to the gallery with custom scaling
        for (String path : imagePaths) {
            ImageIcon icon = new ImageIcon(path);
            Image scaledImage = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));

            // Enlarge image on click
            imageLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    displayImage(path, imageDescriptions.get(path));
                }
            });

            this.add(imageLabel);
        }
    }

    private void displayImage(String imagePath, String description) {
        JFrame imageFrame = new JFrame("Pompom's Gallery");
        imageFrame.setSize(400, 400);
        imageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
        // Set icon for the image frame (same as in MainFrame)
        ImageIcon icon = new ImageIcon("resources\\logo.jpg"); // Replace with your actual icon path
        imageFrame.setIconImage(icon.getImage());
    
        // Set customized background picture
        ImageIcon bgPic = new ImageIcon("resources\\pompom_text.jpg");
        JLabel bgLabel = new JLabel(new ImageIcon(bgPic.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH)));
        bgLabel.setLayout(new GridBagLayout()); // Use GridBagLayout for centering
    
        // Create a panel to hold the image and description
        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS)); // Vertical alignment
    
        // Add the image
        ImageIcon imageIcon = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(new ImageIcon(imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally
        contentPanel.add(imageLabel);
    
        // Add some spacing between the image and the description
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
    
        // Add the description
        JTextArea descriptionArea = new JTextArea(description != null ? description : "No description available");
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        descriptionArea.setForeground(Color.BLACK);
        descriptionArea.setOpaque(false);
        descriptionArea.setEditable(false);
        descriptionArea.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally
        descriptionArea.setMaximumSize(new Dimension(300, 100)); // Limit width for wrapping
        contentPanel.add(descriptionArea);
    
        // Add the content panel to the background label
        bgLabel.add(contentPanel);
        imageFrame.setContentPane(bgLabel);
    
        imageFrame.setVisible(true);
    }    
}

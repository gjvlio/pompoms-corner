import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginPanel extends JPanel implements ActionListener {

    private JTextField usernameText;
    private JPasswordField passwordText;
    private JLabel success;
    private MainFrame frame;

    public LoginPanel(MainFrame frame) {
        this.frame = frame; // Reference to the main frame

        // Set layout
        this.setLayout(new GridBagLayout());
        this.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Image Label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        ImageIcon originalImage = new ImageIcon("resources\\pompompurin.png");
        Image scaledImage = originalImage.getImage().getScaledInstance(240, 240, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        this.add(imageLabel, gbc);

        // Username Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
        this.add(usernameLabel, gbc);

        // Username TextField
        gbc.gridx = 1;
        usernameText = new JTextField(20);
        this.add(usernameText, gbc);

        // Password Label
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
        this.add(passwordLabel, gbc);

        // Password TextField
        gbc.gridx = 1;
        passwordText = new JPasswordField(20);
        this.add(passwordText, gbc);

        // Login Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        loginButton.setBackground(new Color(84, 47, 49));
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        this.add(loginButton, gbc);

        // Success Label
        gbc.gridx = 0;
        gbc.gridy = 4;
        success = new JLabel("");
        success.setFont(new Font("Century Gothic", Font.BOLD, 16));
        this.add(success, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameText.getText();
        String password = new String(passwordText.getPassword());

        // Validate credentials
        if (username.equals("el_c0re") && password.equals("AuqNaOOP!") || username.equals("test") && password.equals("123")) {
            success.setText(""); // Clear success message
            // Switch to a new panel (GalleryPanel)
            frame.switchToGalleryPanel();
        } else {
            success.setText("Invalid username or password.");
        }
    }

}

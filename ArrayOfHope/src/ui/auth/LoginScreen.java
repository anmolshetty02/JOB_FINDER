package ui.auth;

import ui.main.MainDashboard;

import javax.swing.*;
import java.awt.*;

public class LoginScreen {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Nimbus not available, using default.");
        }

        JFrame frame = new JFrame("🔐 Array of Hope - Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(400, 300));

        JPanel outer = new JPanel(new GridBagLayout());
        outer.setBackground(new Color(34, 34, 34));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(new Color(34, 34, 34));
        formPanel.setMaximumSize(new Dimension(350, 9999));
        formPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel("🌟 Welcome to Array of Hope");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(Color.RED);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        for (JLabel label : new JLabel[]{userLabel, passLabel}) {
            label.setForeground(Color.LIGHT_GRAY);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        JTextField usernameField = new JTextField();
        usernameField.setMaximumSize(new Dimension(350, 30));
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(350, 30));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton loginButton = new JButton("🔓 Login");
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setMaximumSize(new Dimension(150, 35));

        // NEW: Forgot Password & Register
        JPanel linkPanel = new JPanel();
        linkPanel.setBackground(new Color(34, 34, 34));
        linkPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel forgotPass = new JLabel("Forgot Password?");
        forgotPass.setForeground(Color.CYAN);
        forgotPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel register = new JLabel("Register");
        register.setForeground(Color.ORANGE);
        register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        linkPanel.add(forgotPass);
        linkPanel.add(new JLabel("  |  ")); // spacer
        linkPanel.add(register);

        // Login logic
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword()).trim();

            if (username.equals("admin") && password.equals("1234")) {
                frame.dispose();
                MainDashboard.main(null);
            } else {
                JOptionPane.showMessageDialog(frame, "❌ Invalid credentials.\nHint: admin / 1234", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Click events for 
     // Forgot Password
        forgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.dispose(); // Close login screen
                ForgotPasswordScreen.main(null); // Launch Forgot Password
            }
        });

        // Register
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.dispose(); // Close login screen
                RegisterScreen.main(null); // Launch Register
            }
        });

        // Add to panel
        formPanel.add(title);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        formPanel.add(userLabel);
        formPanel.add(usernameField);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(passLabel);
        formPanel.add(passwordField);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        formPanel.add(loginButton);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(linkPanel);

        outer.add(formPanel);
        frame.setContentPane(outer);
        frame.setVisible(true);
    }
}
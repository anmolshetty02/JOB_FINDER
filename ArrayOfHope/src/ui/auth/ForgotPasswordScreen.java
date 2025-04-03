package ui.auth;

import javax.swing.*;
import java.awt.*;

public class ForgotPasswordScreen {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Nimbus not available.");
        }

        JFrame frame = new JFrame("🔑 Forgot Password - Array of Hope");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(400, 300));

        JPanel outer = new JPanel(new GridBagLayout());
        outer.setBackground(new Color(34, 34, 34));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(new Color(34, 34, 34));
        formPanel.setMaximumSize(new Dimension(400, 9999));

        JLabel title = new JLabel("Recover Your Password");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(new Color(173, 216, 230));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel emailLabel = new JLabel("Enter your registered email:");
        emailLabel.setForeground(Color.LIGHT_GRAY);
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField emailField = new JTextField();
        emailField.setMaximumSize(new Dimension(350, 30));
        emailField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton resetButton = new JButton("📩 Send Reset Link");
        resetButton.setBackground(new Color(100, 149, 237));
        resetButton.setForeground(Color.WHITE);
        resetButton.setFocusPainted(false);
        resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        resetButton.setMaximumSize(new Dimension(180, 35));

        // Reset button logic (mock)
        resetButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "📧 Password reset link sent to " + emailField.getText());
            frame.dispose();
            LoginScreen.main(null);
        });

        // 🔙 Back Button
        JButton backButton = new JButton("← Back to Login");
        backButton.setBackground(new Color(85, 85, 85));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setMaximumSize(new Dimension(180, 30));
        backButton.addActionListener(e -> {
            frame.dispose();
            LoginScreen.main(null);
        });

        formPanel.add(title);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        formPanel.add(resetButton);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(backButton);

        outer.add(formPanel);
        frame.setContentPane(outer);
        frame.setVisible(true);
    }
}
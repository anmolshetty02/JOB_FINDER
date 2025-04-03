package ui.auth;

import javax.swing.*;
import java.awt.*;

public class RegisterScreen {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Nimbus not available.");
        }

        JFrame frame = new JFrame("📝 Register - Array of Hope");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(450, 400));

        JPanel outer = new JPanel(new GridBagLayout());
        outer.setBackground(new Color(34, 34, 34));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(new Color(34, 34, 34));
        formPanel.setMaximumSize(new Dimension(400, 9999));
        formPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel("Create Your Account");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(new Color(173, 216, 230));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] labels = {"Full Name:", "Email:", "Username:", "Password:", "Confirm Password:"};
        JTextField[] fields = new JTextField[5];

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setForeground(Color.LIGHT_GRAY);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            formPanel.add(label);

            if (i >= 3) {
                fields[i] = new JPasswordField();
            } else {
                fields[i] = new JTextField();
            }

            fields[i].setMaximumSize(new Dimension(350, 30));
            fields[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            formPanel.add(fields[i]);
            formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        JButton registerButton = new JButton("✅ Register");
        registerButton.setBackground(new Color(60, 179, 113));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setMaximumSize(new Dimension(150, 35));

        registerButton.addActionListener(e -> {
            String password = ((JPasswordField) fields[3]).getText();
            String confirmPassword = ((JPasswordField) fields[4]).getText();

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(frame, "❌ Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "🎉 Account registered (mock)!");
                frame.dispose();
                LoginScreen.main(null); // Back to login after registration
            }
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

        formPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        formPanel.add(registerButton);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(backButton);

        outer.add(formPanel);
        frame.setContentPane(outer);
        frame.setVisible(true);
    }
}
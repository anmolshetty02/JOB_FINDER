package ui.main;
import ui.views.PostJobScreen;
import ui.views.ViewJobsScreen;
import javax.swing.*;
import java.awt.*;

public class MainDashboard {
    public static void main(String[] args) {
        // Set modern dark look & feel (if available)
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Nimbus LookAndFeel not found, using default.");
        }

        // Create frame
        JFrame frame = new JFrame("💼 Array of Hope - Job Portal Dashboard");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Create main panel with vertical layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panel.setBackground(new Color(34, 34, 34)); // Dark background

        // Title label
        JLabel title = new JLabel("🌟 Welcome to Array of Hope Job Portal", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);

        panel.add(Box.createRigidArea(new Dimension(0, 40)));

        // Custom button style
     // Create and style Post Job button
        JButton postJobButton = createStyledButton("➕ Post New Job");
        postJobButton.addActionListener(e -> PostJobScreen.main(null));

     // Correct version ✅
        JButton viewJobsButton = createStyledButton("📋 View All Jobs");
        viewJobsButton.addActionListener(e -> {
            System.out.println("✅ View Jobs Button Clicked");
            ViewJobsScreen.showJobList(frame);
        });
        JButton filterJobsButton = createStyledButton("🔍 Filter Jobs");
        JButton applyJobButton = createStyledButton("📨 Apply to Job");
        JButton exitButton = createStyledButton("❌ Exit");
        exitButton.addActionListener(e -> System.exit(0));

        // Add to panel
        panel.add(postJobButton);
        panel.add(Box.createRigidArea(new Dimension(0, 12)));
        panel.add(viewJobsButton);
        panel.add(Box.createRigidArea(new Dimension(0, 12)));
        panel.add(filterJobsButton);
        panel.add(Box.createRigidArea(new Dimension(0, 12)));
        panel.add(applyJobButton);
        panel.add(Box.createRigidArea(new Dimension(0, 12)));
        panel.add(exitButton);

        // Add panel to frame
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
    private static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(220, 45));
        button.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        button.setBackground(new Color(55, 55, 55));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        return button;
    }
}
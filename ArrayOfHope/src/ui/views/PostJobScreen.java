package ui.views;

import data.JobDAO;
import model.Job;

import javax.swing.*;
import java.awt.*;

public class PostJobScreen {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PostJobScreen().createUI());
    }

    public void createUI() {
        JFrame frame = new JFrame("📝 Post a Job - Array of Hope");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 450);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(400, 350));

        JPanel outer = new JPanel(new GridBagLayout());
        outer.setBackground(new Color(34, 34, 34));

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setBackground(new Color(34, 34, 34));
        form.setMaximumSize(new Dimension(350, 9999));
        form.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel("Post a New Job");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(new Color(173, 216, 230));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField titleField = new JTextField();
        JTextField companyField = new JTextField();
        JTextField locationField = new JTextField();
        JTextArea descArea = new JTextArea(4, 20);
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(descArea);

        String[] labels = {"Title:", "Company:", "Location:", "Description:"};
        JComponent[] components = {titleField, companyField, locationField, scrollPane};

        for (int i = 0; i < labels.length; i++) {
            JLabel lbl = new JLabel(labels[i]);
            lbl.setForeground(Color.LIGHT_GRAY);
            lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            form.add(lbl);

            components[i].setMaximumSize(new Dimension(350, 30));
            components[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            form.add(components[i]);
            form.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        JButton postBtn = new JButton("✅ Post Job");
        postBtn.setBackground(new Color(60, 179, 113));
        postBtn.setForeground(Color.WHITE);
        postBtn.setFocusPainted(false);
        postBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        postBtn.setMaximumSize(new Dimension(150, 35));

        // ⛓️ Button Action
        postBtn.addActionListener(e -> {
            String titleText = titleField.getText().trim();
            String company = companyField.getText().trim();
            String location = locationField.getText().trim();
            String description = descArea.getText().trim();

            if (titleText.isEmpty() || company.isEmpty() || location.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all required fields.", "Missing Info", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Job job = new Job(titleText, company, location, description);
            JobDAO.insertJob(job);
            JOptionPane.showMessageDialog(frame, "🎉 Job posted successfully!");
            frame.dispose();
        });

        form.add(postBtn);
        outer.add(form);

        frame.setContentPane(outer);
        frame.setVisible(true);
    }
}
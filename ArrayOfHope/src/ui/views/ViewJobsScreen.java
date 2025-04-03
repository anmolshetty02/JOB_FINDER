package ui.views;

import data.JobDAO;
import model.Job;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewJobsScreen {

    public static void showJobList(JFrame parentFrame) {
        // Create new window
        JFrame frame = new JFrame("📋 View All Jobs");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(parentFrame);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(40, 40, 40));
        panel.setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("Available Job Listings", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel, BorderLayout.NORTH);

        // Fetch jobs
        List<Job> jobs = JobDAO.getAllJobs();
        JTextArea jobArea = new JTextArea();
        jobArea.setEditable(false);
        jobArea.setBackground(new Color(30, 30, 30));
        jobArea.setForeground(Color.WHITE);
        jobArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

        if (jobs.isEmpty()) {
            jobArea.setText("⚠️ No jobs found.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Job job : jobs) {
                sb.append("🔹 Title: ").append(job.getTitle()).append("\n")
                  .append("🏢 Company: ").append(job.getCompany()).append("\n")
                  .append("📍 Location: ").append(job.getLocation()).append("\n")
                  .append("📝 Description: ").append(job.getDescription()).append("\n")
                  .append("──────────────────────────────\n");
            }
            jobArea.setText(sb.toString());
        }

        JScrollPane scrollPane = new JScrollPane(jobArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
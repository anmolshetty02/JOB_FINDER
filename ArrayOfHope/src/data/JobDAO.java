package data;

import model.Job;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {

    // Create table if not exists
    public static void createJobTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS jobs (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                title TEXT NOT NULL,
                company TEXT NOT NULL,
                location TEXT NOT NULL,
                description TEXT
            );
        """;

        try (Connection conn = SQLiteConnector.connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("❌ Table Creation Error: " + e.getMessage());
        }
    }

    // Insert job posting
    public static void insertJob(Job job) {
        String sql = "INSERT INTO jobs(title, company, location, description) VALUES (?, ?, ?, ?)";

        try (Connection conn = SQLiteConnector.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, job.getTitle());
            pstmt.setString(2, job.getCompany());
            pstmt.setString(3, job.getLocation());
            pstmt.setString(4, job.getDescription());
            pstmt.executeUpdate();
            System.out.println("✅ Job posted successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Insert Error: " + e.getMessage());
        }
    }

    // Get all job postings
    public static List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();
        String sql = "SELECT * FROM jobs";

        try (Connection conn = SQLiteConnector.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Job job = new Job(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("company"),
                    rs.getString("location"),
                    rs.getString("description")
                );
                jobs.add(job);
            }
        } catch (SQLException e) {
            System.out.println("❌ Fetch Error: " + e.getMessage());
        }

        return jobs;
    }

    // Delete job posting by ID
    public static void deleteJob(int id) {
        String sql = "DELETE FROM jobs WHERE id = ?";

        try (Connection conn = SQLiteConnector.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("🗑️ Job deleted with ID: " + id);
        } catch (SQLException e) {
            System.out.println("❌ Delete Error: " + e.getMessage());
        }
    }
}
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnector {
    private static final String DB_URL = "jdbc:sqlite:array_of_hope.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("✅ Connected to SQLite successfully.");
        } catch (SQLException e) {
            System.out.println("❌ SQLite Connection Failed: " + e.getMessage());
        }
        return conn;
    }
}
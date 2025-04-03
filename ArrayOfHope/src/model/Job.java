package model;

public class Job {
    private int id;
    private String title;
    private String company;
    private String location;
    private String description;

    // Constructor (used when adding a new job)
    public Job(String title, String company, String location, String description) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.description = description;
    }

    // Constructor (used when fetching from DB with an ID)
    public Job(int id, String title, String company, String location, String description) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.location = location;
        this.description = description;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    // For printing/debugging
    @Override
    public String toString() {
        return title + " at " + company + " (" + location + ")";
    }
}
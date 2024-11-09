package com.codecollabtool.model;

public class Project {
    private int id;
    private String name;
    private int createdBy;

    // Constructors, Getters, and Setters
    public Project() {}

    public Project(String name, int createdBy) {
        this.name = name;
        this.createdBy = createdBy;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getCreatedBy() { return createdBy; }
    public void setCreatedBy(int createdBy) { this.createdBy = createdBy; }
}

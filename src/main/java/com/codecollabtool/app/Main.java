package com.codecollabtool.app;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize service
            CollaborationService service = new CollaborationService();

            // Create a user
            User newUser = new User("john_doe", "john@example.com", "password123");
            service.createUser(newUser);

            // Create a project
            Project newProject = new Project("Real-Time Code Collaboration Tool", newUser.getId());
            service.createProject(newProject);

            System.out.println("User and Project created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


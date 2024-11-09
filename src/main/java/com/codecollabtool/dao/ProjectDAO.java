package com.codecollabtool.dao;

import com.codecollabtool.model.Project;
import com.codecollabtool.config.DBConnection;
import java.sql.*;

public class ProjectDAO {

    public void addProject(Project project) throws SQLException {
        String query = "INSERT INTO Projects (name, created_by) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, project.getName());
            stmt.setInt(2, project.getCreatedBy());
            stmt.executeUpdate();
        }
    }

    public Project getProjectById(int id) throws SQLException {
        Project project = null;
        String query = "SELECT * FROM Projects WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    project = new Project();
                    project.setId(rs.getInt("id"));
                    project.setName(rs.getString("name"));
                    project.setCreatedBy(rs.getInt("created_by"));
                }
            }
        }
        return project;
    }
}

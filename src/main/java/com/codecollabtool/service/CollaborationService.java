package com.codecollabtool.service;

import com.codecollabtool.dao.ProjectDAO;
import com.codecollabtool.dao.UserDAO;
import com.codecollabtool.model.Project;
import com.codecollabtool.model.User;
import java.sql.SQLException;
import java.util.List;

public class CollaborationService {
    private UserDAO userDAO;
    private ProjectDAO projectDAO;

    public CollaborationService() {
        this.userDAO = new UserDAO();
        this.projectDAO = new ProjectDAO();
    }

    public void createProjectWithUser(Project project, User user) throws SQLException {
        userDAO.addUser(user);
        projectDAO.addProject(project);
    }

    public List<User> listAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    public Project getProjectDetails(int projectId) throws SQLException {
        return projectDAO.getProjectById(projectId);
    }
}

package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Project;
import model.Collaborator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.ProjectDAO;

@WebServlet("/")
public class CodeCollaborationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProjectDAO projectDAO;

    public void init() {
        projectDAO = new ProjectDAO();
    }

    public CodeCollaborationServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/newProject": showNewProjectForm(request, response); break;
                case "/insertProject": insertProject(request, response); break;
                case "/deleteProject": deleteProject(request, response); break;
                case "/editProject": showEditProjectForm(request, response); break;
                case "/updateProject": updateProject(request, response); break;
                case "/listProjects": listProjects(request, response); break;
                case "/addCollaborator": addCollaborator(request, response); break;
                case "/removeCollaborator": removeCollaborator(request, response); break;
                case "/logout": logout(request, response); break;
                default: login(request, response); break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listProjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isLoggedIn(request)) {
            List<Project> projects = projectDAO.selectAllProjects();
            request.setAttribute("projectList", projects);
            RequestDispatcher dispatcher = request.getRequestDispatcher("project-list.jsp");
            dispatcher.forward(request, response);
        } else {
            login(request, response);
        }
    }

    private void showNewProjectForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("project-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertProject(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Project project = new Project(name, description);
        projectDAO.insertProject(project);
        response.sendRedirect("listProjects");
    }

    private void showEditProjectForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Project project = projectDAO.selectProject(id);
        request.setAttribute("project", project);
        RequestDispatcher dispatcher = request.getRequestDispatcher("project-form.jsp");
        dispatcher.forward(request, response);
    }

    private void updateProject(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Project project = new Project(id, name, description);
        projectDAO.updateProject(project);
        response.sendRedirect("listProjects");
    }

    private void deleteProject(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        projectDAO.deleteProject(id);
        response.sendRedirect("listProjects");
    }

    private void addCollaborator(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        String email = request.getParameter("email");
        projectDAO.addCollaborator(projectId, email);
        response.sendRedirect("listProjects");
    }

    private void removeCollaborator(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        String email = request.getParameter("email");
        projectDAO.removeCollaborator(projectId, email);
        response.sendRedirect("listProjects");
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    private boolean isLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute("status") != null && session.getAttribute("status").equals("active");
    }
}

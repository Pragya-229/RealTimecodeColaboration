package com.codecollaborators.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/getUserProfile")
public class UserProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("id");
        
        // Fetch user data using DAO (mock example)
        request.setAttribute("userData", new Object()); // Replace with actual data
        request.getRequestDispatcher("user-profile.jsp").forward(request, response);
    }
}

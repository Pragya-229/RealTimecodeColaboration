package com.codecollaborators.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/registerUser")
public class UserRegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        // Logic to save data using DAO
        request.setAttribute("message", "User registered successfully!");
        request.getRequestDispatcher("user-form.jsp").forward(request, response);
    }
}

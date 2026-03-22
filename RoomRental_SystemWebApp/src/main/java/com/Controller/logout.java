package com.Controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")  // <-- Mapping for user logout
public class logout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get current session if exists
        HttpSession session = request.getSession(false);

        // Invalidate session
        if (session != null) {
            session.invalidate();
        }

        // Redirect to user login page
        response.sendRedirect("login.jsp");
    }
}

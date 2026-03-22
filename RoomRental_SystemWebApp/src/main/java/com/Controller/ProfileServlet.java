package com.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.model.Users;


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); // get session if exists
        if(session != null) {
            Users user = (Users) session.getAttribute("user");

            if(user != null) {
                // Pass user to JSP
                request.setAttribute("user", user);
                request.getRequestDispatcher("profile.jsp").forward(request, response);
                return;
            }
        }

        // If no user logged in, redirect to login
        response.sendRedirect("login.jsp");
    }
}
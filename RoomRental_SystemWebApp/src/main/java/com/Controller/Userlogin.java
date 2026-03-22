package com.Controller;

import java.io.IOException;

import com.Dao.UserDao;
import com.model.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Userlogin")
public class Userlogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDao ud = new UserDao();
        Users user = ud.loginUser(email, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("role", "user");   // ✅ correct role
            session.setAttribute("user", user);     // ✅ full user object

            System.out.println("User ID stored in session: " + user.getUserid());

            // ✅ redirect to home page
            response.sendRedirect("home.jsp");
        } else {
            request.setAttribute("error", "Invalid Email or Password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}

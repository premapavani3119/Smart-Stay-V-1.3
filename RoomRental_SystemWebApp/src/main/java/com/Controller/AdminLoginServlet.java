package com.Controller;

import java.io.IOException;

import com.Dao.AdminDao;
import com.model.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String aname = request.getParameter("aname");
        String apsw = request.getParameter("apsw");

        // create admin model object and set data
        admin a = new admin();
        a.setAname(aname);
        a.setApsw(apsw);

        AdminDao ad = new AdminDao();
        boolean status = ad.loginAdmin(aname, apsw);

        if (status) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", aname);

            // ✅ set role so JSP can check it
            session.setAttribute("role", "admin");

            response.sendRedirect("admindashboard.jsp");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("adminlogin.jsp");
            rd.forward(request, response);
        }
    }
}




package com.Controller;

import java.io.IOException;

import com.Dao.BookingDao;
import com.model.Booking;
import com.model.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SendRequestServlet")
public class SendRequestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Users user = (Users) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {

            int userId = user.getUserid();
            int roomId = Integer.parseInt(request.getParameter("roomId"));
            String message = request.getParameter("message");

            // Create booking object
            Booking b = new Booking();

            b.setUserid(userId);
            b.setRoomid(roomId);
            b.setStatus("Pending");

            // Save request
            BookingDao dao = new BookingDao();

            boolean f = dao.addRequest(b);

            if (f) {
                session.setAttribute("successMsg", "Request Sent Successfully");
            } else {
                session.setAttribute("errorMsg", "Something went wrong");
            }

            response.sendRedirect("MyRequestsServlet");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
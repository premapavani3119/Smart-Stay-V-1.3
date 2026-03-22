package com.Controller;

import java.io.IOException;
import java.util.List;

import com.Dao.AdminDao;
import com.model.Booking;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminViewRoomRequests")
public class AdminViewRoomRequests extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AdminDao ad = new AdminDao();

        // get data from dao
        List<Booking> bookings = ad.getAllBookingRequests();

        // set in request scope
        request.setAttribute("reqList", bookings);

        // forward to JSP
        request.getRequestDispatcher("viewrequest.jsp").forward(request, response);
    }
}

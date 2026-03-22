package com.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.Dao.BookingDao;
import com.utility.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateRequestStatusServlet")
public class UpdateRequestStatusServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int bookingId = Integer.parseInt(request.getParameter("bookingid"));
        String status = request.getParameter("status");

        BookingDao dao = new BookingDao();

        boolean f = dao.updateRequestStatus(bookingId, status);

        if(f){
            response.sendRedirect("ViewAllRequestsServlet");
        }else{
            response.getWriter().println("Status update failed");
        }

    }


public boolean updateRequestStatus(int bookingId, String status) {

    boolean f = false;

    try {

        Connection con = DBConnection.getConnection();

        String sql = "update booking set status=? where bookingid=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, status);
        ps.setInt(2, bookingId);

        int i = ps.executeUpdate();

        if(i==1){
            f = true;
        }

    } catch(Exception e){
        e.printStackTrace();
    }

    return f;
}
}


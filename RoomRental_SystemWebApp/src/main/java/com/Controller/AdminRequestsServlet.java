package com.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Booking;
import com.utility.DBConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminRequestsServlet")
public class AdminRequestsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Booking> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM booking";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Booking b = new Booking();

                b.setBookingid(rs.getInt("bookingid"));
                b.setUserid(rs.getInt("userid"));
                b.setRoomid(rs.getInt("roomid"));
                b.setRequest_date(rs.getDate("request_date"));
                b.setStatus(rs.getString("status"));

                list.add(b);
            }

            request.setAttribute("requests", list);

            RequestDispatcher rd = request.getRequestDispatcher("admin_requests.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



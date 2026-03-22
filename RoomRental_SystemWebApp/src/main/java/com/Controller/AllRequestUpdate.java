package com.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.utility.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AllRequestUpdate")
public class AllRequestUpdate extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

try {

int bookingId = Integer.parseInt(request.getParameter("bookingId"));
String status = request.getParameter("status");

Connection con = DBConnection.getConnection();

String sql = "UPDATE booking SET status=? WHERE booking_id=?";
PreparedStatement ps = con.prepareStatement(sql);

ps.setString(1, status);
ps.setInt(2, bookingId);

ps.executeUpdate();

response.sendRedirect("AdminViewRoomRequests");

}catch(Exception e){
e.printStackTrace();
}

}
}
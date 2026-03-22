package com.Controller;
import jakarta.servlet.http.HttpSession;
import com.model.Users;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import com.utility.DBConnection;
import com.model.Users;

@WebServlet("/RequestRoomServlet")
public class RequestRoomServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

int roomId1 = Integer.parseInt(request.getParameter("roomId"));

HttpSession session = request.getSession();
Users u = (Users)session.getAttribute("user");

int userId = u.getUserid();
System.out.println("UserID from session: " + userId);

try {

Connection con = DBConnection.getConnection();

String sql="insert into booking(userid,roomid,request_date,status) values(?,?,?,?)";

PreparedStatement ps = con.prepareStatement(sql);

ps.setInt(1,userId);
ps.setInt(2,roomId1);
ps.setString(3, LocalDate.now().toString());
ps.setString(4,"Pending");

ps.executeUpdate();

response.sendRedirect("RoomDetailsServlet?roomId=" + roomId1 + "&msg=requestsent");

}catch(Exception e){
e.printStackTrace();
}

}
}
package com.Controller;

import java.io.IOException;
import java.util.List;

import com.Dao.BookingDao;
import com.model.Booking;
import com.model.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MyRequestsServlet")
public class MyRequestsServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

HttpSession session = request.getSession();

Users u = (Users) session.getAttribute("user");
 
if(u != null){

int userId = u.getUserid();

BookingDao dao = new BookingDao();

List<Booking> list = dao.getUserRequests(userId);

request.setAttribute("requests", list);

request.getRequestDispatcher("usermyrequest.jsp").forward(request, response);

}
else{
response.sendRedirect("login.jsp");
}

}
}
	
		

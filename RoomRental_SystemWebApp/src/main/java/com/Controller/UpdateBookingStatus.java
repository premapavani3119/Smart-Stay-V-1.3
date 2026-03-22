package com.Controller;

import java.io.IOException;

import com.Dao.AdminDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateBookingStatus")
public class UpdateBookingStatus extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bookingid = Integer.parseInt(request.getParameter("bookingid"));

		String status = request.getParameter("status");

		AdminDao dao = new AdminDao();

		dao.updateBookingStatus(bookingid,status);

		response.sendRedirect("AdminViewRoomRequests");
	}
	
	
	

}

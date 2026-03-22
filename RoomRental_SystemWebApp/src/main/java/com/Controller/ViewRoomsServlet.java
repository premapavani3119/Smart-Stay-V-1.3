package com.Controller;

import java.io.IOException;
import java.util.List;

import com.Dao.RoomDao;
import com.model.Rooms;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ViewRoomsServlet")
public class ViewRoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoomDao rd = new RoomDao();

        List<Rooms> rooms = rd.getAllRooms();

        request.setAttribute("roomList", rooms);

        RequestDispatcher rd1 = request.getRequestDispatcher("ViewRooms.jsp");
        rd1.forward(request, response);
    }
}

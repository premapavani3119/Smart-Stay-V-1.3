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

@WebServlet("/ViewRoomDeatailsWithImgs")
public class ViewRoomDeatailsWithImgs extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Get roomId from request
            int roomId = Integer.parseInt(request.getParameter("roomId"));

            RoomDao dao = new RoomDao();

            // Fetch room details
            Rooms room = dao.getRoomById(roomId);

            // Fetch room images
            List<String> images = dao.getRoomImagesByRoomId(roomId);

            // Set attributes for JSP
            request.setAttribute("room", room);
            request.setAttribute("images", images);

            // Forward to JSP
            RequestDispatcher rd = request.getRequestDispatcher("roomdetails.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Unable to load room details.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}



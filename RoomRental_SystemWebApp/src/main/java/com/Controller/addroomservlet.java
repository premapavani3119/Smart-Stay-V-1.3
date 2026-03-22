package com.Controller;

import java.io.File;
import java.io.IOException;

import com.Dao.RoomDao;
import com.model.RoomImages;
import com.model.Rooms;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/addroomservlet")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class addroomservlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            Object admin = session.getAttribute("admin");

            if (user == null && admin == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            // 1️⃣ Room Fields
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));
            String sharing_type = request.getParameter("sharing_type");
            int availableRooms = Integer.parseInt(request.getParameter("availablerooms"));
            String status = request.getParameter("status");
            int locationId = Integer.parseInt(request.getParameter("locationid"));


            // 2️⃣ Upload folder
            String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdir();

            // 3️⃣ Get images
            Part img1 = request.getPart("img1");
            Part img2 = request.getPart("img2");
            Part img3 = request.getPart("img3");

            String imgName1 = (img1 != null) ? img1.getSubmittedFileName() : null;
            String imgName2 = (img2 != null) ? img2.getSubmittedFileName() : null;
            String imgName3 = (img3 != null) ? img3.getSubmittedFileName() : null;

            if (img1 != null && img1.getSize() > 0) img1.write(uploadPath + File.separator + imgName1);
            if (img2 != null && img2.getSize() > 0) img2.write(uploadPath + File.separator + imgName2);
            if (img3 != null && img3.getSize() > 0) img3.write(uploadPath + File.separator + imgName3);

            // 4️⃣ Create Room Object
            Rooms room = new Rooms();
            room.setTitle(title);
            room.setDescription(description);
            room.setPrice(price);
            room.setLocationId(locationId);
            room.setSharing_type(sharing_type); // <-- FIXED
            room.setAvailablerooms(availableRooms);
            room.setStatus(status);

            // 5️⃣ Save Room
            RoomDao dao = new RoomDao();
            int roomId = dao.addRoom(room);

            if (roomId > 0) {
                // 6️⃣ Save Images
                RoomImages ri = new RoomImages();
                ri.setRoomId(roomId);
                ri.setImgPath1(imgName1 != null ? "uploads/" + imgName1 : null);
                ri.setImgPath2(imgName2 != null ? "uploads/" + imgName2 : null);
                ri.setImgPath3(imgName3 != null ? "uploads/" + imgName3 : null);

                dao.addRoomImages(ri);

                session.setAttribute("successMsg", "Room Added Successfully");
                if (admin != null) {
                    response.sendRedirect("admindashboard.jsp");
                } else {
                    response.sendRedirect("userdashboard.jsp");
                }
            } else {
                request.setAttribute("error", "Room Not Added");
                request.getRequestDispatcher("addroom.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
            request.getRequestDispatcher("addroom.jsp").forward(request, response);
        }
    }
}

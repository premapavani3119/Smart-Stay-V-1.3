package com.Controller;

import java.io.IOException;

import com.Dao.LocationDao;
import com.model.Location;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/addLocationServlet")
public class addLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public addLocationServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		String state = request.getParameter("state");
		String pincode = request.getParameter("pincode");

		Location l = new Location();
		l.setCity(city);
		l.setArea(area);
		l.setState(state);
		l.setPincode(pincode);

		LocationDao ld = new LocationDao();
		boolean status = ld.addLocation(l);

		if(status){
		    response.sendRedirect("admindashboard.jsp");
		} else {
		    response.sendRedirect("addLocation.jsp?error=1");
		}


		}
		}
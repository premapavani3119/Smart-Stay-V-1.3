package com.Controller;

import java.io.IOException;

import com.Dao.UserDao;
import com.model.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	boolean status = false;
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String mail = request.getParameter("email");
		String password = request.getParameter("password");
		String Gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String occupation = request.getParameter("occupation");


		Users u = new Users();
		u.setFullname(name);
		u.setPhone(phone);
		u.setEmail(mail);
		u.setPassword(password);
		u.setGender(Gender);
		u.setAge(age);
		u.setOccupation(occupation);
		

		UserDao ud = new UserDao();
		status = ud.RegisterUser(u);
		
		
		if(status==(true)) {
			RequestDispatcher rd =request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd =request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
		}

	}

}

package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Users;
import com.utility.DBConnection;

public class UserDao implements UserDaoInterface  {
	Connection con =null;
	private Users user;
	
	@Override
	public boolean RegisterUser(Users u) {
		boolean status = false;
		try {
		DBConnection db = new DBConnection();
		con = db.getConnection();
		
		PreparedStatement ps = con.prepareStatement("insert into users(fullname,email,password,phone,gender,age,occupation) values(?,?,?,?,?,?,?)");
		ps.setString(1,u.getFullname());
		ps.setString(2,u.getEmail());
		ps.setString(3,u.getPassword());
		ps.setString(4,u.getPhone());
		
		ps.setString(5,u.getGender());
		ps.setInt(6,u.getAge());
		ps.setString(7,u.getOccupation());
		int n = ps.executeUpdate();
		
		
		ps.close();
		con.close();
		
		if(n>0) {
			status = true;
		}
		
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		
		return status;
	}
	public Users loginUser(String email, String password) {

	    Users user = null;

	    try {

	        Connection con = DBConnection.getConnection();

	        String sql = "select * from users where email=? and password=?";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, email);
	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	        	System.out.println("user id from bd: " + rs.getInt("userid"));


	            user = new Users();

	            user.setUserid(rs.getInt("userid"));
	            user.setFullname(rs.getString("fullname"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));
	            user.setPhone(rs.getString("phone"));
	            user.setGender(rs.getString("gender"));
	            user.setAge(rs.getInt("age"));
	            user.setOccupation(rs.getString("occupation"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return user;
	}
	
	    public Users getUserById(int id) {
	    	user = new Users();
	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id=?")) {
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()) {
	                user = new Users();
	                user.setUserid(rs.getInt("userid"));
	                user.setFullname(rs.getString("fullname"));
	                user.setEmail(rs.getString("email"));
	                user.setPassword(rs.getString("password"));
		            user.setPhone(rs.getString("phone"));
		            user.setGender(rs.getString("gender"));
		            user.setAge(rs.getInt("age"));
		            user.setOccupation(rs.getString("occupation"));
		        }

	            
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        return user;
	    }
		@Override
		public boolean loginUser(Users u) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}

	

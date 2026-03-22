package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Booking;
import com.utility.DBConnection;


public class RequestDao {

	

	    // 🔹 Save request
	    public boolean addRequest(Booking b) {

	        boolean f = false;

	        try {

	            Connection con = DBConnection.getConnection();

	            String sql = "INSERT INTO booking(userid, roomid,status) VALUES(?,?,?,?)";

	            PreparedStatement ps = con.prepareStatement(sql);

	            ps.setInt(1, b.getUserid());
	            ps.setInt(2, b.getRoomid());
	            ps.setString(4, "Pending");

	            int i = ps.executeUpdate();

	            if (i == 1) {
	                f = true;
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return f;
	    }

	    // 🔹 Get requests of a user
	    public List<Booking> getUserRequests(int userId) {

	        List<Booking> list = new ArrayList<>();

	        try {

	            Connection con = DBConnection.getConnection();

	            String sql = "SELECT * FROM booking WHERE user_id=?";

	            PreparedStatement ps = con.prepareStatement(sql);

	            ps.setInt(1, userId);

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {

	                Booking b = new Booking();

	                b.setBookingid(rs.getInt("bookingid"));
	                b.setUserid(rs.getInt("userid"));
	                b.setRoomid(rs.getInt("roomid"));
	               
	                b.setStatus(rs.getString("status"));

	                list.add(b);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
	}

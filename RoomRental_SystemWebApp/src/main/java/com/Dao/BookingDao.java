package com.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Booking;
import com.utility.DBConnection;


	public class BookingDao {
//get rqquest from the user
	public List<Booking> getUserRequests(int userId){

	List<Booking> list = new ArrayList<>();

	try{

	Connection con = DBConnection.getConnection();

	String sql="select * from booking where userid=?";

	PreparedStatement ps = con.prepareStatement(sql);

	ps.setInt(1,userId);

	ResultSet rs = ps.executeQuery();

	while(rs.next()){

	Booking b = new Booking();

	b.setBookingid(rs.getInt("bookingid"));
	 b.setUserid(rs.getInt("userid"));
	b.setRoomid(rs.getInt("roomid"));
	b.setRequest_date(rs.getString("request_date"));
	b.setStatus(rs.getString("status"));

	list.add(b);

	}

	}catch(Exception e){
	e.printStackTrace();
	}

	return list;
	}
//insert request
	public boolean addRequest(Booking b) {

	    boolean f = false;

	    try {

	        Connection con = DBConnection.getConnection();

	        String sql = "INSERT INTO booking(userid, roomid,request_date,status) VALUES(?,?,?,?)";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setInt(1, b.getUserid());
	        ps.setInt(2, b.getRoomid());
	        ps.setString(3,b.getRequest_date());
	        ps.setString(4, b.getStatus());

	        int i = ps.executeUpdate();

	        if (i == 1) {
	            f = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return f;
	}
	
	
	public boolean updateRequestStatus(int bookingId, String status) {

	    boolean f = false;

	    try {

	        Connection con = DBConnection.getConnection();

	        String sql = "UPDATE booking SET status=? WHERE bookingid=?";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, status);
	        ps.setInt(2, bookingId);

	        int i = ps.executeUpdate();

	        if (i == 1) {
	            f = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return f;
	}
	}



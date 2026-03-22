package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Booking;
import com.utility.DBConnection;

public class AdminDao {
	
	public boolean loginAdmin(String aname,String apsw){

		boolean status=false;

		try{

		Connection con = DBConnection.getConnection();

		String sql="select * from admin where aname=? and apsw=?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1,aname);
		ps.setString(2,apsw);

		ResultSet rs = ps.executeQuery();

		if(rs.next()){
		status=true;
		}

		}catch(Exception e){
		e.printStackTrace();
		}

		return status;

		}
	
	public List<Booking> getAllBookingRequests(){

	List<Booking> list = new ArrayList<>();

	try{

	Connection con = DBConnection.getConnection();

	String sql="select * from booking";

	PreparedStatement ps = con.prepareStatement(sql);


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
	
	public List<Booking> getAllBookingRequests1() {
	    List<Booking> list = new ArrayList<>();
	    try {
	    	Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement("SELECT * FROM bookings");
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	            Booking b = new Booking();
	            b.setBookingid(rs.getInt("bookingid"));
	            b.setUserid(rs.getInt("userid"));
	            b.setRoomid(rs.getInt("roomid"));
	            b.setRequest_date(rs.getDate("request_date"));
	            b.setStatus(rs.getString("status"));
	            list.add(b);
	        }
	         
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}

	

	public void updateBookingStatus(int bookingid,String status){

		try{

			Connection con = DBConnection.getConnection();

			String sql = "update booking set status=? where bookingid=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1,status);
			ps.setInt(2,bookingid);

			ps.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

package com.model;

import java.sql.Date;

public class Booking {
	private int bookingid;
	private int userid;
	private int roomid;
	private  String request_date;
	private String status;
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roonid) {
		this.roomid = roonid;
	}
	public String getRequest_date() {
		return request_date;
	}
	public void setRequest_date(String request_date) {
		this.request_date = request_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", userid=" + userid + ", roomid=" + roomid + ", request_date="
				+ request_date + ", status=" + status + "]";
	}
	public void setRequest_date(Date date) {
		// TODO Auto-generated method stub
		
	}

	
}
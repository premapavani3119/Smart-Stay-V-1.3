package com.model;



	import java.time.LocalDateTime;

	public class Request {

	    private int requestId;
	    private int roomId;     // FK
	    private int senderId;   // FK (UserId)
	    private String status;  // Pending / Accepted / Rejected
		public int getRequestId() {
			return requestId;
		}
		public void setRequestId(int requestId) {
			this.requestId = requestId;
		}
		public int getRoomId() {
			return roomId;
		}
		public void setRoomId(int roomId) {
			this.roomId = roomId;
		}
		public int getSenderId() {
			return senderId;
		}
		public void setSenderId(int senderId) {
			this.senderId = senderId;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		

	
}

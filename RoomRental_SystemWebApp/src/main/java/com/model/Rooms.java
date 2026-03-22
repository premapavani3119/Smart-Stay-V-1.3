package com.model;

	public class Rooms{

	    private int roomId;
	    private String title;
	    private String description;
	    private double price;
	    private int locationId; 
	    private String sharing_type;
	    private int availablerooms;
	    private String status;
	    
		public String  getSharing_type() {
			return sharing_type;
		}

		public void setSharing_type(String sharing_type) {
			this.sharing_type = sharing_type;
		}

		public int getAvailablerooms() {
			return availablerooms;
		}

		public void setAvailablerooms(int availablerooms) {
			this.availablerooms = availablerooms;
		}

		public int getRoomId() {
			return roomId;
		}
		
		

		
		

		public void setRoomId(int roomId) {
			this.roomId = roomId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getLocationId() {
			return locationId;
		}
		public void setLocationId(int locationId) {
			this.locationId = locationId;
		}
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "Rooms [roomId=" + roomId + ", title=" + title + ", description=" + description + ", price=" + price
					+ ", locationId=" + locationId + ", sharing=" + sharing_type + ",+ avlb=" + availablerooms
					+ ", status=" + status + "]";
		}

		
}

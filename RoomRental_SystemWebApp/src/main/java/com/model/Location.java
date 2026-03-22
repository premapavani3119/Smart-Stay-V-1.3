package com.model;



	public class Location {

	    private int locationId;
	    private String city;
	    private String area;
	    private String state;
	    private String pincode;
	    
		public int getLocationId() {
			return locationId;
		}
		@Override
		public String toString() {
			return "Location [locationId=" + locationId + ", city=" + city + ", area=" + area + ", state=" + state
					+ ", pincode=" + pincode + "]";
		}
		public void setLocationId(int locationId) {
			this.locationId = locationId;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getArea() {
			return area;
		}
		public void setArea(String area) {
			this.area = area;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}

	
}

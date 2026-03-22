package com.model;

public class RoomImages {
	 private int imgId;
	    private int roomId;   // FK
	    private String imgPath1;
	    private String imgPath2;
	    private String imgPath3;
		public int getImgId() {
			return imgId;
		}
		public void setImgId(int imgId) {
			this.imgId = imgId;
		}
		public int getRoomId() {
			return roomId;
		}
		public void setRoomId(int roomId) {
			this.roomId = roomId;
		}
		public String getImgPath1() {
			return imgPath1;
		}
		public void setImgPath1(String imgPath1) {
			this.imgPath1 = imgPath1;
		}
		public String getImgPath2() {
			return imgPath2;
		}
		public void setImgPath2(String imgPath2) {
			this.imgPath2 = imgPath2;
		}
		public String getImgPath3() {
			return imgPath3;
		}
		public void setImgPath3(String imgPath3) {
			this.imgPath3 = imgPath3;
		}
		@Override
		public String toString() {
			return "RoomImages [imgId=" + imgId + ", roomId=" + roomId + ", imgPath1=" + imgPath1 + ", imgPath2="
					+ imgPath2 + ", imgPath3=" + imgPath3 + "]";
		}
	    
	    

}

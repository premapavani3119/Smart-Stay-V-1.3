package com.model;

public class Users {
	

	private int userid;
	private String fullname;
	private String Email;
	private String password;
	private String phone;
	private String gender;
	private int age;
	private String occupation;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String mail) {
		this.Email = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	@Override
	public String toString() {
		return "Users [user_id=" + userid + ", fullname=" + fullname + ", mail=" + Email + ", password=" + password
				+ ", phone=" + phone + ", gender=" + gender + ", age=" + age + ", occupation=" + occupation + "]";
	}

}

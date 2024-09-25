package com.food.model;

public class User {
	private int userID;
	private String userName;
	private String password;
	private String email;
	private String address;
	private String role;
	
	
	public User() {
		
	}


	public User( String userName, String password, String email, String address, String role) {
		super();
//		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	public String toString() {
		return userID+" "+userName+" "+password+" "+email+" "+address+" "+role;
	}

}

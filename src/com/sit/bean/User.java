package com.sit.bean;

public class User {
	
	private String user_name;
	private String password;
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User_List [user_name=" + user_name + ", password=" + password + "]";
	}

	
}

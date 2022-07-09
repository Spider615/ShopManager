package com.etc.entity;

public class Manager {
	private int userId;
	private String userName;
	private String userPwd;
	
	public Manager() {
		super();
	}
	public Manager(int userId, String userName, String userPwd) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
	}
	public Manager(String userName, String userPwd) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
	}
	@Override
	public String toString() {
		return "Manager [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
}

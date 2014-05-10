package com.hhkj.demo.entity;

public class PersonEntity implements java.io.Serializable {
	private static final long serialVersionUID = -1138245964662330288L;

	private Integer userId;
	private String userName;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "PersonEntity [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + "]";
	}
}

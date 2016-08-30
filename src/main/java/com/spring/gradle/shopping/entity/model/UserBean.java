package com.spring.gradle.shopping.entity.model;

import java.io.Serializable;
import java.util.Date;

public class UserBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -582417917393096053L;
	private int userId = 0;
	private String emailId = "";
	private String password = "";
	private Date createdDate = new Date();

	// private Timestamp createdDate=new Date();
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}

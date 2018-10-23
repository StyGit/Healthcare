package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usertab")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "uId")
	private Integer userId;
	@Column(name = "uName")
	private String userName;
	@Column(name = "uMail")
	private String userEmail;
	@Column(name = "uContact")
	private String userContact;
	@Column(name = "uPwd")
	private String userPwd;
	@Column(name = "uAddr")
	private String userAddr;

	public User(Integer userId, String userName, String userEmail, String userContact, String userPwd,
			String userAddr) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.userPwd = userPwd;
		this.userAddr = userAddr;
	}

	public User(Integer userId) {
		super();
		this.userId = userId;
	}

	public User() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserContact() {
		return userContact;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userContact="
				+ userContact + ", userPwd=" + userPwd + ", userAddr=" + userAddr + "]";
	}
}

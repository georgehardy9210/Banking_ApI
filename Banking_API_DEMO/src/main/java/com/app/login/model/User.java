package com.app.login.model;

public class User {

	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int userId;
	private String role;
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private Account account;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", userId=" + userId + ", role=" + role + ", account=" + account
				+ "]";
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}

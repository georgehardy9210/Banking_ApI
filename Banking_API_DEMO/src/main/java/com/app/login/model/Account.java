package com.app.login.model;

public class Account {

	
	private int accountId;
	private double balance;
	private AccountStatus status;
	private AccountType type;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	public AccountType getType() {
		return type;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", status=" + status.getStatus() + ", type=" + type
				+ "]";
	}

	public void setType(AccountType type) {
		this.type = type;
	}
	
}

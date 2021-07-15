package com.bank.models;

public class Account {
	
	//private String accountnum;
	private int accountId;
	private int userId;
	private int balance;
	
	public Account() {
		
	}
	
	public Account(int accountId, int userId, int balance) {
		this.accountId = accountId;
		this.userId = userId;
		this.balance=balance;
	}
	
	public Account(int userId, int balance) {
		this.userId = userId;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", userId=" + userId + ", balance=" + balance + "]";
	}
	
}

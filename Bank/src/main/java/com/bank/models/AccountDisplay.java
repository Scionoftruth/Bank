package com.bank.models;

public class AccountDisplay{
	
	private String username;
	private int accountId;
	private int customerId;
	private int balance;
	
	public AccountDisplay() {
		super();
	}

	public AccountDisplay(String username, int accountId, int customerId, int balance) {
		super();
		this.username = username;
		this.accountId = accountId;
		this.customerId = customerId;
		this.balance = balance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
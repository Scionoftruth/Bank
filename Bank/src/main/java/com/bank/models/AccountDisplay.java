package com.bank.models;

public class AccountDisplay{
	
	private String username;
	private int accountId;
	private int customerId;
	private int balance;
	private String approved;
	
	public AccountDisplay() {
		super();
	}

	public AccountDisplay(String username, int accountId, int customerId,  int balance, String approved) {
		super();
		this.username = username;
		this.accountId = accountId;
		this.customerId = customerId;
		this.approved = approved;
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
	
	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved=approved;
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Username: " + username + "\n" + "AccountId: " + accountId + "\n" + "CustomerId: " + customerId
				+ "\n" + "Balance: $" + balance + "\n";
	}


	
}

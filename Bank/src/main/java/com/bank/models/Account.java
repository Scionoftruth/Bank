package com.bank.models;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	//private String accountnum;
	private int accountId;
	private int userId;
	private int balance;
	private String approved;
	private List<Transaction> transactions;
	
	public Account() {
		transactions = new ArrayList<Transaction>();
	}
	
	public Account(int accountId, int userId, int balance, String approved) {
		this.accountId = accountId;
		this.userId = userId;
		this.balance=balance;
		this.approved=approved;
		this.transactions = new ArrayList<Transaction>();
	}
	
	public Account(int userId, int balance, String approved) {
		this.userId = userId;
		this.balance = balance;
		this.approved=approved;
		this.transactions = new ArrayList<Transaction>();
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

	public String getApproved() {
		return approved;
	}
	
	public void setApproved(String approved) {
		this.approved=approved;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [AccountID=" + accountId + ", userId=" + userId + ", $" + balance + ", Transactions=" + transactions + "]";
	}

	
	
}

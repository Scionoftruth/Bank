package com.bank.models;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	//private String accountnum;
	private int accountId;
	private int userId;
	private double balance;
	private List<Transaction> transactions;
	
	public Account() {
		transactions = new ArrayList<Transaction>();
	}
	
	public Account(int accountId, int userId, double balance) {
		this.accountId = accountId;
		this.userId = userId;
		this.balance=balance;
		this.transactions = new ArrayList<Transaction>();
	}
	
	public Account(int userId, double balance) {
		this.userId = userId;
		this.balance = balance;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", userId=" + userId + ", balance=" + balance + "]";
	}
	
}

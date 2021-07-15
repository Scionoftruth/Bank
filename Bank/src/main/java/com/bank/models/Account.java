package com.bank.models;

public class Account {
	
	//private String accountnum;
	private String username;
	private int balance;
	
	public Account() {
		
	}
	
	public Account(/*String accountnum,*/ String username, int balance) {
		//this.accountnum=accountnum;
		this.username = username;
		this.balance=balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getUser() {
		return username;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", balance= $" + balance + "]";
	}

}

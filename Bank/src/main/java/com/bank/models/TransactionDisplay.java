package com.bank.models;

public class TransactionDisplay {
	
	//private String usernameS;
	//private String usernameR;
	private int transactionId;
	private int senderId;
	private int recieverId;
	private int amount;
	
	public TransactionDisplay() {
		super();
	}

	public TransactionDisplay(/*String usernameS, String usernameR,*/ int transactionId, int senderId, int recieverId, int amount) {
		super();
		//this.usernameS = usernameS;
		//this.usernameR = usernameR;
		this.transactionId = transactionId;
		this.senderId = senderId;
		this.recieverId = recieverId;
		this.amount = amount;
	}
	/*
	public String getUsernameS() {
		return usernameS;
	}

	public void setUsernameS(String usernameS) {
		this.usernameS = usernameS;
	}
	
	public String getUsernameR() {
		return usernameR;
	}
	
	public void setUsernameR(String usernameR) {
		this.usernameR = usernameR;
	}*/

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getRecieverId() {
		return recieverId;
	}

	public void setRecieverId(int recieverId) {
		this.recieverId = recieverId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TransactionId: " + transactionId + "\n" + "SenderId: "
				+ senderId + "\n" + "RecieverId: " + recieverId + "\n" + "Amount: $" + amount;
	}
	

}

package com.bank.models;

public class Transaction {
	
	private int transactionId;
	private int senderId;
	private int recieverId;
	private int amount;
	
	public Transaction() {
		
	}
	
	public Transaction(int transactionId, int senderId, int recieverId, int amount) {
		this.transactionId = transactionId;
		this.senderId = senderId;
		this.recieverId = recieverId;
		this.amount = amount;
	}
	
	public Transaction(int senderId, int recieverId, int amount) {
		this.senderId = senderId;
		this.recieverId = recieverId;
		this.amount = amount;
	}

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
		return "Transaction [transactionId=" + transactionId + ", senderId=" + senderId + ", recieverId=" + recieverId
				+ ", amount=" + amount + "]";
	}
	

}

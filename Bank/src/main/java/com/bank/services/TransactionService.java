package com.bank.services;

import com.bank.dao.TransactionDao;
import com.bank.logging.Logging;
import com.bank.models.Transaction;

public class TransactionService {
	
	private TransactionDao tDao;
	
	public TransactionService(TransactionDao t) {
		this.tDao = t;
	}
	
	
	public void addTransaction(int senderId, int recieverId, double amount) {
		Transaction t = new Transaction(senderId, recieverId, amount);
		tDao.createTransaction(t);
		Logging.logger.info("Transaction was Created");
	}
	
	public void acceptTransaction(Transaction t) {
		tDao.acceptTransaction(t);
		Logging.logger.info("Transaction: "+t.getTransactionId()+" was Accepted");
	}
	
	public void rejetTransaction(Transaction t) {
		tDao.rejectTransaction(t);
		Logging.logger.info("Transaction: "+t.getTransactionId()+" was Rejected");
	}

}

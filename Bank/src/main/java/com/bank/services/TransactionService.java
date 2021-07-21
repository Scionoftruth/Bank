package com.bank.services;

import java.util.List;

import com.bank.dao.TransactionDao;
import com.bank.models.TransactionDisplay;
import com.bank.logging.Logging;
import com.bank.models.Account;
import com.bank.models.Transaction;

public class TransactionService {
	
	private TransactionDao tDao;
	
	public TransactionService(TransactionDao t) {
		this.tDao = t;
	}
	
	
	public void addTransaction(int senderId, int recieverId, int amount) {
		Transaction t = new Transaction(senderId, recieverId, amount);
		tDao.createTransaction(t);
		Logging.logger.info("Transaction was Created");
	}
	
	public void acceptTransaction(TransactionDisplay t) {
		tDao.acceptTransaction(t);
		Logging.logger.info("Transaction: "+t.getTransactionId()+" was Accepted");
	}
	
	public void rejectTransaction(TransactionDisplay t) {
		tDao.rejectTransaction(t);
		Logging.logger.info("Transaction: "+t.getTransactionId()+" was Rejected");
	}
	
	public List<TransactionDisplay> getAllTransactions(){
		return tDao.getAllTransactions();
	}
	
	public Account loadAccontTransactions(Account a) {
		return tDao.getAccountTransactions(a);
	}

}

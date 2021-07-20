package com.bank.dao;

import java.util.List;

import com.bank.models.Account;
import com.bank.models.Transaction;
import com.bank.models.TransactionDisplay;
import com.bank.models.User;

public interface TransactionDao {
	
	public void createTransaction(Transaction t);
	
	public List<TransactionDisplay> getAllTransactions();
	
	public Account getAccountTransactions(Account u);
	
	public void acceptTransaction(TransactionDisplay t);
	
	public void rejectTransaction(TransactionDisplay t);

}

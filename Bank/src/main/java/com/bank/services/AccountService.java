package com.bank.services;

import java.util.List;

import com.bank.dao.AccountDao;
import com.bank.logging.Logging;
import com.bank.models.Account;
import com.bank.models.AccountDisplay;
import com.bank.models.User;

public class AccountService {
	
	private AccountDao aDao;
	
	public AccountService(AccountDao a) {
		this.aDao = a;
	}
	
	public void addAccount(int customerId, int balance, String approved) {
		Account a = new Account(customerId, balance, approved);
		aDao.createAccount(a);
		Logging.logger.info("Account Was Created");
	}
	
	public void deleteAccount(int accountId) {
		aDao.deleteAccount(accountId);
		Logging.logger.info("Account Was Denied");
	}
	
	public List<AccountDisplay> getAllAccounts(){
		return aDao.getAllAccounts();
	}
	
	public User loadUserAccounts(User u) {
		return aDao.getUsersAccounts(u);
	}
	
	public void updateAccount(int userId, int balance, String approved) {
		aDao.updateAccount(userId, balance, approved);
		Logging.logger.info("Account Was Updated");
	}
	
	public void updateAccountApproval(int userId, int balance, String approved) {
		aDao.updateAccountApproval(userId, balance, approved);
		Logging.logger.info("Account Was Updated");
	}

}

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
	
	public void addAccount(int customerId, int balance) {
		Account a = new Account(customerId, balance);
		aDao.createAccount(a);
		Logging.logger.info("Account was Created");
	}
	
	public void deleteAccount(int accountId) {
		
	}
	
	public List<AccountDisplay> getAllAccounts(){
		return aDao.getAllAccounts();
	}
	
	public User loadUserAccounts(User u) {
		return aDao.getUsersAccounts(u);
	}
	

}

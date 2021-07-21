package com.bank.dao;

import java.util.List;

import com.bank.models.Account;
import com.bank.models.AccountDisplay;
import com.bank.models.User;

public interface AccountDao {
	
	public void createAccount(Account a);
	
	public List<AccountDisplay> getAllAccounts();
	
	public User getUsersAccounts(User u);
	
	public void updateAccountBal(int userId, int balance, String approved);
	
	public void updateAccountApproval(int userId, int balance, String approved);
	
	public void deleteAccount(int accountId);
	
}

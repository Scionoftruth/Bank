package com.bank.services;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.FileIO;
import com.bank.models.Account;

public class AccountService {
	
	@SuppressWarnings("unused")
	private String file;
	private FileIO<Account> io;
	
	public AccountService(String file) {
		this.file = file;
		this.io = new FileIO<Account>(file);
	}
	
	public List<Account> getAllAccounts(){
		List<Account> aList;
		
		try {
			aList = io.readObject();
		}catch(FileNotFoundException e) {
			aList = new ArrayList<Account>();
		}catch(Exception e) {
			aList = null;
			e.printStackTrace();
		}
		
		return aList;
	}
	
	public void addAccount(Account a) {
		ArrayList<Account> aList;
		
		try {
			aList = io.readObject();
		}catch(FileNotFoundException e) {
			aList = new ArrayList<Account>();
		}catch(Exception e) {
			aList = null;
			e.printStackTrace();
		}
		aList.add(a);
		io.writeObject(aList);
	}

}

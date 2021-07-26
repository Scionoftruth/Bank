package com.bank.models;

import java.util.ArrayList;
import java.util.List;

//import com.bank.models.AccessLevel;

public class User{

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private String access;
	private List<Account> accounts;
	//private AccessLevel access;
	
	public User() {
		accounts = new ArrayList<Account>();
	}
	
	public User(int id, String firstName, String lastName, String username, String email, String password, String access) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.access = access;
		this.accounts = new ArrayList<Account>();
	}
	
	public User(String firstName, String lastName, String username, String email, String password, String access) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.access = access;
		this.accounts = new ArrayList<Account>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "UserId:" + id + "\n" + "First Name: " + firstName + "\n" + "Last Name:" + lastName + "\n" + "Username:" + username
				 + "Email: " + email + "\n" + "Access=" + access + "\n" + "Accounts:" + accounts;
	}
	

}

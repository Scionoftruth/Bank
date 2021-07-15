package com.bank.services;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.bank.models.User;
//import com.bank.models.AccessLevel;
import com.bank.exceptions.InvalidCredentialsException;
import com.bank.exceptions.UserDoesNotExistException;
import com.bank.exceptions.UsernameAlreadyExistsException;
import com.bank.dao.FileIO;

public class UserService {
	/*
	@SuppressWarnings("unused")
	private String file;
	private FileIO<User> io;
	
	public UserService(String file) {
		this.file = file;
		this.io = new FileIO<User>(file);
	}
	
	public User signUp(String firstName, String lastName, String username, String password, String accessAccessLevel access) {
		ArrayList<User> users;
		
		try {
			users = io.readObject();
		} catch(FileNotFoundException e) {
			System.out.println("Creating A Blank Users Array");
			users = new ArrayList<User>();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		User u = new User(firstName, lastName, username, password, access);
		
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getUsername().equals(u.getUsername())) {
				throw new UsernameAlreadyExistsException();
			}
		}
		
		users.add(u);
		io.writeObject(users);
		return u;
	}
	
	public User login(String username, String password) {
		ArrayList<User> users;
		
		try {
			users = io.readObject();
		} catch(FileNotFoundException e) {
			System.out.println("Creating A Blank Users Array");
			users = new ArrayList<User>();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getUsername().equals(username)) {
				if(users.get(i).getPassword().equals(password)) {
					System.out.println("User Was Signed In");
					return users.get(i);
				} else {
					throw new InvalidCredentialsException();
				}
			}
		}
		throw new UserDoesNotExistException();
	}
	
	public List<User> getAllUsers(){
		ArrayList<User> users;
		try {
			users = io.readObject();
		} catch(Exception e) {
			users = new ArrayList<User>();
		}
		return users;
	}*/

}

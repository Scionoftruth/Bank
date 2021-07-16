package com.bank.services;

//import java.io.FileNotFoundException;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import com.bank.models.User;
import com.bank.dao.UserDao;
import com.bank.exceptions.UsernameAlreadyExistsException;
import com.bank.logging.Logging;
//import com.bank.models.AccessLevel;
import com.bank.exceptions.InvalidCredentialsException;
import com.bank.exceptions.UserDoesNotExistException;
//import com.bank.exceptions.UsernameAlreadyExistsException;

public class UserService {
	
	private UserDao uDao;
	
	public UserService(UserDao u) {
		this.uDao = u;
	}
	
	public User signUp(String first, String last, String username, String email, String password, String access) throws UsernameAlreadyExistsException{
		User u = new User(first, last, username, email, password, access);
		
		try {
			uDao.createUser(u);
			Logging.logger.info("New user has registered");
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		u = uDao.getUserByUsername(u.getUsername());
		
		if(u == null) {
			Logging.logger.warn("Username Already Exists");
			throw new UsernameAlreadyExistsException();
		}
		
		return u;
	}
	
	public User signIn(String username, String password) throws UserDoesNotExistException, InvalidCredentialsException{
		
		User u = uDao.getUserByUsername(username);
		
		if(u.getId() == 0) {
			Logging.logger.warn("Account Does Not Exist");
			throw new UserDoesNotExistException();
		}else if(!u.getPassword().equals(password)) {
			Logging.logger.warn("User Tried to Login With Invalid Credentials");
			throw new InvalidCredentialsException();
		}else {
			Logging.logger.info("User Was Logged In");
			return u;
		}
		
	}

}

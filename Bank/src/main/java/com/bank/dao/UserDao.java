package com.bank.dao;

import com.bank.models.User;

public interface UserDao {
	
	User getUserByUsername(String username);
	User addUser(User u);

}

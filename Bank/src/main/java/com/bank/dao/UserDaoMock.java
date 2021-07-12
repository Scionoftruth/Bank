package com.bank.dao;

import java.util.ArrayList;
import java.util.List;

import com.bank.models.User;

public class UserDaoMock implements UserDao{
	
	private List<User> users = new ArrayList<User>();
	
	public UserDaoMock() {
		users.add(new User("Summer", "Smith", "ssmith","ssumertime","customer"));
		users.add(new User("Jerry","Smith","jsmith","jsmith","customer"));
		users.add(new User("Rick","Sanchez","picklerick","ricketyrick","customer"));
	}

	@Override
	public User getUserByUsername(String username) {
		for(int i=0; i<users.size(); i++) {
			User u = users.get(i);
			if(u.getUsername().equals(username)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public User addUser(User u) {
		users.add(u);
		return u;
	}

}

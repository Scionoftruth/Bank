package com.bank.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bank.dao.AccountDao;
import com.bank.dao.AccountDaoDB;
import com.bank.models.Account;
import com.bank.models.User;

import com.bank.dao.UserDao;
import com.bank.services.UserService;

public class UserServicesTest {

	@InjectMocks
	public UserService uServ;
	
	@Mock
	public UserDao uDao;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testValidLogin() {
		User u1 = new User(1,"test", "user", "testuser", "test@email.com", "testpass","customer");
		User not = new User(0, "test", "user","testuser", "test@mail.com", "testpass","customer");
		
		when(uDao.getUserByUsername(anyString())).thenReturn(u1);
		
		User loggedIn = uServ.signIn("testuser", "testpass");
		
		assertEquals(u1.getId(), loggedIn.getId());
	}
}

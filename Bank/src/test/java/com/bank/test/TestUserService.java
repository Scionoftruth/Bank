package com.bank.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.bank.models.User;

public class TestUserService {
	
	static User u;
	
	@BeforeClass
	public static void setupBeforeClass() throws Exception{
		u = new User();
	}
	
	@Test
	public void goodLogin() {
		//assertEquals("Testing Correct Login", )
	}
	

}

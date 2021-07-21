package com.bank.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.bank.models.Account;
import com.bank.models.User;

public class TestAccountDisplay {
		
		static User u;
		static Account a;
		
		@BeforeClass
		public static void setupBeforeClass() throws Exception{
			u = new User();
			
		}
		
		@Test
		public void userMatchesAccount() {
			u = new User("Test","User","Tested","Test123","password","customer");
			
			
		}
		

}

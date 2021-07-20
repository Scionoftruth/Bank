package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.bank.models.Account;
import com.bank.models.AccountDisplay;
import com.bank.models.User;
import com.bank.utils.ConnectionUtil;

public class AccountDaoDB implements AccountDao{

	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	@Override
	public void createAccount(Account a) {
		try {
			Connection con = conUtil.getConnection();
			
			con.setAutoCommit(false);
			String sql = "call create_account(?,?,?)";
			CallableStatement cs = con.prepareCall(sql);
			
			cs.setInt(1, a.getUserId());
			cs.setString(2, a.getApproved());
			cs.setDouble(3, a.getBalance());
			
			cs.execute();
			
			con.setAutoCommit(true);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<AccountDisplay> getAllAccounts() {

		List<AccountDisplay> aList = new ArrayList<AccountDisplay>();
		
		try {
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			
			String sql = "{?=call get_all_accounts()}";
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1,  Types.OTHER);
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				AccountDisplay account = new AccountDisplay(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5));
				aList.add(account);
			}
			
			con.setAutoCommit(true);
			return aList;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public User getUsersAccounts(User u) {
		List<Account> aList = new ArrayList<Account>();
		
		try {
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			
			String sql = "{?=call get_user_accounts(?)}";
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1,  Types.OTHER);
			cs.setInt(2, u.getId());
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Account a = new Account(rs.getInt(2),rs.getInt(3),rs.getDouble(4),rs.getString(5));
				aList.add(a);
			}
			
			u.setAccounts(aList);
			con.setAutoCommit(true);
			return u;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateAccount(int userId, double balance, String approved) {
		
		try {
			Connection con = conUtil.getConnection();
			
			con.setAutoCommit(false);
			String sql = "call update_account(?,?,?)";
			CallableStatement cs = con.prepareCall(sql);
			
			cs.setInt(1, userId);
			cs.setDouble(2, balance);
			cs.setString(3, approved);
			
			cs.execute();
			
			con.setAutoCommit(true);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void deleteAccount(int accountId) {
		try {
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM accounts WHERE accounts.account_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, accountId);
			
			ps.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	
}

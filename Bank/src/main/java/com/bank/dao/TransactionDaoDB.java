package com.bank.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.bank.models.Account;
import com.bank.models.AccountDisplay;
import com.bank.models.Transaction;
import com.bank.models.TransactionDisplay;
import com.bank.models.User;
import com.bank.utils.ConnectionUtil;

public class TransactionDaoDB implements TransactionDao{
	
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public void createTransaction(Transaction t) {
		try {
			Connection con = conUtil.getConnection();
			
			con.setAutoCommit(false);
			String sql = "call create_transaction(?,?,?)";
			CallableStatement cs = con.prepareCall(sql);
			
			cs.setInt(1, t.getSenderId());
			cs.setInt(2, t.getRecieverId());
			cs.setInt(3, t.getAmount());
			
			cs.execute();
			
			con.setAutoCommit(true);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TransactionDisplay> getAllTransactions() {
		
		List<TransactionDisplay> tList = new ArrayList<TransactionDisplay>();
		
		try {
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			
			String sql = "{?=call get_all_transactions()}";
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1,  Types.OTHER);
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				TransactionDisplay transaction = new TransactionDisplay(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
				tList.add(transaction);
			}
			
			con.setAutoCommit(true);
			return tList;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Account getAccountTransactions(Account a) {
		List<Transaction> tList = new ArrayList<Transaction>();
		
		try {
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			
			String sql = "{?=call get_account_transactions(?)}";
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1,  Types.OTHER);
			cs.setInt(2, a.getAccountId());
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Transaction t = new Transaction(rs.getInt(2),rs.getInt(3),rs.getInt(4));
				tList.add(t);
			}
			
			a.setTransactions(tList);
			con.setAutoCommit(true);
			return a;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void acceptTransaction(TransactionDisplay t) {
		try {
			Connection con = conUtil.getConnection();
			
			con.setAutoCommit(false);
			String sql = "call accept_transaction(?)";
			CallableStatement cs = con.prepareCall(sql);
			
			cs.setInt(1, t.getTransactionId());
			
			cs.execute();
			
			con.setAutoCommit(true);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int checkPending(TransactionDisplay t) {
		try {
			Connection con = conUtil.getConnection();
			
			String sql = "SELECT SUM(amount) FROM account_transfer WHERE account_transfer.sender_id = " + t.getSenderId();
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			return rs.getInt(0);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void rejectTransaction(TransactionDisplay t) {
		try {
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM account_transfer WHERE account_transfer.transfer_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, t.getTransactionId());
			
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}

package com.bwf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bwf.bean.User;
import com.bwf.dao.UserDao;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

//	@Override
//	public void insert(Connection conn, User u) throws SQLException {
//		Statement stat = null;
//		try {
//			String sql = "INSERT INTO user VALUES ("	
//					+ u.getId() + ","
//					+ "'" + u.getUname() + "',"
//					+ "'" + u.getUpwd() + "',"
//					+ u.getMoney()
//					+ ")";
//			
//			System.out.println(sql);
//		
//			stat = conn.createStatement();
//			stat.executeUpdate(sql);
//		} finally {
//			if(stat != null) {
//				stat.close();
//			}
//		}
//		
//		
//	}

	@Override
	public User queryByUname(Connection conn, String uname) throws SQLException {
		User u = null;
		Statement stat = null;
		try {
			String sql = "SELECT * FROM user WHERE uname = '" + uname + "'";
			System.out.println(sql);
			stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setUname(rs.getString("uname"));
				u.setMoney(rs.getDouble("money"));
				u.setUpwd(rs.getString("upwd"));
			}
			
		} finally {
			if(stat != null) {
				stat.close();
			}
		}
		
		
		return u;
	}

	@Override
	public User queryByUnameAndUpwd(Connection conn, String uname, String upwd) throws SQLException {
		User u = null;
		String sql = "SELECT * FROM user WHERE uname = ? AND upwd = ?";
		// 预编译SQL语句
		PreparedStatement ps = conn.prepareStatement(sql);
		// 设置参数
		ps.setString(1, uname);
		ps.setString(2, upwd);
		// 执行SQL语句
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			u = new User();
			u.setId(rs.getInt("id"));
			u.setUname(rs.getString("uname"));
			u.setMoney(rs.getDouble("money"));
			u.setUpwd(rs.getString("upwd"));
		}
		
		return u;
	}

	@Override
	public void updateMoneyById(Connection conn, Integer id, double money) throws SQLException {
		String sql = "UPDATE user SET money = money + ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, money);
		ps.setInt(2, id);
		int count = ps.executeUpdate();
	}

//	@Override
//	public User queryById(Connection conn, int id) throws SQLException {
//		User u = null;
//		String sql = "SELECT * FROM user WHERE id = ?";
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setInt(1, id);
//		ResultSet rs = ps.executeQuery();
//		if(rs.next()) {
//			u = new User();
//			u.setId(rs.getInt("id"));
//			u.setUname(rs.getString("uname"));
//			u.setMoney(rs.getDouble("money"));
//			u.setUpwd(rs.getString("upwd"));
//		}
//			
//		
//		return u;
//	}

	
	
//	有SQL注入风险
//	public User queryByUnameAndUpwd(Connection conn, String uname, String upwd) throws SQLException {
//		// SELECT * FROM user WHERE uname = 'aaa' AND upwd = '123';
//		String sql = "SELECT * FROM user WHERE uname = '" + uname + "' AND upwd = '" + upwd + "'";
//		System.out.println(sql);
//		User u = null;
//		Statement stat = null;
//		
//		try {
//			stat = conn.createStatement();
//			ResultSet rs = stat.executeQuery(sql);
//			
//			if(rs.next()) {
//				u = new User();
//				u.setId(rs.getInt("id"));
//				u.setUname(rs.getString("uname"));
//				u.setMoney(rs.getDouble("money"));
//				u.setUpwd(rs.getString("upwd"));
//			}
//			
//		} finally {
//			if(stat != null) {
//				stat.close();
//			}
//		}
//		
//		return u;
//	}
	
}

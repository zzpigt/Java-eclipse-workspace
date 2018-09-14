package com.bwf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.bwf.bean.User;
import com.bwf.dao.UserDao;
import com.bwf.jdbc.ConnectionFactory;

public class Test {

	public static void main(String[] args) {
		
		// ≤‚ ‘userDao
		UserDao ud = new UserDaoImpl();
		
		try {
			
			User u = new User();
			u.setId(3);
			u.setUname("¿ÓÀƒ");
			u.setUpwd("456");
			u.setMoney(700.0);
			
			ud.update(ConnectionFactory.getConnection(), u);
			
//			ud.insert(ConnectionFactory.getConnection(), u);
			
//			System.out.println(ud.getCount(ConnectionFactory.getConnection()));
			
//			ud.delete(ConnectionFactory.getConnection(), 6);
			
//			User user = ud.queryById(ConnectionFactory.getConnection(), 3);
//			System.out.println(user);
			
//			List<User> list = ud.queryAll(ConnectionFactory.getConnection());
//			for (User user : list) {
//				System.out.println(user);
//			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}

package cn.zzpigt.demo;

import java.sql.Connection;
import java.sql.SQLException;

import cn.zzpigt.dao.DeptDao;
import cn.zzpigt.dao.impl.DeptDaoImpl;
import cn.zzpigt.datasource.ConnectionFactory;

public class Demo7 {

	public static void main(String[] args) throws SQLException {
		
		DeptDao dd = new DeptDaoImpl();
		
		Connection c1 = ConnectionFactory.getConnection();
		System.out.println(c1);
		Connection c2 = ConnectionFactory.getConnection();
		System.out.println(c2);
		Connection c3 = ConnectionFactory.getConnection();
		System.out.println(c3);
		Connection c4 = ConnectionFactory.getConnection();
		System.out.println(c4);
		Connection c5 = ConnectionFactory.getConnection();
		System.out.println(c5);
		
		c1.close();
		c2.close();
		
//		ds.backToConn(c1);
//		ds.backToConn(c2);
		
		Connection c6 = ConnectionFactory.getConnection();
		System.out.println(c6);
		Connection c7 = ConnectionFactory.getConnection();
		System.out.println(c7);
		
		
		
		
	}
	
}

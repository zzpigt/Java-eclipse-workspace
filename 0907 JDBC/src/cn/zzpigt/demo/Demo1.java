package cn.zzpigt.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		ResultSet eq = null;
		try {
			//运行驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//连接mysql数据库
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "123456");
			
			//拿到连接对象，拿到stat
			stat = conn.createStatement();
			//准备sql语句,拿到执行的结果集
			String sql = "select * from emp";
			eq = stat.executeQuery(sql);
			while(eq.next()) {
				System.out.println(eq.getString(6));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(eq != null) {
				try {
					eq.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}

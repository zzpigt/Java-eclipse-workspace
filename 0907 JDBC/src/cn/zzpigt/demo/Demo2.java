package cn.zzpigt.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import cn.zzpigt.datasource.ConnectionFactory;

public class Demo2 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		
		
		try {
			conn = ConnectionFactory.getConnection();
			//拿到连接对象，拿到stat
			stat = conn.createStatement();
			//准备sql语句,拿到执行的结果集
			String sql = "insert into dept values (60 , 'sb', 'shanghai')";
			int eu = stat.executeUpdate(sql);
			System.out.println("影响了"+eu);
			
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
		}
	}
}

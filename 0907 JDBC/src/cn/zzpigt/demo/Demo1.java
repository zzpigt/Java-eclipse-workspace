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
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			
			//����mysql���ݿ�
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "123456");
			
			//�õ����Ӷ����õ�stat
			stat = conn.createStatement();
			//׼��sql���,�õ�ִ�еĽ����
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

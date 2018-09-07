package cn.zzpigt.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Hw1 {
	public static void main(String[] args) {
		
//		1. 打印出每个emp的 id 姓名 受雇日期 工资
		Connection conn = null;
		Statement stat = null;
		ResultSet eq = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "123456");
			stat = conn.createStatement();
			
			String sql = "select empno, ename,hiredate, sal from emp";
			
			eq = stat.executeQuery(sql);
			
			System.out.println("id\t姓名\t受雇日期\t\t工资");
			while(eq.next()) {
				System.out.println(eq.getString(1)+"\t"+eq.getString(2)+"\t"+eq.getString(3)+"\t"+eq.getString(4)+"\t");
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

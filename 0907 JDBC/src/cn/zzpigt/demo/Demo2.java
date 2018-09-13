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
			//�õ����Ӷ����õ�stat
			stat = conn.createStatement();
			//׼��sql���,�õ�ִ�еĽ����
			String sql = "insert into dept values (60 , 'sb', 'shanghai')";
			int eu = stat.executeUpdate(sql);
			System.out.println("Ӱ����"+eu);
			
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

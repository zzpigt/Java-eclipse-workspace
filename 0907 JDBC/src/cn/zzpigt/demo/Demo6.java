package cn.zzpigt.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo6 {
	public static void main(String[] args) {

		Connection conn = ConnectionFactory.getConnection();
		try {
			//保证connectin连接一致，然后关闭事务自动提交，（系统默认每条sql都是一个事务，所有系统默认会自动提交）
			conn.setAutoCommit(false);
			updateDept(50, conn);
			updateDept(60, conn);
			//只有所有sql语句都执行成功了，事务才会提交
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			//出现异常了，那么事务就需要回滚
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void updateDept(int id, Connection conn) throws SQLException {
		Statement stat = null;
		String sql = "update dept set loc = '北京' where deptno = " + id;
		if(id == 60) {
			throw new SQLException();
		}
		stat = conn.createStatement();
		int eu = stat.executeUpdate(sql);
		System.out.println(eu);

	}
}

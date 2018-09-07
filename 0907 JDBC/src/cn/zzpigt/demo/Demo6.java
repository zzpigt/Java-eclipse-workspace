package cn.zzpigt.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo6 {
	public static void main(String[] args) {

		Connection conn = ConnectionFactory.getConnection();
		try {
			//��֤connectin����һ�£�Ȼ��ر������Զ��ύ����ϵͳĬ��ÿ��sql����һ����������ϵͳĬ�ϻ��Զ��ύ��
			conn.setAutoCommit(false);
			updateDept(50, conn);
			updateDept(60, conn);
			//ֻ������sql��䶼ִ�гɹ��ˣ�����Ż��ύ
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			//�����쳣�ˣ���ô�������Ҫ�ع�
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
		String sql = "update dept set loc = '����' where deptno = " + id;
		if(id == 60) {
			throw new SQLException();
		}
		stat = conn.createStatement();
		int eu = stat.executeUpdate(sql);
		System.out.println(eu);

	}
}

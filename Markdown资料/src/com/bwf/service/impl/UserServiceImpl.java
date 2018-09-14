package com.bwf.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bwf.bean.Record;
import com.bwf.bean.User;
import com.bwf.dao.RecordDao;
import com.bwf.dao.UserDao;
import com.bwf.dao.impl.RecordDaoImpl;
import com.bwf.dao.impl.UserDaoImpl;
import com.bwf.jdbc.ConnectionFactory;
import com.bwf.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao ud;

	private RecordDao rd;
	
	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public void setRd(RecordDao rd) {
		this.rd = rd;
	}

	@Override
	public void regist(String uname, String upwd) throws Exception {
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			// �û����Ƿ����
			if(ud.queryByUname(conn, uname) != null) {
				// �û������� , ע��ʧ��
				throw new Exception("�û����Ѿ�����!");
			}
			// �û���������, ���Բ���
			User u = new User();
			u.setUname(uname);
			u.setUpwd(upwd);
			ud.insert(conn, u);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public User login(String uname, String upwd) throws Exception {
		Connection conn = ConnectionFactory.getConnection();
		try {
			// ������
			conn.setAutoCommit(false);
			// ����dao���������û����������ѯ�û�
			User u = ud.queryByUnameAndUpwd(conn, uname, upwd);
			
			if(u != null) {
				// ���������¼
				Record r = new Record();
				r.setUid(u.getId());
				r.setContent(u.getId()  + "��¼��.");
				rd.insert(conn, r);
				conn.commit();
				return u;
			} else {
				conn.rollback();
				throw new Exception("�û������������!");
			}
			
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		}
	}

	@Override
	public void saveMoney(User me, double money) throws Exception {
		Connection conn = ConnectionFactory.getConnection();
		try {
			conn.setAutoCommit(false);
			ud.updateMoneyById(conn, me.getId(), money);
			// ���������¼
			Record r = new Record();
			r.setUid(me.getId());
			r.setContent(me.getId()  + "����" + money + "Ԫ.");
			rd.insert(conn, r);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		}
		
		
	}

	@Override
	public List<Record> getRecordList(User me) throws Exception {
		return rd.queryByUid(ConnectionFactory.getConnection(), me.getId());
	}

	
	@Override
	public void drawMoney(User me, double money) throws Exception {
		
		
		Connection conn = ConnectionFactory.getConnection();
		try {
			conn.setAutoCommit(false);
			User u = ud.queryByUname(conn, me.getUname());
			// �ж�������
			if(u.getMoney() < money) {
				throw new Exception("����, ���ֵ!");
			}
			
			ud.updateMoneyById(conn, me.getId(), -money);
			Record r = new Record();
			r.setUid(me.getId());
			r.setContent(me.getId() + " ȡ�� " + money + " Ԫ ");
			rd.insert(conn, r);
			conn.commit();
			
		} catch (SQLException e) {

			conn.rollback();
		}
		
	}

	@Override
	public void tranMoney(User me, int target, double money) throws Exception {
		Connection conn = ConnectionFactory.getConnection();
		try {
			conn.setAutoCommit(false);
			// ��֤Ŀ���û��Ƿ����
			User u = ud.queryById(conn, target);
			if(u == null) {
				throw new Exception("Ŀ���û�������!");
			}
			
			// ת�˽�����
			me = ud.queryById(conn, me.getId());
			if(me.getMoney() < money) {
				throw new Exception("����!");
			}
			
			ud.updateMoneyById(conn, me.getId(), -money);
			ud.updateMoneyById(conn, target, money);
			
			Record record = new Record();
			record.setUid(me.getId());
			record.setContent(me.getUname() + " ת�� " + money  + "Ԫ��" + target);
			rd.insert(conn, record);
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			throw e;
		}
		
	}
}

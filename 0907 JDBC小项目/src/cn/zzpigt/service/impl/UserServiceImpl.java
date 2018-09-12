package cn.zzpigt.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.SimpleAttributeSet;

import cn.zzpigt.bean.Record;
import cn.zzpigt.bean.Users;
import cn.zzpigt.dao.RecordDao;
import cn.zzpigt.dao.UsersDao;
import cn.zzpigt.service.UserService;
import cn.zzpigt.view.ConnectionFactory;

public class UserServiceImpl implements UserService {

	private static UsersDao ud;
	private static RecordDao rd;
	private static Users u = null;

	public static void setUd(UsersDao ud) {
		UserServiceImpl.ud = ud;
	}

	public static void setRd(RecordDao rd) {
		UserServiceImpl.rd = rd;
	}

	@Override
	public void register(String name, String pwd) throws Exception {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			if (ud.queryByUname(name, conn) != null) {
				throw new Exception("�û����Ѿ����ڣ���");
			}
			u = new Users();
			u.setName(name);
			u.setPwd(pwd);
			ud.insert(u, conn);
			throw new Exception("ע��ɹ�����");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	@Override
	public Users loginer(String name, String pwd) throws Exception {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			u = ud.queryByNameAndPwd(name, pwd, conn);
			if (u == null) {
				if (ud.queryByUname(name, conn) != null) {
					throw new Exception("�û������ڣ�������󣡣�");
				} else {
					throw new Exception("�û��������ڣ�����ȥע�ᣡ��");
				}
			}
			//�ɹ����룬�Ͳ�����־
			Record r = new Record();
			r.setConnect(u.getName()+"����ϵͳ ");
			r.setUid(u.getId());
			r.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			rd.insert(r,conn);
			
			conn.commit();
			return u;

		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	@Override
	public void saveMoney(Users me, double money) throws Exception {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			
			ud.updateMoneyByName(me.getName(),money,conn);
			//��¼
			Record r = new Record();
			r.setConnect(me.getName()+"����"+money+"Ԫ");
			r.setUid(me.getId());
			r.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			rd.insert(r,conn);
			
			conn.commit();
			
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		
		
	}

	@Override
	public void drawMoney(Users me, double money) throws Exception {
		
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			//�ж�����ǲ��ǹ�
			Users nowUser = ud.queryById(me.getId(), conn);
			if(nowUser.getMoney() < money) {
				throw new Exception("���㣡�����ֵ����");
			}
			
			ud.updateMoneyByName(me.getName(), -money, conn);
			
			//��¼
			Record r = new Record();
			r.setConnect(me.getName()+"ȡ��"+money+"Ԫ");
			r.setUid(me.getId());
			r.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			rd.insert(r,conn);			
			conn.commit();
			
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		
		
	}

	@Override
	public void transfer(Users me,String name, double money) throws Exception {
		
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			//�ж����������ת��
			Users nowUser = ud.queryById(me.getId(), conn);
			if(nowUser.getMoney() < money) {
				conn.rollback();
				throw new Exception("���㣡�����ֵ����");
			}
			
			//ת�˵��û��Ƿ����
			if(ud.queryByUname(name, conn) == null) {
				conn.rollback();
				throw new Exception("ת�˶��󲻴��ڣ���");
			}
			
			ud.updateMoneyByName(me.getName(), -money, conn);
			ud.updateMoneyByName(name, money, conn);
			
			//��¼
			Record r = new Record();
			r.setConnect(me.getName()+"��"+name+"ת����"+money+"Ԫ");
			r.setUid(me.getId());
			r.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			rd.insert(r,conn);
			
			conn.commit();
			
			
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		
	}

	@Override
	public Users getMyMoney(Users me) throws Exception {
		Users u = ud.queryById(me.getId(), ConnectionFactory.getConnection());
		return u;
	}

}

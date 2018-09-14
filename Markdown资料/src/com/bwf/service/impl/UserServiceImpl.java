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
			// 用户名是否存在
			if(ud.queryByUname(conn, uname) != null) {
				// 用户名存在 , 注册失败
				throw new Exception("用户名已经存在!");
			}
			// 用户名不存在, 可以插入
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
			// 打开事务
			conn.setAutoCommit(false);
			// 调用dao方法根据用户名和密码查询用户
			User u = ud.queryByUnameAndUpwd(conn, uname, upwd);
			
			if(u != null) {
				// 加入操作记录
				Record r = new Record();
				r.setUid(u.getId());
				r.setContent(u.getId()  + "登录了.");
				rd.insert(conn, r);
				conn.commit();
				return u;
			} else {
				conn.rollback();
				throw new Exception("用户名或密码错误!");
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
			// 加入操作记录
			Record r = new Record();
			r.setUid(me.getId());
			r.setContent(me.getId()  + "存了" + money + "元.");
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
			// 判断余额够不够
			if(u.getMoney() < money) {
				throw new Exception("余额不足, 请充值!");
			}
			
			ud.updateMoneyById(conn, me.getId(), -money);
			Record r = new Record();
			r.setUid(me.getId());
			r.setContent(me.getId() + " 取了 " + money + " 元 ");
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
			// 验证目标用户是否存在
			User u = ud.queryById(conn, target);
			if(u == null) {
				throw new Exception("目标用户不存在!");
			}
			
			// 转账金额够不够
			me = ud.queryById(conn, me.getId());
			if(me.getMoney() < money) {
				throw new Exception("余额不足!");
			}
			
			ud.updateMoneyById(conn, me.getId(), -money);
			ud.updateMoneyById(conn, target, money);
			
			Record record = new Record();
			record.setUid(me.getId());
			record.setContent(me.getUname() + " 转账 " + money  + "元给" + target);
			rd.insert(conn, record);
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			throw e;
		}
		
	}
}

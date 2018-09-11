package cn.zzpigt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.zzpigt.bean.Users;
import cn.zzpigt.dao.UsersDao;


public class UsersDaoImpl extends BaseDaoImpl<Users> implements UsersDao{

	
//	@Override
//	public void insert(Users u, Connection conn) throws SQLException {
//		String sql = "insert into users (name, pwd) values(?,?)";
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1, u.getName());
//		ps.setString(2, u.getPwd());
//		try {
//			int eu = ps.executeUpdate();
//			System.out.println("影响了"+eu);
//			lastSql = "增："+sql.replace("'", "`");
//		} finally {
//			if(ps != null) {
//				try {
//					ps.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//	}
//
//	@Override
//	public void delete(int id, Connection conn) throws SQLException {
//		String sql = "delete from users where id = ?";
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setObject(1, id);
//		try {
//			int eu = ps.executeUpdate();
//			System.out.println("影响了"+eu);
//			lastSql = "删："+sql.replace("'", "`");
//		} finally {
//			if(ps != null) {
//				try {
//					ps.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}

//	@Override
//	public void update(Users u, Connection conn) throws SQLException {
//		String sql = "update users set name = ?,pwd = ?,money = ? where id = ?";
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1, u.getName());
//		ps.setString(2, u.getPwd());
//		ps.setObject(3, u.getMoney());
//		ps.setObject(4, u.getId());
//		try {
//			int eu = ps.executeUpdate();
//			System.out.println("影响了"+eu);
//			lastSql = "改："+sql.replace("'", "`");
//		} finally {
//			if(ps != null) {
//				try {
//					ps.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}

//	@Override
//	public List<Users> queryAll(Connection conn) throws SQLException {
//		List<Users> list  = new ArrayList<>();
//		String sql = "select * from users";
//		Statement stat = null;
//		ResultSet rs = null;
//		try {
//			stat = conn.createStatement();
//			rs = stat.executeQuery(sql);
//			while(rs.next()) {
//				Users u = new Users();
//				u.setId(rs.getInt("id"));
//				u.setName(rs.getString("name"));
//				u.setPwd(rs.getString("pwd"));
//				u.setMoney(rs.getDouble("money"));
//				list.add(u);
//			}
//			lastSql = "查："+sql.replace("'", "`");
//		} finally {
//			if(stat != null) {
//				try {
//					stat.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		return list;
//	}

//	@Override
//	public Users queryById(int id, Connection conn) throws SQLException {
//		String sql = "select * from users where id = ?";
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setObject(1, id);
//		ResultSet rs = null;
//		Users u = null;
//		try {
//			rs = ps.executeQuery();
//			if(rs.next()) {
//				u = new Users();
//				u.setId(rs.getInt("id"));
//				u.setName(rs.getString("name"));
//				u.setPwd(rs.getString("pwd"));
//				u.setMoney(rs.getDouble("money"));
//			}
//			lastSql = "查："+sql.replace("'", "`");
//			
//		} finally {
//			if(ps != null) {
//				try {
//					ps.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return u;
//	}

//	@Override
//	public int getCount(Connection conn) throws SQLException {
//		String sql = "select count(id) from users";
//		Statement stat = null;
//		ResultSet rs = null;
//		try {
//			stat = conn.createStatement();
//			rs = stat.executeQuery(sql);
//			if(rs.next()) {
//				lastSql = "查："+sql.replace("'", "`");
//				return rs.getInt(1);
//			}
//			
//		} finally {
//			if(stat != null) {
//				try {
//					stat.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		lastSql = "查："+sql.replace("'", "`");
//		return 0;
//	}

	@Override
	public boolean isSameName(String name, Connection conn) throws SQLException {
		String sql = "select count(id) from users where name = '"+name+"'";
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if(rs.next()) {
				if(rs.getInt(1)>0) {
					System.out.println(rs.getInt(1));
					return true;
				}
			}
			
		} finally {
			if(stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public boolean isSuccessLogin(String name, String pwd, Connection conn) throws SQLException {
		String sql = "select count(id) from users where name = ? and pwd = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, pwd);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)>0) {
					System.out.println(rs.getInt(1));
					return true;
				}
			}
			
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public Users queryByUname(String uname,Connection conn) throws SQLException {
		String sql = "select * from users where name = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uname);
		ResultSet rs = null;
		Users u = null;
		try {
			
			rs = ps.executeQuery();
			if(rs.next()) {
				u = new Users();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPwd(rs.getString("pwd"));
				u.setMoney(rs.getDouble("money"));
			}
			
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return u;
	}

	@Override
	public Users queryByNameAndPwd(String name, String pwd, Connection conn) throws SQLException {
		
		String sql = "select * from users where name = ? AND pwd = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, pwd);
		ResultSet rs = null;
		Users u = null;
		try {
			rs = ps.executeQuery();
			if(rs.next()) {
				u = new Users();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPwd(rs.getString("pwd"));
				u.setMoney(rs.getDouble("money"));
			}
			
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return u;
	}

	@Override
	public void updateMoneyByName(String name, double money, Connection conn) throws SQLException {
		String sql = "update users set money = money + ? where name = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, money);
		ps.setString(2, name);
		try {
			ps.executeUpdate();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

}

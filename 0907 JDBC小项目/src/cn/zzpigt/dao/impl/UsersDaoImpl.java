package cn.zzpigt.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.zzpigt.bean.Users;
import cn.zzpigt.dao.UsersDao;


public class UsersDaoImpl implements UsersDao{

	public static String lastSql;
	
	@Override
	public void insert(Users u, Connection conn) throws SQLException {
		String sql = "insert into users (name,pwd,money) values('"+u.getName()+"','"+u.getPwd()+"','"+u.getMoney()+"')";
		Statement stat = null;
		try {
			stat = conn.createStatement();
			int eu = stat.executeUpdate(sql);
			System.out.println("影响了"+eu);
			lastSql = "增："+sql.replace("'", "`");
		} finally {
			if(stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void delete(int id, Connection conn) throws SQLException {
		String sql = "delete from users where id = "+id;
		Statement stat = null;
		try {
			stat = conn.createStatement();
			int eu = stat.executeUpdate(sql);
			System.out.println("影响了"+eu);
			lastSql = "删："+sql.replace("'", "`");
		} finally {
			if(stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void updata(Users u, Connection conn) throws SQLException {
		String sql = "update users set name = '"+u.getName()+"',pwd = '"+u.getPwd()+"',money = '"+u.getMoney()+"' where id = '"+u.getId()+"'";
		Statement stat = null;
		try {
			stat = conn.createStatement();
			int eu = stat.executeUpdate(sql);
			System.out.println("影响了"+eu);
			lastSql = "改："+sql.replace("'", "`");
		} finally {
			if(stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<Users> queryAll(Connection conn) throws SQLException {
		List<Users> list  = new ArrayList<>();
		String sql = "select * from users";
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				Users u = new Users();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPwd(rs.getString("pwd"));
				u.setMoney(rs.getDouble("money"));
				list.add(u);
			}
			lastSql = "查："+sql.replace("'", "`");
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
		
		return list;
	}

	@Override
	public Users queryById(int id, Connection conn) throws SQLException {
		String sql = "select * from users where id = "+id;
		Statement stat = null;
		ResultSet rs = null;
		Users u = null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if(rs.next()) {
				u = new Users();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPwd(rs.getString("pwd"));
				u.setMoney(rs.getDouble("money"));
			}
			lastSql = "查："+sql.replace("'", "`");
			
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
		return u;
	}

	@Override
	public int getCount(Connection conn) throws SQLException {
		String sql = "select count(id) from users";
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if(rs.next()) {
				lastSql = "查："+sql.replace("'", "`");
				return rs.getInt(1);
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
		lastSql = "查："+sql.replace("'", "`");
		return 0;
	}

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
					lastSql = "查："+sql.replace("'", "`");
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
		String sql = "select count(id) from users where name = '"+name+"' and pwd = '"+pwd+"'";
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if(rs.next()) {
				if(rs.getInt(1)>0) {
					System.out.println(rs.getInt(1));
					lastSql = "查："+sql.replace("'", "`");
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

}

package cn.zzpigt.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.zzpigt.bean.Dept;
import cn.zzpigt.dao.DeptDao;
import cn.zzpigt.datasource.ConnectionFactory;

public class DeptDaoImpl implements DeptDao{

	@Override
	public void insert(Dept d) {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "insert into dept values('"+d.getDeptno()+"','"+d.getDname()+"','"+d.getLoc()+"')";
		Statement stat = null;
		try {
			stat = conn.createStatement();
			int eu = stat.executeUpdate(sql);
			System.out.println("影响了"+eu);
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

	@Override
	public void delete(int id) {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "delete from dept where deptno = "+id;
		Statement stat = null;
		try {
			stat = conn.createStatement();
			int eu = stat.executeUpdate(sql);
			System.out.println("影响了"+eu);
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

	@Override
	public void updata(Dept d) {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "update dept set dname = '"+d.getDname()+"',loc = '"+d.getLoc()+"' where deptno = '"+d.getDeptno()+"'";
		Statement stat = null;
		try {
			stat = conn.createStatement();
			int eu = stat.executeUpdate(sql);
			System.out.println("影响了"+eu);
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

	@Override
	public List<Dept> queryAll(Connection conn) {
		List<Dept> list  = new ArrayList<>();
		String sql = "select * from dept";
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				Dept d = new Dept();
				d.setDeptno(rs.getInt("deptno"));
				d.setDname(rs.getString("dname"));
				d.setLoc(rs.getString("loc"));
				list.add(d);
			}
			
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
	public Dept queryById(int id) {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "select * from dept where deptno = "+id;
		Statement stat = null;
		ResultSet rs = null;
		Dept d = null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if(rs.next()) {
				d = new Dept();
				d.setDeptno(rs.getInt("deptno"));
				d.setDname(rs.getString("dname"));
				d.setLoc(rs.getString("loc"));
			}
			
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
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return d;
	}

	@Override
	public int getCount() {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "select count(deptno) from dept";
		Statement stat = null;
		ResultSet rs = null;
		Dept d = null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt(1);
			}
			
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
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return 0;
	}
	
	
}

package cn.zzpigt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.zzpigt.bean.Record;
import cn.zzpigt.dao.RecordDao;


public class RecordDaoImpl extends BaseDaoImpl<Record> implements RecordDao{
	

//	@Override
//	public void insert(Record r, Connection conn) throws SQLException {
//		String sql = "insert into record (connect,date,uid) values (? , NOW() ,?)";
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1, r.getConnect());
//		ps.setObject(2, r.getUid());
//		try {
//			int eu = ps.executeUpdate();
//			System.out.println("”∞œÏ¡À"+eu);
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

//	@Override
//	public void delete(int id, Connection conn) throws SQLException {
//		String sql = "delete from record where id = £ø";
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setInt(1, id);
//		try {
//			ps.executeUpdate();
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
//	public List<Record> queryAll(Connection conn) throws SQLException {
//		List<Record> list  = new ArrayList<>();
//		String sql = "select * from record";
//		Statement stat = null;
//		ResultSet rs = null;
//		try {
//			stat = conn.createStatement();
//			rs = stat.executeQuery(sql);
//			while(rs.next()) {
//				Record r = new Record();
//				r.setId(rs.getInt("id"));
//				r.setConnect(rs.getString("connect"));
//				r.setDate(rs.getString("date"));
//				list.add(r);
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
//		
//		return list;
//	}

//	@Override
//	public Record queryById(int id, Connection conn) throws SQLException {
//		String sql = "select * from record where id = "+id;
//		Statement stat = null;
//		ResultSet rs = null;
//		Record r = null;
//		try {
//			stat = conn.createStatement();
//			rs = stat.executeQuery(sql);
//			if(rs.next()) {
//				r = new Record();
//				r.setId(rs.getInt("id"));
//				r.setConnect(rs.getString("connect"));
//				r.setDate(rs.getString("date"));
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
//		return r;
//	}

//	@Override
//	public int getCount(Connection conn) throws SQLException {
//		String sql = "select count(id) from record";
//		Statement stat = null;
//		ResultSet rs = null;
//		try {
//			stat = conn.createStatement();
//			rs = stat.executeQuery(sql);
//			if(rs.next()) {
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
//					throw e;
//				}
//			}
//		}
//		return 0;
//	}

	@Override
	public List<Record> queryByUid(int uid, Connection conn) throws SQLException {
		List<Record> list = new ArrayList<>();
		String sql = "select * from record where uid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, uid);
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Record r = new Record();
				r.setConnect(rs.getString("connect"));
				r.setDate(rs.getString("date"));
				r.setId(rs.getInt("id"));
				r.setUid(rs.getInt("uid"));
				
				list.add(r);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			if(ps != null) {
				ps.close();
			}
		}
		
		return list;
	}

	

}

package com.bwf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bwf.bean.Record;
import com.bwf.dao.RecordDao;

public class RecordDaoImpl extends BaseDaoImpl<Record> implements RecordDao {

	@Override
	public void insert(Connection conn, Record r) throws SQLException {
		String sql = "INSERT INTO record VALUES(?,?,NOW(),?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, r.getId());
		ps.setString(2, r.getContent());
		ps.setObject(3, r.getUid());
		int count = ps.executeUpdate();
	}
	

	@Override
	public List<Record> queryByUid(Connection conn, int uid) throws SQLException {
		List<Record> list = new ArrayList<>();
		String sql = "SELECT * FROM record WHERE uid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, uid);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Record r = new Record();
			r.setId(rs.getInt("id"));
			r.setContent(rs.getString("content"));
			r.setTime(rs.getDate("time"));
			r.setUid(rs.getInt("uid"));
			list.add(r);
		}
		
		return list;
	}




	

}

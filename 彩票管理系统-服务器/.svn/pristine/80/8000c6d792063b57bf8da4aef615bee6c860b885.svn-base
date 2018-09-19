package com.bwf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bwf.bean.Admin;
import com.bwf.dao.AdminDao;

public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao {

	@Override
	public Admin getByNameAndPwd(String uName, String uPwd, Connection conn) throws SQLException {
		String sql = "select * from admin where name = ? and pwd = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uName);
		ps.setString(2, uPwd);

		ResultSet rs = ps.executeQuery();
		Admin a = null;
		if (rs.next()) {
			a = new Admin();
			a.setId(rs.getInt("id"));
			a.setName(rs.getString("name"));
			a.setPwd(rs.getString("pwd"));
			a.setState(rs.getInt("state"));
			a.setLevel(rs.getInt("level"));
		}
		return a;

	}

}

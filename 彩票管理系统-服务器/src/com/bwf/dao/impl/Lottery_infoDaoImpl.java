package com.bwf.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bwf.bean.Lottery_info;
import com.bwf.dao.Lottery_infoDao;

public class Lottery_infoDaoImpl extends BaseDaoImpl<Lottery_info> implements Lottery_infoDao {

	@Override
	public void update(Lottery_info Li, Connection conn) throws SQLException {

		// 拼接sql语句
		//update Lottery_info set time=?,price=?,state=?,sellnum=?,poolmoney=? where time=?
		String sql = "update Lottery_info set time=?,price=?,state=?,sellnum=?,poolmoney=? where time=?";

		// 填充占位符
		System.out.println(sql);
		PreparedStatement ps = conn.prepareStatement(sql);
		// 存放条件表达式 即id,数组下标第一
		ps.setString(1, Li.getTime());
		ps.setDouble(2, Li.getPrice());
		ps.setInt(3, Li.getState());
		ps.setInt(4, Li.getSellnum());
		ps.setDouble(5, Li.getPoolmoney());
		ps.setString(6, Li.getTime());
		ps.executeUpdate();
		System.out.println(sql);
	}
	
	
	@Override
	public Lottery_info getLastMeg(Connection conn) throws Exception {
		Lottery_info lottery_info = new Lottery_info();
		String sql = "select *from lottery_info where state=0";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			lottery_info.setTime(rs.getString("time"));
			lottery_info.setPrice(rs.getDouble("price"));
			lottery_info.setState(rs.getInt("state"));
			lottery_info.setSellnum(rs.getInt("sellnum"));
			lottery_info.setPoolmoney(rs.getDouble("poolmoney"));
		}
		System.out.println(lottery_info+"123");
		return lottery_info;
	}

}

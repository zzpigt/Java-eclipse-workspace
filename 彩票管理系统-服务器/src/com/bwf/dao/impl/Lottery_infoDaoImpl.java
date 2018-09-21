package com.bwf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bwf.bean.Lottery_info;
import com.bwf.dao.Lottery_infoDao;

public class Lottery_infoDaoImpl extends BaseDaoImpl<Lottery_info> implements Lottery_infoDao {

	@Override
	public void update(Lottery_info Li, Connection conn) throws SQLException {

		// 拼接sql语句
		// update Lottery_info set time=?,price=?,state=?,sellnum=?,poolmoney=? where
		// time=?
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
	public Lottery_info getLastMeg(Connection conn) throws SQLException {
		Lottery_info lottery_info = null;
		String sql = "select *from lottery_info where state= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, 0);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			lottery_info = new Lottery_info();
			lottery_info.setTime(rs.getString("time"));
			lottery_info.setPrice(rs.getDouble("price"));
			lottery_info.setState(rs.getInt("state"));
			lottery_info.setSellnum(rs.getInt("sellnum"));
			lottery_info.setPoolmoney(rs.getDouble("poolmoney"));
		}
		return lottery_info;
	}

	@Override
	public Lottery_info getNotLastMeg(Connection conn) throws SQLException {
		// Lottery_info lottery_info = new Lottery_info();
		Lottery_info lottery_info = null;
		String sql = "select *from lottery_info where poolmoney!=0";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			lottery_info = new Lottery_info();
			lottery_info.setTime(rs.getString("time"));
			lottery_info.setPrice(rs.getDouble("price"));
			lottery_info.setState(rs.getInt("state"));
			lottery_info.setSellnum(rs.getInt("sellnum"));
			lottery_info.setPoolmoney(rs.getDouble("poolmoney"));
		}
		return lottery_info;
	}

	@Override
	public List<String> queryAllLottery(Connection conn) throws SQLException {
		List<String> list = new ArrayList<>();
		String sql = "select *from lottery_info";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			StringBuilder sb = new StringBuilder(rs.getString("time") + "\t")
					.append(rs.getDouble("price") + "\t")
					.append(rs.getInt("state") + "\t")
					.append(rs.getString("winnum") + "\t")
					.append(rs.getInt("sellnum") + "\t")
					.append(rs.getDouble("poolmoney"));

			list.add(String.valueOf(sb));
		}
		return list;
	}

	@Override
	public void updataStateWinnumPoolmoneyByTime(String time, String winNum, double sumMoney, Connection conn)
			throws SQLException {

		String sql = "update lottery_info set state = ? ,winnum = ?,poolmoney = poolmoney - ? where time = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, 1);
		ps.setString(2, winNum);
		ps.setDouble(3, sumMoney);
		ps.setString(4, time);
		ps.executeUpdate();

	}

}

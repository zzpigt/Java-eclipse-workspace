package com.bwf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bwf.bean.User_lottery;
import com.bwf.dao.User_lotteryDao;

public class User_lotteryDaoImpl extends BaseDaoImpl<User_lottery> implements User_lotteryDao {

	@Override
	public List<String> getByUid(int id, Connection conn) throws SQLException {
		List<String> list =new ArrayList<>();
		String sql="select * from user_lottery where uid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,id );
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			//list.add(rs.getString("selectednum")+"%"+rs.getInt("buycount"));
			
			String str=rs.getInt("id")+"\t"+rs.getString("ltime")+"\t"+
					rs.getString("selectednum")+
					"\t"+rs.getInt("buycount")+"\t"+rs.getDouble("winmoney")+
					"\t"+rs.getString("buytime");
			
			list.add(str);
		
		}

		return list;
	}

	@Override
	public int getBySelectnumAndUid(String selectNum, int uid, String ltime,  Connection conn) throws SQLException {
		String sql = "select sum(buycount) from user_lottery where uid=? and selectednum=? and ltime=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, uid);
		ps.setObject(2, selectNum);
		ps.setObject(3,ltime);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			System.out.println(rs.getInt(1));
			return rs.getInt(1);
			
		} else {
			return 0;
		}
	}

	@Override
	public List<String> getByUidAndTime(int id, String time, Connection conn) throws SQLException {
		List<String> list =new ArrayList<>();
		String sql="select * from user_lottery where uid=? and ltime=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,id );
		ps.setString(2,time);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list.add(rs.getString("selectednum")+"\t注数:"+rs.getInt("buycount"));
		}

		return list;
	}

	@Override
	public void updataWinmoneyByTimeAndWinnum(List<User_lottery> uList, String winNum, Double poolmoney, String time,
			Connection conn) throws SQLException {
		//开奖后更新所有彩民的winmoney
		for (User_lottery ul : uList) {
			double winMoney = getWinMoney(poolmoney,winNum,ul.getSelectednum());
			String sql = "update user_lottery set winmoney = ? where id = ? and ltime = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, winMoney*ul.getBuycount());
			ps.setInt(2, ul.getId());
			ps.setString(3, time);
			ps.executeUpdate();
		}
		
	}

	/**
	 * 计算购买的彩票赢的钱
	 * @param selectednum
	 * @param poolmoney
	 * @param winNum
	 * @return
	 */
	private double getWinMoney(Double poolmoney, String winNum, String num) {
		String[] w_redNum = winNum.substring(0, winNum.indexOf(":")).split("-");
		String w_buleNum = winNum.substring(winNum.indexOf(":") + 1);
		List<String> wList = new ArrayList<>();
		for (String s : w_redNum) {
			wList.add(s);
		}
		
		// 买的号码
		int redCount = 0;//红球的个数
		String[] u_redNum = num.substring(0, num.indexOf(":")).split("-");
		for (String u : u_redNum) {
			if(wList.contains(u)) {
				redCount++;
			}
		}
		System.out.println("红对的个数："+redCount);
		//蓝球
		int buleCount = 0;
		String u_buleNum = num.substring(num.indexOf(":") + 1);
		if(u_buleNum.equals(w_buleNum)){
			buleCount = 1;
		}
		System.out.println("蓝对的个数："+buleCount);

		//判断
		if(redCount+buleCount == 7) {
			return (int) (poolmoney * 0.1);
		}else if(redCount == 6) {
			return (int) (poolmoney * 0.05);
		}else if(redCount+buleCount == 6) {
			return 3000;
		}else if(redCount == 5) {
			return 500;
		}else if(redCount+buleCount == 5) {
			return 200;
		}else if(redCount == 4) {
			return 20;
		}else if(redCount+buleCount == 4) {
			return 10;
		}else if(buleCount == 1) {
			return 5;
		}else {
			return 0;
		}

	}

	@Override
	public List<User_lottery> getByTime(String time, Connection conn) throws SQLException {
		List<User_lottery> uList = new ArrayList<>();
		
		String sql = "select * from user_lottery where ltime = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, time);
		ResultSet rs = ps.executeQuery();
		User_lottery ul = null;
		while(rs.next()) {
			ul = new User_lottery();
			ul.setBuycount(rs.getInt("buycount"));
			ul.setBuytime(rs.getString("buytime"));
			ul.setId(rs.getInt("id"));
			ul.setLtime(rs.getString("ltime"));
			ul.setSelectednum(rs.getString("selectednum"));
			ul.setUid(rs.getInt("uid"));
			ul.setWinmoney(rs.getDouble("winmoney"));
			uList.add(ul);
		}
		return uList;
	}

	@Override
	public double getSumByTime(String time, Connection conn) throws SQLException {
		String sql = "select sum(winmoney) from user_lottery where ltime = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, time);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return rs.getDouble(1);
		}
		return 0;
	}

	@Override
	public Map<Integer, Double> getWinmoneyByTime(String time, Connection conn) throws SQLException {
		Map<Integer,Double> map = new HashMap<>();
		String sql = "select uid,sum(winmoney) from user_lottery where ltime = ? group by uid";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, time);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			map.put(rs.getInt(1), rs.getDouble(2));
		}
		return map;
	}




}

package com.bwf.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bwf.bean.Lottery_info;

public interface Lottery_infoDao extends BaseDao<Lottery_info>{

	Lottery_info getLastMeg(Connection conn)throws SQLException;

	Lottery_info getNotLastMeg(Connection conn) throws SQLException;
	List<String> queryAllLottery(Connection conn) throws SQLException;

	void updataStateWinnumPoolmoneyByTime(String time, String winNum, double sumMoney, Connection conn)throws SQLException;
}

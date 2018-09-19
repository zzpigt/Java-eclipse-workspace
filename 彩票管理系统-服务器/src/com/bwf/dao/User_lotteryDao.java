package com.bwf.dao;

import java.sql.Connection;
import java.util.List;

import com.bwf.bean.User_lottery;

public interface User_lotteryDao extends BaseDao<User_lottery>{

	List<String> getByUid(int id, Connection conn)throws Exception;
	int getBySelectnumAndUid(String selectNum, int uid, Connection conn)throws Exception;


}

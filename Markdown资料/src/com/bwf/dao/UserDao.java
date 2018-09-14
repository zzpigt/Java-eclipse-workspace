package com.bwf.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.bwf.bean.User;

public interface UserDao extends BaseDao<User> {
	User queryByUname(Connection conn, String uname) throws SQLException;

	User queryByUnameAndUpwd(Connection conn, String uname, String upwd) throws SQLException;

	void updateMoneyById(Connection conn, Integer id, double money) throws SQLException;
	
}

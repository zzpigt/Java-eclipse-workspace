package com.bwf.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.bwf.bean.User;

public interface UserDao extends BaseDao<User>{

	User getByName(String uName, Connection conn)throws SQLException;

	User getByNameAndPwd(String uName, String uPwd, Connection conn)throws SQLException;

}

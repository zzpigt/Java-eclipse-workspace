package com.bwf.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bwf.bean.User;

public interface UserDao extends BaseDao<User>{

	User getByName(String uName, Connection conn)throws SQLException;

	User getByNameAndPwd(String uName, String uPwd, Connection conn)throws SQLException;

	List<String> SortBuyerById(Connection conn)throws SQLException;

	List<String> SortBuyerByMoney(Connection conn) throws SQLException;

	void updateMoneyById(Integer id, Double addMoney, Connection conn) throws SQLException;

	void updateStateByName(String name, Connection conn)throws SQLException;

}

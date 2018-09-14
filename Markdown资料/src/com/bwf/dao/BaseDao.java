package com.bwf.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T> {

	void insert(Connection conn, T t) throws SQLException;
	
	void delete(Connection conn, int id) throws SQLException;
	
	void update(Connection conn, T t) throws SQLException;
	
	T queryById(Connection conn, int id) throws SQLException;
	
	List<T> queryAll(Connection conn) throws SQLException;
	
	int getCount(Connection conn) throws SQLException;
	
}

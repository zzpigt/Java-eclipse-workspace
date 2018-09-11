package cn.zzpigt.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T> {
	
	void insert(T t, Connection conn) throws SQLException;
	
	void delete(int id,Connection conn) throws SQLException;
	
	void update(T t,Connection conn) throws SQLException;
	
	T queryById(int id,Connection conn) throws SQLException;
	
	List<T> queryAll(Connection conn) throws SQLException;
	
	int getCount(Connection conn) throws SQLException;
	
	
}

package cn.zzpigt.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.zzpigt.bean.Record;

public interface RecordDao {

	// 增
	void insert(Record r, Connection conn) throws SQLException;

	// 删
	void delete(int id, Connection conn) throws SQLException;


	// 查
	List<Record> queryAll(Connection conn) throws SQLException;

	// 查
	Record queryById(int id, Connection conn) throws SQLException;

	// 查
	int getCount(Connection conn) throws SQLException;

}

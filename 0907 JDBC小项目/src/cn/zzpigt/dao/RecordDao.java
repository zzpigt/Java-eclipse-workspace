package cn.zzpigt.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.zzpigt.bean.Record;

public interface RecordDao {

	// ��
	void insert(Record r, Connection conn) throws SQLException;

	// ɾ
	void delete(int id, Connection conn) throws SQLException;


	// ��
	List<Record> queryAll(Connection conn) throws SQLException;

	// ��
	Record queryById(int id, Connection conn) throws SQLException;

	// ��
	int getCount(Connection conn) throws SQLException;

}

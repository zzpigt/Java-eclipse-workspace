package com.bwf.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bwf.bean.Record;

public interface RecordDao extends BaseDao<Record> {

	public List<Record> queryByUid(Connection conn, int uid) throws SQLException;
	
}

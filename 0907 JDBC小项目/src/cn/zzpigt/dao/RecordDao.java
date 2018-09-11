package cn.zzpigt.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.zzpigt.bean.Record;

public interface RecordDao  extends BaseDao<Record>{
	
	List<Record> queryByUid(int uid,Connection conn) throws SQLException;

}

package cn.zzpigt.service;

import java.sql.Connection;
import java.util.List;

import cn.zzpigt.bean.Record;
import cn.zzpigt.bean.Users;

public interface RecordService {
	
	void saveLog(Record r,Connection conn) throws Exception;
	
	List<Record> getMyLog(Users me,Connection conn) throws Exception;
	

}

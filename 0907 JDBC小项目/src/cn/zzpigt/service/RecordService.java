package cn.zzpigt.service;

import java.sql.Connection;
import java.util.List;

import cn.zzpigt.bean.Record;
import cn.zzpigt.bean.Users;
import cn.zzpigt.dao.UsersDao;

public interface RecordService {
	
	
	List<Record> getMyLog(Users me,Connection conn) throws Exception;
	

}

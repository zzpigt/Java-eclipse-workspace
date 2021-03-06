package cn.zzpigt.service.impl;

import java.sql.Connection;
import java.util.List;

import cn.zzpigt.bean.Record;
import cn.zzpigt.bean.Users;
import cn.zzpigt.dao.RecordDao;
import cn.zzpigt.service.RecordService;

public class RecordServiceImpl implements RecordService{
	
	private static RecordDao rd;
	

	public static void setRd(RecordDao rd) {
		RecordServiceImpl.rd = rd;
	}


	@Override
	public List<Record> getMyLog(Users me, Connection conn) throws Exception {
		try {
			List<Record> rs = rd.queryByUid(me.getId(), conn);
			return rs;
		} catch (Exception e) {
			throw e;
		}
	}

}

package cn.zzpigt.view;

import java.sql.SQLException;
import java.util.List;

import cn.zzpigt.bean.Record;
import cn.zzpigt.bean.Users;
import cn.zzpigt.dao.RecordDao;
import cn.zzpigt.dao.UsersDao;
import cn.zzpigt.dao.impl.RecordDaoImpl;
import cn.zzpigt.dao.impl.UsersDaoImpl;

public class Test {
	public static void main(String[] args) {
		UsersDao u = new UsersDaoImpl();
		RecordDao r = new RecordDaoImpl();
		
		try {
//			t.insert(new Users(null,"tong","tong",500.0), ConnectionFactory.getConnection());
			u.update(new Users(11,"tong","fuckyou444",555.0), ConnectionFactory.getConnection());
			
//			u.delete(12, ConnectionFactory.getConnection());
//			System.out.println(u.queryById(11, ConnectionFactory.getConnection()));
//			System.out.println(r.queryById(21, ConnectionFactory.getConnection()));
//			
//			List<Record> list = r.queryAll(ConnectionFactory.getConnection());
//			for (Record record : list) {
//				System.out.println(record);
//			}
			
			int count= u.getCount(ConnectionFactory.getConnection());
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

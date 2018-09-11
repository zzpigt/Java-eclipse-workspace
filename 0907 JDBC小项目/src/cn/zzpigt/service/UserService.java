package cn.zzpigt.service;

import cn.zzpigt.bean.Users;

public interface UserService {
	
	void register(String name,String pwd) throws Exception;
	
	Users loginer(String name,String pwd) throws Exception;

	void saveMoney(Users me, double money) throws Exception;

	void drawMoney(Users me, double money) throws Exception;

	void transfer(Users me,String name, double money) throws Exception;

	Users getMyMoney(Users me) throws Exception;
	
	


}

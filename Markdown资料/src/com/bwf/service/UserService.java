package com.bwf.service;

import java.util.List;

import com.bwf.bean.Record;
import com.bwf.bean.User;

public interface UserService {

	void regist(String uname, String upwd) throws Exception;

	User login(String uname, String upwd) throws Exception;

	void saveMoney(User me, double money) throws Exception;

	List<Record> getRecordList(User me) throws Exception;

	void drawMoney(User me, double money) throws Exception;

	void tranMoney(User me, int target, double money) throws Exception;
	
}

package cn.zzpigt.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.zzpigt.bean.Users;

public interface UsersDao extends BaseDao<Users>{

	
	Users queryByUname(String uname, Connection conn) throws SQLException; 
	
	Users queryByNameAndPwd(String name, String pwd, Connection conn) throws SQLException;

	//根据姓名查找相同名字的用户，就是该用户是否存在
	boolean isSameName (String name,Connection conn) throws SQLException;

	//登入是否成功
	boolean isSuccessLogin(String name,String pwd,Connection conn) throws SQLException;

	void updateMoneyByName(String name, double money, Connection conn) throws SQLException;

}

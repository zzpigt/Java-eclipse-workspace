package cn.zzpigt.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.zzpigt.bean.Users;

public interface UsersDao {

	// 增
	void insert(Users u, Connection conn) throws SQLException;

	// 删
	void delete(int id, Connection conn) throws SQLException;

	// 改
	void updata(Users u, Connection conn) throws SQLException;

	// 查
	List<Users> queryAll(Connection conn) throws SQLException;

	// 查
	Users queryById(int id, Connection conn) throws SQLException;
	
	//根据姓名查找相同名字的用户，就是该用户是否存在
	boolean isSameName (String name,Connection conn) throws SQLException;

	//登入是否成功
	boolean isSuccessLogin(String name,String pwd,Connection conn) throws SQLException;
	// 查
	int getCount(Connection conn) throws SQLException;

}

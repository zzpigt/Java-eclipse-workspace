package cn.zzpigt.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.zzpigt.bean.Users;

public interface UsersDao {

	// ��
	void insert(Users u, Connection conn) throws SQLException;

	// ɾ
	void delete(int id, Connection conn) throws SQLException;

	// ��
	void updata(Users u, Connection conn) throws SQLException;

	// ��
	List<Users> queryAll(Connection conn) throws SQLException;

	// ��
	Users queryById(int id, Connection conn) throws SQLException;
	
	//��������������ͬ���ֵ��û������Ǹ��û��Ƿ����
	boolean isSameName (String name,Connection conn) throws SQLException;

	//�����Ƿ�ɹ�
	boolean isSuccessLogin(String name,String pwd,Connection conn) throws SQLException;
	// ��
	int getCount(Connection conn) throws SQLException;

}

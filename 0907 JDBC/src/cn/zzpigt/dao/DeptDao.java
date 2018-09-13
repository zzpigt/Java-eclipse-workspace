package cn.zzpigt.dao;

import java.sql.Connection;
import java.util.List;

import cn.zzpigt.bean.Dept;

public interface DeptDao {

	//�� 
	void insert(Dept d);
	
	//ɾ 
	void delete(int id);
	
	//�� 
	void updata(Dept d);
	
	//�� 
	List<Dept> queryAll(Connection conn);
	
	//�� 
	Dept queryById(int id);
	
	//��
	int getCount();
	
	
}

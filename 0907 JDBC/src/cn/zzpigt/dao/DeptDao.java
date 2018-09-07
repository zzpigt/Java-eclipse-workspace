package cn.zzpigt.dao;

import java.util.List;

import cn.zzpigt.bean.Dept;

public interface DeptDao {

	//增 
	void insert(Dept d);
	
	//删 
	void delete(int id);
	
	//改 
	void updata(Dept d);
	
	//查 
	List<Dept> queryAll();
	
	//查 
	Dept queryById(int id);
	
	//查
	int getCount();
	
	
}

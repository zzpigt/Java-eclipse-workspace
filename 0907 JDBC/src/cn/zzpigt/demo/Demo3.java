package cn.zzpigt.demo;

import java.util.List;

import cn.zzpigt.bean.Dept;
import cn.zzpigt.dao.DeptDao;
import cn.zzpigt.dao.impl.DeptDaoImpl;

public class Demo3 {
	public static void main(String[] args) {
		
		DeptDao dd = new DeptDaoImpl();
		
//		List<Dept> queryAll = dd.queryAll();
//		for (int i = 0; i < queryAll.size(); i++) {
//			System.out.println(queryAll.get(i));
//		}
//		System.out.println(dd.queryById(70));
//		
//		System.out.println(dd.getCount());
		Dept dept = new Dept();
		dept.setDeptno(60);
		dept.setDname("fuck");
		dept.setLoc("bwf");
//		dd.insert(dept);
//		dd.delete(70);
		dd.updata(dept);
		
		
	}
}

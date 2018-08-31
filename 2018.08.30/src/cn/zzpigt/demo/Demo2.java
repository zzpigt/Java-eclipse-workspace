package cn.zzpigt.demo;

import cn.zzpigt.bean.Student;

public class Demo2 {
	public static void main(String[] args) {
		
		Class<?> c = Student.class;
		
		try {
			Object o1 = c.newInstance();
			Object o2 = c.newInstance();
			
			System.out.println(o1 == o2);
			
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

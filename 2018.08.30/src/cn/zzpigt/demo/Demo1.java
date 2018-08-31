package cn.zzpigt.demo;

import cn.zzpigt.bean.Student;

public class Demo1 {
	public static void main(String[] args) throws ClassNotFoundException {
		Student t = new Student();
		
		//通过类的对象拿到类对象
		Class<?> c1 = t.getClass();
		System.out.println(c1);
		
		//通过这个类来拿到这个类对象
		Class<?> c2 = Student.class;
		System.out.println(c2);
		
		//通过类的全名来拿到类对象 
		Class<?> c3 = Class.forName("cn.zzpigt.bean.Student");
		System.out.println(c3);
		
		
	}
}

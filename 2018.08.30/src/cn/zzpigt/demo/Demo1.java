package cn.zzpigt.demo;

import cn.zzpigt.bean.Student;

public class Demo1 {
	public static void main(String[] args) throws ClassNotFoundException {
		Student t = new Student();
		
		//ͨ����Ķ����õ������
		Class<?> c1 = t.getClass();
		System.out.println(c1);
		
		//ͨ����������õ���������
		Class<?> c2 = Student.class;
		System.out.println(c2);
		
		//ͨ�����ȫ�����õ������ 
		Class<?> c3 = Class.forName("cn.zzpigt.bean.Student");
		System.out.println(c3);
		
		
	}
}

package cn.zzpigt.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import cn.zzpigt.bean.Student;

public class Demo6 {
	public static void main(String[] args) throws Exception{
		
		Class<?> c = Student.class;
		
		Field[] fields = c.getFields();//公开的，包括继承过来的公开的
		Field[] declaredFields = c.getDeclaredFields();//本类中的所有属性

		
		for (int i = 0; i < fields.length; i++) {
			System.out.println(Modifier.toString(fields[i].getModifiers())+" "
							+fields[i].getType().getSimpleName()+ " "
							+fields[i].getName());
		}
		
		Student s = new Student();
		
		Class<?> c1 = s.getClass();
		
		Field f_age = c1.getField("age");
		Field f_name = c1.getDeclaredField("name");
		f_name.setAccessible(true);
		f_name.set(s, "sb");
		
		f_age.set(s, 25);
		
		System.out.println(s.age);
		System.out.println(s.getName());
		
		System.out.println(f_name.get(s));
		
		//给父类中的私有属性赋值
		//所以，子类是继承了父类中的私有属性的，只是不能用
		Field f_id = c1.getSuperclass().getDeclaredField("ID");
		f_id.setAccessible(true);
		f_id.set(s, 1);
		System.out.println(f_id.get(s));
		
	}
}

package cn.zzpigt.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import cn.zzpigt.bean.Student;

public class Demo4 {
	public static void main(String[] args) {
		
		Class<?> c = Student.class;
		
		try {
			Constructor<?> con1 = c.getDeclaredConstructor(int.class);
			Object o1 = con1.newInstance(5);
			System.out.println(o1);
			
			Constructor<?> con2 = c.getDeclaredConstructor(int.class,String.class);
			con2.setAccessible(true);
			Object o2 = con2.newInstance(16,"tjw");
			System.out.println(o2);
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

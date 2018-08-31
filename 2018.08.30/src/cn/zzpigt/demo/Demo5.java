package cn.zzpigt.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo5 {
	public static void main(String[] args) {

		Class<?> c = Single.class;

		try {
			Constructor<?> con = c.getDeclaredConstructor();
			con.setAccessible(true);
			con.newInstance();
			con.newInstance();
			con.newInstance();

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

class Single {

	private static Single instance = new Single();


	private Single() {
			System.out.println("ππ‘Ï£°");
	}


	public static Single getInstance() {
		return instance;
	}

}

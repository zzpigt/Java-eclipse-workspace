package cn.zzpigt.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import cn.zzpigt.bean.Student;

public class Demo3 {
	public static void main(String[] args) {
		Class<?> c = Student.class;
		
		Constructor<?>[] cons = c.getConstructors();
		Constructor<?>[] cons2 = c.getDeclaredConstructors();
		
		for (Constructor<?> con : cons2) {
			String modifier = Modifier.toString(con.getModifiers());
			System.out.print(modifier+" ");
			
			String name = con.getName().substring(con.getName().lastIndexOf(".")+1);
			System.out.print(name+" (");
			
			Class<?>[] types = con.getParameterTypes();
			for (int i = 0; i < types.length; i++) {
				String simpleName = types[i].getSimpleName();
				System.out.print(simpleName+", ");
			}
			
			System.out.println(")");
		}
		
	}
}

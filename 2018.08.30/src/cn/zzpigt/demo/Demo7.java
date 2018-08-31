package cn.zzpigt.demo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import cn.zzpigt.bean.Student;

public class Demo7 {
	public static void main(String[] args) throws Exception{
		Student s = new Student();
		Class<?> c = s.getClass();
		
		Method m2 = c.getMethod("talk");
		m2.invoke(s);
		
		Method m_add = c.getDeclaredMethod("add", new Class[] {int.class, int.class});
		m_add.setAccessible(true);
		m_add.invoke(s, 3, 5);
		
		
		Method m_mul = c.getMethod("mul", int.class,int.class);
		int num1 = (int) m_mul.invoke(s, 3,5);
		System.out.println(num1);
		
		Method[] methods = c.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			System.out.print(Modifier.toString(method.getModifiers())+ " " 
					+ method.getReturnType().getSimpleName()+" "
					+method.getName()+" (");
			Class<?>[] types = method.getParameterTypes();
			for (int j = 0; j < types.length; j++) {
				System.out.print(types[j].getSimpleName());
				if(j < types.length-1) {
					System.out.print(", ");
				}
			}
			
			
			System.out.println(" )");
		}
		
	}
}

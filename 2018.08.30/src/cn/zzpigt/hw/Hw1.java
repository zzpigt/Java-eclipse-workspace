package cn.zzpigt.hw;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import cn.zzpigt.bean.Student;

public class Hw1 {

	public static void main(String[] args) throws Exception {
		
		Student stu = new Student();
		Class<?> c = stu.getClass();
		
		
		
		Method[] methods = c.getDeclaredMethods();//静态的也拿出来了
		
		Method m_hw1 = c.getMethod("hw1");
		m_hw1.invoke(stu);
		
		Method[] m2 = c.getMethods();
		for (int i = 0; i < m2.length; i++) {
			Method method = m2[i];
			System.out.print(Modifier.toString(method.getModifiers()) + " "
					+method.getReturnType().getSimpleName()+" "
					+method.getName()+" (");
			Class<?>[] types = method.getParameterTypes();
			for (int j = 0; j < types.length; j++) {
				System.out.print(types[j].getSimpleName());
				if(j<types.length-1) {
					System.out.print(", ");
				}
			}
			
			
			System.out.println(" )");
		}
		
		Method m_phw1 = c.getDeclaredMethod("phw1", int.class);
		m_phw1.setAccessible(true);
		m_phw1.invoke(stu, 1);
	}
	
}

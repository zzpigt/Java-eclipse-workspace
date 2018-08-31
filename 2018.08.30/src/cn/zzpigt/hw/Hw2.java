package cn.zzpigt.hw;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import cn.zzpigt.bean.StudentTest;

public class Hw2 {
	public static void main(String[] args) {

		makeJavaFile(new StudentTest());

	}

	public static void makeJavaFile(Object obj) {
		Class<?> clazz = obj.getClass();
		// 包
		System.out.println("package " + clazz.getPackage().getName());
		System.out.println();

		System.out.println(
				new StringBuilder("class ").append(clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1))
						.append(" extends ").append(clazz.getSuperclass().getSimpleName()).append(" {"));
		// 成员属性
		Field[] s_fields = clazz.getDeclaredFields();
		for (int i = 0; i < s_fields.length; i++) {
			Field field = s_fields[i];
			System.out.println("\t" + Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName()
					+ " " + field.getName() + ";");
		}
		System.out.println();
		// 构造器
//		Constructor<?>[] s_cons = clazz.getDeclaredConstructors();
//		for (int i = 0; i < s_cons.length; i++) {
//			Constructor<?> con = s_cons[i];
//			System.out.print("\t"+Modifier.toString(con.getModifiers())+" "
//					+con.getName().substring(con.getName().lastIndexOf(".")+1)+" (");
//			Class<?>[] types = con.getParameterTypes();
//			for (int j = 0; j < types.length; j++) {
//				Class<?> type = types[j];
//				System.out.print(type.getSimpleName());
//				if(j<types.length-1) {
//					System.out.print(", ");
//				}
//			}
//			System.out.println(") {");
//			System.out.println();
//			System.out.println("\t}");
//			System.out.println();
//		}

		// 成员方法
		Method[] s_methods = clazz.getDeclaredMethods();
		for (int i = 0; i < s_methods.length; i++) {
			Method method = s_methods[i];
			String nstr = method.getName().substring(3).toLowerCase();
			System.out.print("\t" + Modifier.toString(method.getModifiers()) + " "
					+ method.getReturnType().getSimpleName() + " " + method.getName() + " (");

			Class<?>[] types = method.getParameterTypes();

			for (int j = 0; j < types.length; j++) {
				Class<?> type = types[j];
				System.out.print(type.getSimpleName() + " " + nstr);
				if (j < types.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.println(") {");
			if (types.length != 0) {
				// set
				System.out.println("\t\tthis." + nstr + " = " + nstr + ";");
			} else {
				// get
				System.out.println("\t\treturn "+nstr+";");
			}
			System.out.println("\t}");
		}

		System.out.println("}");

	}
}

package cn.zzpigt.hw;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Field;

import cn.zzpigt.bean.Dog;
import cn.zzpigt.bean.StudentTest;

public class Hw3 {
	static StudentTest stu = new StudentTest("张三", 25, new Dog("mike", 2));

	public static void main(String[] args) throws Exception {

		String xml = toXML(stu);
		System.out.println(xml);
		BufferedWriter bw = new BufferedWriter(new FileWriter("student.xml"));
		bw.write(xml);
		bw.flush();
		bw.close();

	}

	public static String toXML(Object obj) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

		String str = getXmlStr(obj);
		sb.append(str);
		return sb.toString();
	}

	private static String getXmlStr(Object obj) throws Exception {
		StringBuilder sb = new StringBuilder();
		Class<?> clazz = obj.getClass();
		String name = clazz.getSimpleName();
		sb.append("<").append(name).append(">");
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			// 判断field是不是类
			if (fields[i].getType().getSimpleName().equals("Dog")) {
				sb.append(getXmlStr(fields[i].get(stu)));

			} else {

				String fieldName = fields[i].getName();
				sb.append("<").append(fieldName).append(">");
				Field s_field = clazz.getDeclaredField(fieldName);
				s_field.setAccessible(true);
				Object field_value = s_field.get(obj);
				sb.append(new String(field_value.toString().getBytes("UTF-8")));
				sb.append("</").append(fieldName).append(">");
			}
		}

		sb.append("</").append(name).append(">");

		return sb.toString();
	}
}

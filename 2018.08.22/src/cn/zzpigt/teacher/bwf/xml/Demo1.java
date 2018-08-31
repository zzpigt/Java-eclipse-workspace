package com.bwf.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.bwf.bean.Student;

public class Demo1 {

	public static void main(String[] args) throws IOException {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, "张飞", 19, 178.5));
		list.add(new Student(2, "关羽", 20, 200.1));
		list.add(new Student(3, "刘备", 21, 160.9));
		list.add(new Student(4, "黄忠", 59, 175.3));
		list.add(new Student(5, "赵云", 17, 180.1));
		
		String xml = toXML(list);
		System.out.println(xml);
		writeToFile(new String(xml.getBytes("UTF-8")));
	}

	private static void writeToFile(String xml) throws IOException {
		Writer w = new FileWriter("stu.xml");
		w.write(xml);
		w.flush();
		w.close();
	}

	/**
	 * 把学生列表变成XML字符串
	 * @param list
	 * @return
	 */
	private static String toXML(List<Student> list) {
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<stulist>");
		for (Student s : list) {
			sb.append(toXML(s));
		}
		sb.append("</stulist>");
		return sb.toString();
	}

	private static String toXML(Student s) {
		StringBuilder sb = new StringBuilder();
		// <student id="1">
		sb.append("<student id=\"").append(s.getId()).append("\">");
		// <name>张飞</name>
		sb.append("<name>").append(s.getName()).append("</name>");
		// <age>18</age>
		sb.append("<age>").append(s.getAge()).append("</age>");
		// <height>178.5</height>
		sb.append("<height>").append(s.getHeight()).append("</height>");
		// </student>
		sb.append("</student>");
		return sb.toString();
	}
	
	
	
}

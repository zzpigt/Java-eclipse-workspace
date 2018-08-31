package com.bwf.a_savefile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.bwf.bean.Student;

public class Demo1 {

	public static void main(String[] args) throws IOException {

		// Student stu = new Student(1, "张飞", 19, 178.5);
		// 保存到 stu.txt 中
		// save(stu);

//		Student load = load();
//		System.out.println(load);

		
//		List<Student> list = new ArrayList<>();
//		list.add(new Student(1, "张飞", 19, 178.5));
//		list.add(new Student(2, "关羽", 20, 200.1));
//		list.add(new Student(3, "刘备", 21, 160.9));
//		list.add(new Student(4, "黄忠", 59, 175.3));
//		list.add(new Student(5, "赵云", 17, 180.1));
//		
//		saveList(list);
		
		List<Student> list = loadList();
		for (Student student : list) {
			System.out.println(student);
		}
		
		
	}

	/**
	 * 保存学生列表
	 * @param list
	 * @throws IOException 
	 */
	public static void saveList(List<Student> list) throws IOException {
		Writer w = new FileWriter("student.txt");
		
		for (Student stu : list) {
			w.write(String.valueOf(stu.getId()));
			w.write(",");
			w.write(stu.getName());
			w.write(",");
			w.write(String.valueOf(stu.getAge()));
			w.write(",");
			w.write(String.valueOf(stu.getHeight()));
			w.write("\r\n");
		}

		w.flush();
		w.close();
		
	}
	
	
	public static List<Student> loadList() throws IOException{
		List<Student> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader("student.txt"));
		String line = null;
		while((line = br.readLine()) != null) {
			// 1, 张飞, 19, 178.5
			if(line.length() > 0) {
				String[] split = line.split(",");
				int id = Integer.parseInt(split[0]);
				String name = split[1];
				int age = Integer.parseInt(split[2]);
				double height = Double.parseDouble(split[3]);
				list.add(new Student(id, name, age, height));
			}
		}
		return list;
	}
	

	// 1, 张飞, 19, 178.5
	public static void save(Student stu) throws IOException {
		Writer w = new FileWriter("student.txt");
		w.write(String.valueOf(stu.getId()));
		w.write(",");
		w.write(stu.getName());
		w.write(",");
		w.write(String.valueOf(stu.getAge()));
		w.write(",");
		w.write(String.valueOf(stu.getHeight()));
		w.flush();
		w.close();

	}

	public static Student load() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("student.txt"));
		String line = br.readLine();
		// 1,张飞,19,178.5
		String[] split = line.split(",");

		int id = Integer.parseInt(split[0]);
		String name = split[1];
		int age = Integer.parseInt(split[2]);
		double height = Double.parseDouble(split[3]);

		return new Student(id, name, age, height);
	}

}

package com.bwf.a_savefile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.bwf.bean.Student;

public class Demo2 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
//		Student stu = new Student(1, "张飞", 19, 178.5);
//		save(stu);
//		Student load = load();
//		System.out.println(load);
		
//		List<Student> list = new ArrayList<>();
//		list.add(new Student(1, "张飞", 19, 178.5));
//		list.add(new Student(2, "关羽", 20, 200.1));
//		list.add(new Student(3, "刘备", 21, 160.9));
//		list.add(new Student(4, "黄忠", 59, 175.3));
//		list.add(new Student(5, "赵云", 17, 180.1));
//		saveList(list);
		
		List<Student> list = loadList();
		for (Student student : list) {
			System.out.println(student);
		}
		
	}
	
	private static void saveList(List<Student> list) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("stu.bin")));
		oos.writeObject(list);
		oos.flush();
		oos.close();
	}
	
	
	
	private static List<Student> loadList() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("stu.bin")));
		List<Student> list = (List<Student>) ois.readObject();
		ois.close();
		return list;
	}
	

	// 序列化
	public static void save(Student stu) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("stu.bin")));
		oos.writeObject(stu);
		oos.flush();
		oos.close();
	}
	
	// 反序列化
	public static Student load() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("stu.bin")));
		Student stu = (Student) ois.readObject();
		ois.close();
		return stu;
	}
	
}

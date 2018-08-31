package cn.zzpigt.demo;

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

import cn.zzpigt.bean.Student;

public class Demo3 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		
		list.add(new Student(1, "tjw1", 12, 170));
		list.add(new Student(2, "tjw2", 15, 171.2));
		list.add(new Student(3, "tjw3", 17, 173));
		list.add(new Student(4, "tjw4", 19, 172));
		list.add(new Student(5, "tjw5", 12, 178));
		
		try {
			saveList(list);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			save(stu);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		try {
//			Student stu = getStu();
//			System.out.println(stu);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		
		
	}
	
	
	//–Ú¡–ªØ
	
	public static void saveList(List<Student> list) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("sut.bin")));
		oos.writeObject(list);
		oos.flush();
		oos.close();
	}
	
	
	public static List<Student> getStuList() throws FileNotFoundException, IOException, ClassNotFoundException{
		List<Student> list = new ArrayList<>();
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("sut.bin")));
		Student stu = (Student) ois.readObject();
		return list;
	}
	
	public static void save(Student stu) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("sut.bin")));
		oos.writeObject(stu);
		oos.flush();
		oos.close();
		
	}
	public static Student getStu() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("sut.bin")));
		Student stu = (Student) ois.readObject();
		return stu;
	}
}

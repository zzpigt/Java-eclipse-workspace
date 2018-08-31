package cn.zzpigt.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import cn.zzpigt.bean.Student;

public class Demo1 {
	public static void main(String[] args) {
//		Student stu = new Student(1,"tongjinwen",25,172.2);
//		try {
//			save(stu);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
			System.out.println(getStu());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void save(Student stu) throws IOException {
		BufferedWriter w = new BufferedWriter(new FileWriter("student.txt"));
		w.write(String.valueOf(stu.getID()));
		w.write(",");
		w.write(stu.getName());
		w.write(",");
		w.write(String.valueOf(stu.getAge()));
		w.write(",");
		w.write(String.valueOf(stu.getHeight()));
		w.flush();
		w.close();
	}
	
	public static Student getStu() throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("student.txt"));
		String stu = r.readLine();
		String[] s_stu = stu.split(",");
		int ID = Integer.parseInt(s_stu[0]);
		String name =s_stu[1];
		int age = Integer.parseInt(s_stu[2]);
		double height = Double.parseDouble(s_stu[3]);
		
		return new Student(ID, name, age, height);
	}
}

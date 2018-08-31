package cn.zzpigt.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.zzpigt.bean.Student;

public class Demo2 {
	public static void main(String[] args) {
//		List<Student> list = new ArrayList<>();
//		
//		list.add(new Student(1, "tjw1", 12, 170));
//		list.add(new Student(2, "tjw2", 15, 171.2));
//		list.add(new Student(3, "tjw3", 17, 173));
//		list.add(new Student(4, "tjw4", 19, 172));
//		list.add(new Student(5, "tjw5", 12, 178));
//		
//		
//		try {
//			saveList(list);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
			List<Student> stuList = getStuList();
			for (Student stu : stuList) {
				System.out.println(stu);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void saveList(List<Student> list) throws IOException {
		
		BufferedWriter w = new BufferedWriter(new FileWriter("student2.txt"));
		for (Student stu : list) {
			w.write(String.valueOf(stu.getID()));
			w.write(",");
			w.write(stu.getName());
			w.write(",");
			w.write(String.valueOf(stu.getAge()));
			w.write(",");
			w.write(String.valueOf(stu.getHeight()));
			w.newLine();
		}
		w.flush();
		w.close();
	}
	
	public static List<Student> getStuList() throws IOException{
		List<Student> list =  new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader("student2.txt"));
		String line = null;
		while((line = br.readLine()) != null) {
			if(line.length()>0) {
				String[] stu = line.split(",");
				int ID = Integer.parseInt(stu[0]);
				String name =stu[1];
				int age = Integer.parseInt(stu[2]);
				double height = Double.parseDouble(stu[3]);
				list.add(new Student(ID, name, age, height));
			}
		}
		
		
		return list;
	}
}

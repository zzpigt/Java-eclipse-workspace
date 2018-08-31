package com.bwf.json;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.bwf.bean.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Demo2 {

	public static void main(String[] args) {
		
		Student s1 = new Student(1, "张飞", 19, 178.5);
		Gson gson = new Gson();
		// json格式化
		String json1 = gson.toJson(s1);
		System.out.println(json1);
		// json解析
		Student stu = gson.fromJson(json1, Student.class);
		System.out.println(stu);
		
		
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, "张飞", 19, 178.5));
		list.add(new Student(2, "关羽", 20, 200.1));
		list.add(new Student(3, "刘备", 21, 160.9));
		list.add(new Student(4, "黄忠", 59, 175.3));
		list.add(new Student(5, "赵云", 17, 180.1));
		
		String json2 = gson.toJson(list);
		System.out.println(json2);
		
		Type type = new TypeToken<List<Student>>() {}.getType();
		List<Student> list2 = gson.fromJson(json2, type);
		for (Student student : list2) {
			System.out.println(student);
		}
		
		
		
		
	}
	
}

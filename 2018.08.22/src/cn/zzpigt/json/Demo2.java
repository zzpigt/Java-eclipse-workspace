package cn.zzpigt.json;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import cn.zzpigt.bean.Student;
import com.google.gson.reflect.TypeToken;

public class Demo2 {
	public static void main(String[] args) {
		Student s = new Student(1, "童", 12, 170);
		//json格式化
		String json = new Gson().toJson(s);
		System.out.println(json);
		
		//json 解析
		Gson gson = new Gson();
		Student fromJson = gson.fromJson(json, Student.class);
		System.out.println(fromJson);
		
		
		//list json格式化
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, "张飞", 19, 178.5));
		list.add(new Student(2, "关羽", 20, 200.1));
		list.add(new Student(3, "刘备", 21, 160.9));
		list.add(new Student(4, "黄忠", 59, 175.3));
		list.add(new Student(5, "赵云", 17, 180.1));
		
		String json2 = gson.toJson(list);
		System.out.println(json2);
		
		//list json解析
		
		Type type = new TypeToken<List<Student>>() {}.getType();
		List<Student> stuList = gson.fromJson(json2, type);
		for (Student stu : stuList) {
			System.out.println(stu);
		}
	}
}

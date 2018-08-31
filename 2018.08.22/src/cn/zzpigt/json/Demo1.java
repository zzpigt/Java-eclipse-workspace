package cn.zzpigt.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cn.zzpigt.bean.Student;

public class Demo1 {
	public static void main(String[] args) {
		// Student s = new Student(1, "童", 12, 170);
		// String json = new Gson().toJson(s);
		// System.out.println(json);

		// List<Student> list = new ArrayList<>();
		//
		// list.add(new Student(1, "童", 12, 170));
		// list.add(new Student(2, "tjw2", 15, 171.2));
		// list.add(new Student(3, "tjw3", 17, 173));
		// list.add(new Student(4, "tjw4", 19, 172));
		// list.add(new Student(5, "tjw5", 12, 178));
		//
		// save(list);
		List<Student> list = parse();
		for (Student s : list) {
			System.out.println(s);
		}

	}

	public static void save(List<Student> list) {
		String json = new Gson().toJson(list);
		Writer w = null;
		try {
			w = new FileWriter("student.json");
			w.write(json);
			w.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (w != null) {
				try {
					w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// json 解析

	public static List<Student> parse() {
		List<Student> list = new ArrayList<>();
		// 获得json的解析器
		JsonParser parse = new JsonParser();
		// 获得文件的输入流
		try {
			Reader r = new FileReader("student.json");
			JsonArray arrayJson = (JsonArray) parse.parse(r);
			for (int i = 0; i < arrayJson.size(); i++) {
				Student stu = new Student();
				JsonObject stuJson = (JsonObject) arrayJson.get(i);
				stu.setID(stuJson.get("ID").getAsInt());
				stu.setAge(stuJson.get("age").getAsInt());
				stu.setHeight(stuJson.get("height").getAsDouble());
				stu.setName(stuJson.get("name").getAsString());
				list.add(stu);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return list;
	}

}

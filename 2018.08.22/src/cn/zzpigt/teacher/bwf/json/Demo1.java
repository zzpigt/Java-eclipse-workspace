package com.bwf.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.bwf.bean.Student;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Demo1 {

	public static void main(String[] args) throws IOException {
		
		
//		Student s1 = new Student(1, "�ŷ�", 19, 178.5);
//		// ת��json�ַ���
//		String json = new Gson().toJson(s1);
//		System.out.println(json);
		
//		List<Student> list = new ArrayList<>();
//		list.add(new Student(1, "�ŷ�", 19, 178.5));
//		list.add(new Student(2, "����", 20, 200.1));
//		list.add(new Student(3, "����", 21, 160.9));
//		list.add(new Student(4, "����", 59, 175.3));
//		list.add(new Student(5, "����", 17, 180.1));
//		
//		
//		String json = new Gson().toJson(list);
//		System.out.println(json);
//		writeToFile(json);
		
		
		List<Student> list = parse();
		for (Student student : list) {
			System.out.println(student);
		}
		
	}
	
	
	
	public static List<Student> parse() throws FileNotFoundException{
		List<Student> list = new ArrayList<>();
		// ���json�Ľ�����
		JsonParser parser = new JsonParser();
		// ����ļ���������
		Reader r = new FileReader("stu.json");
		// ���������黹�Ƕ���
		JsonArray array = (JsonArray) parser.parse(r);
		
		for(int i = 0; i < array.size(); i ++) {
			// ��������е�ÿһ��Ԫ��(ע�� �����黹�Ƕ���)
			JsonObject object = (JsonObject) array.get(i);
			
			Student stu = new Student();
			stu.setId(object.get("id").getAsInt());
			stu.setName(object.get("name").getAsString());
			stu.setHeight(object.get("height").getAsDouble());
			stu.setAge(object.get("age").getAsInt());
			list.add(stu);
		}
		
		return list;
	}
	
	
	
	private static void writeToFile(String s) throws IOException {
		Writer w = new FileWriter("stu.json");
		w.write(s);
		w.flush();
		w.close();
	}
	
}

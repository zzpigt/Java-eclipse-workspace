package cn.zzpigt.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import cn.zzpigt.bean.Student;

public class Demo1 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();

		list.add(new Student(1, "ͯ", 12, 170));
		list.add(new Student(2, "tjw2", 15, 171.2));
		list.add(new Student(3, "tjw3", 17, 173));
		list.add(new Student(4, "tjw4", 19, 172));
		list.add(new Student(5, "tjw5", 12, 178));

		savexml(list);

	}

	public static void savexml(List<Student> list) {
		OutputStreamWriter bos = null;

		try {
			bos = new OutputStreamWriter(new FileOutputStream("student.xml"), "UTF-8");
			bos.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			bos.write("<stulist>");
			for (Student stu : list) {

				bos.write("<student id=\"" + stu.getID() + "\">");
				bos.write("<name>" + stu.getName() + "</name>");
				bos.write("<age>" + stu.getAge() + "</age>");
				bos.write("<height>" + stu.getHeight() + "</height>");
				bos.write("</student>");
			}
			bos.write("</stulist>");
			bos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (bos != null) {
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

package cn.zzpigt.parseFormat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Serialization {

	public static void main(String[] args) {
		// serialization
//		List<Student> list = new ArrayList<>();
//
//		list.add(new Student(1, "����", 23, 160.6));
//		list.add(new Student(2, "�ŷ�", 20, 179.4));
//		list.add(new Student(3, "����", 22, 200.2));
//		list.add(new Student(4, "����", 23, 189.7));
//
//		save(list);
		List<Student> list = parse();
		for (Student s : list) {
			System.out.println(s);
		}
	}

	// ���л�
	private static void save(List<Student> list) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("student.tmp"));
			oos.writeObject(list);
			oos.flush();
			System.out.println("serialization���л��ɹ�����");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// �����л�
	private static List<Student> parse() {
		List<Student> list = new ArrayList<>();
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("student.tmp"));
			list = (List<Student>)ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return list;
	}

}

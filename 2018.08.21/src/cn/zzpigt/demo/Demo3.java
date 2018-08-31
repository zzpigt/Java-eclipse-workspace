package cn.zzpigt.demo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.WrappedPlainView;

public class Demo3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Student> list = new ArrayList<>();
		
		System.out.println("请输入5个学生姓名和成绩：");
		for(int i=0;i<5;i++) {
			System.out.println("第"+i+"个学生：");
			String  name = sc.next();
			double score = sc.nextDouble();
			
			list.add(new Student(name,score));
		}
		
		Collections.sort(list);
		
		File  file = new File("student.txt");
		Writer w = null;
		
		try {
			w = new FileWriter(file);
			for (Student stu : list) {
				w.write(stu.getName()+"--"+stu.getScore()+"\r\n");
			}
			System.out.println("写入完毕！！");
			w.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(w != null) {
				try {
					w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	
		
	}
}

class Student implements Comparable<Student>{
	
	public String name;
	public double score;
	
	
	
	public Student(String name, double score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		return true;
	}
	@Override
	public int compareTo(Student o) {
		if(this.getScore()>o.getScore()) {
			return 1;
		}else if(this.getScore()<o.getScore()) {
			return -1;
		}else {
			return 0;
		}
	}
	
	
	
	
	
	
}


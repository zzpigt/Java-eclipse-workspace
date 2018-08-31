package com.zzpigt.homework;

import java.lang.reflect.Array;

public class TestArray {
	public static void main(String[] args) {
		Student[] arr = new Student[2];
		
//		int numInt = Array.getInt(arr, 4);
		Array.set(arr, 0, new Student("tongjinwen"));
		Array.set(arr, 1, new Student("zzpigt"));
		Object Obj = Array.get(arr, 0);
		
//		System.out.println(numInt);
		System.out.println(Obj);
	}
}

class Student{
	
	public String name;

	public Student(String name) {
		super();
		this.name = name;
	}
	
	
	
}

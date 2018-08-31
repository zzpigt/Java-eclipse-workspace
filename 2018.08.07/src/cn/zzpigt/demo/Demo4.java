package cn.zzpigt.demo;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Demo4 {
	public static void main(String[] args) {
		//输入一个字符串，统计里面的各个字符出现的次数
		/*Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入一串字符：");
		String str = sc.next();
		
		do {
			String s = str.substring(0,1); 
			int length1 = str.length();
			str = str.replace(s, "");
			int length2 = str.length();
			System.out.print(s+(length1-length2));
			
		}while(str.length()>0);
		*/
		
		
		//基本类型转换
		String str = "123";
		int in = Integer.parseInt(str);
		System.out.println(in);
		
		
		int i = 123;
		
		String s = String.valueOf(i);
		System.out.println(s);
		
		
	}
}

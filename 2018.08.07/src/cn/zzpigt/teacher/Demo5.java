package cn.zzpigt.teacher;

import java.util.Scanner;

public class Demo5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一串字符串");
		
		// 不能带空格
//		String s1 = sc.next();
//		String s2 = sc.next();
//		String s3 = sc.next();
		
//		System.out.println("输入的内容为：" + s1);
//		System.out.println("输入的内容为：" + s2);
//		System.out.println("输入的内容为：" + s3);
		
		
		// 带空格，一句完整的话
		String line = sc.nextLine();
		System.out.println("输入的内容为：" + line);
		
		
	}
	
}

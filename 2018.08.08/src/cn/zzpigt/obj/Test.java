package cn.zzpigt.obj;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		//输入一个字符串，统计字符串中大写字母的数量
		//
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入字符串：");
		String str = sc.next();
		int count = 0;
		char[] cArr = str.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			if(cArr[i]>='A'&&cArr[i]<='Z') {
				count++;
			}
		}
		System.out.println("数量为："+count);
		
		//byte加法运算
		byte b1 = 3;
		byte b2 = 4;
//		byte b3 = b1+b2; 编译出错，这样是通不过的
		byte b3 = (byte) (b1+b2);
		System.out.println(b3);
		
	}
}

package cn.zzpigt.demo;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		char[] cArr= str.toCharArray();
		boolean isHui = true;
		for (int i = 0, j = cArr.length-1; i < j; i++, j--) {
			if(cArr[i] != cArr[j]) {
				isHui = false;
				break;
			}
		}
		
		if(isHui) {
			System.out.println("是的");
		}else {
			System.out.println("不是");
		}
		
	}
}

package cn.zzpigt.Demo;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		do {
			String son = str.substring(0,1);
			int num = getSonOfStr(str, son);
			str = str.replace(son, "");
			System.out.println(son+"的个数为："+num);
		}while(str.length()>0);
	}
	
	public static int getSonOfStr(String str ,String son) {
		if(son == null && son.length() == 0) {
			return 0;
		}
		int length1 = str.length();
		int length2 = str.replace(son, "").length();
		return (length1 - length2)/son.length();
	}
}

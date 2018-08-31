package cn.zzpigt.hw;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("«Î ‰»Î£∫");
		String str  =  sc.next();
//		StringBuilder nstr = new StringBuilder();
//		char[] cArr = str.toCharArray();
//		for(int i=0;i<str.length();i++) {
//			if(cArr[i] == '.') {
//				nstr.append(cArr[i]);
//				nstr.append(cArr[i+1]);
//				nstr.append(cArr[i+2]);
//				break;
//			}
//			nstr.append(cArr[i]);
//		}
//		System.out.println(nstr);
		
		System.out.println(str.substring(0,str.indexOf(".")+3));
	}
}

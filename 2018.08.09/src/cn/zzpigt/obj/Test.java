package cn.zzpigt.obj;

import java.util.Calendar;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("�������ַ�����");
//		String str = sc.next();
//		StringBuilder newStr = new StringBuilder();
//		char[] cArr = str.toCharArray();
//		for (int i = 0; i < cArr.length; i++) {
//			if (cArr[i] >= 'A' && cArr[i] <= 'Z') {
//				cArr[i] = (char) (cArr[i] + 32);
//			} else if (cArr[i] >= 'a' && cArr[i] <= 'z') {
//				cArr[i] = (char) (cArr[i] - 32);
//			} else {
//				cArr[i] = cArr[i];
//			}
//			newStr.append(cArr[i]);
//		}
//		System.out.println(newStr);
//		
		
		//
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		int dayMax = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		
		for (int i = 0; i < dayOfWeek-1; i++) {
			System.out.print("\t");
		}
		System.out.print(1+"\t");
		for (int i = 2; i <= dayMax; i++) {
			if(c.get(Calendar.DAY_OF_WEEK) == 7) {
				System.out.println();
			}
			c.set(Calendar.DAY_OF_MONTH, i);
			System.out.print(i+"\t");
		}
	}
}

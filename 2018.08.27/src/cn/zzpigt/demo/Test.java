package cn.zzpigt.demo;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		// 输入一串字符串，统计大写，小写，数字，其它
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入：");
		String str = sc.next();
		int countUp = 0;
		int countLow = 0;
		int countNum = 0;
		int countOth = 0;

		char[] cArr = str.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			if (cArr[i] >= 'A' && cArr[i] <= 'Z') {
				countUp++;
			} else if (cArr[i] >= 'a' && cArr[i] <= 'z') {
				countLow++;
			} else if (cArr[i] >= '0' && cArr[i] <= '9') {
				countNum++;
			} else {
				countOth++;
			}
		}

		System.out.println("大写：" + countUp + " 小写：" + countLow + " 数字：" + countNum + " 其它：" + countOth);

	}
}

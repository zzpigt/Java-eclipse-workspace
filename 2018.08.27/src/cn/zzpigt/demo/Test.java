package cn.zzpigt.demo;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		// ����һ���ַ�����ͳ�ƴ�д��Сд�����֣�����
		Scanner sc = new Scanner(System.in);
		System.out.println("�����룺");
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

		System.out.println("��д��" + countUp + " Сд��" + countLow + " ���֣�" + countNum + " ������" + countOth);

	}
}

package cn.zzpigt.obj;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		//����һ���ַ�����ͳ���ַ����д�д��ĸ������
		//
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�������ַ�����");
		String str = sc.next();
		int count = 0;
		char[] cArr = str.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			if(cArr[i]>='A'&&cArr[i]<='Z') {
				count++;
			}
		}
		System.out.println("����Ϊ��"+count);
		
		//byte�ӷ�����
		byte b1 = 3;
		byte b2 = 4;
//		byte b3 = b1+b2; �������������ͨ������
		byte b3 = (byte) (b1+b2);
		System.out.println(b3);
		
	}
}

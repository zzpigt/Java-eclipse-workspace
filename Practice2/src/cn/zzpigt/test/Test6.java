package cn.zzpigt.test;

import java.util.Scanner;

public class Test6 {
	/**
	 * 1. ����������һ������ʱ�����������󣬳���ᱨ��
 ����ϣ��дһ���������û�����һ����������������������
 ����û�������󣬾��ظ����û����룬ֱ��������ȷΪֹ
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isRight = false;
		System.out.println("������һ������");
		do {
			try {
				int num = sc.nextInt();
				System.out.println(num);
				isRight = true;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("����������������룺");
			}
		}while(!isRight);
	}
}

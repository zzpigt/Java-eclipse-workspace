package cn.zzpigt.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//sc�д洢�����ݣ�nextҪȡ������������������
		boolean isRight = false;
		do {
			System.out.println("������һ��������");
			try {
				int input = sc.nextInt();
				isRight = true;
				System.out.println("������ˣ�" + input);
			} catch (InputMismatchException e) {
				System.out.println("������󣡣�");
				sc.next();
				isRight = false;
			} catch (Exception e) {
				isRight = false;
			}

		} while (!isRight);
		//
		// a();

	}

	// public static void a() {
	// Scanner sc = new Scanner(System.in);
	// for (int i = 0; i < 7; i++) {
	// int num = sc.nextInt();
	// System.out.println(num);
	// }
	// }
}

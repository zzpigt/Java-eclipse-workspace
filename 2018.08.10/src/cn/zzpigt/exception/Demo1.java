package cn.zzpigt.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//sc中存储着数据，next要取出来，才能重新输入
		boolean isRight = false;
		do {
			System.out.println("请输入一个整数：");
			try {
				int input = sc.nextInt();
				isRight = true;
				System.out.println("输入对了：" + input);
			} catch (InputMismatchException e) {
				System.out.println("输入错误！！");
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

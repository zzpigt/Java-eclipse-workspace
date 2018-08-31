package cn.zzpigt.test;

import java.util.Scanner;

public class Test6 {
	/**
	 * 1. 当我们输入一个整数时，如果输入错误，程序会报错
 现在希望写一个程序，让用户输入一个整数，并把这个整数输出
 如果用户输入错误，就重复让用户输入，直到输入正确为止
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isRight = false;
		System.out.println("请输入一个数：");
		do {
			try {
				int num = sc.nextInt();
				System.out.println(num);
				isRight = true;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("输入错误，请重新输入：");
			}
		}while(!isRight);
	}
}

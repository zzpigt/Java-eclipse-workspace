package com.bwf.ide;

import java.util.Scanner;

public class Demo1 {
	// 输入两个数，计算它们的和
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入两个数");

		int a = sc.nextInt();
		int b = sc.nextInt();

		int res = a + b;
		System.out.println("和为：" + res);

	}
}

package cn.zzpigt.demo;

import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入一个数，分解质因数：");
		int num = sc.nextInt();
		do {
			for (int i = 2; i <= num; i++) {
				if(num%i == 0) {
					System.out.println(i);
					num /= i;
					break;
				}
			}
			
		}while(num > 1);
		
	}
}

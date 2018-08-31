package cn.zzpigt.demo;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num =Math.abs(sc.nextInt());
		int sum = 0;
		do {
			sum +=num%10;
			num = num/10;
		}while(num > 0);
		System.out.println(sum);
	}
}

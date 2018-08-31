package cn.zzpigt.test;

import java.util.Scanner;

public class Test4 {
	////输入一个数，计算他的各位数字之和
	////定义一个长度为10 的数组，给内部元素赋值｛1，2，4，8，16.....｝
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("请输入一个数：");
//		
//		int inputNum = sc.nextInt();
//		int num = 0;
//		int sum = 0;
//		do {
//			
//			num = inputNum%10;
//			sum += num;
//			inputNum /=10;
//			
//		}while(inputNum > 0 );
//		
//		System.out.println("各位数字之和:"+sum);
		
		int[] num = new int[10];
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) Math.pow(2,i); 
			System.out.println(num[i]);
		}
//		
		
	}
	
}

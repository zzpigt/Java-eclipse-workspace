package cn.zzpigt.test;

import java.util.Scanner;

public class Test4 {
	////����һ�������������ĸ�λ����֮��
	////����һ������Ϊ10 �����飬���ڲ�Ԫ�ظ�ֵ��1��2��4��8��16.....��
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("������һ������");
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
//		System.out.println("��λ����֮��:"+sum);
		
		int[] num = new int[10];
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) Math.pow(2,i); 
			System.out.println(num[i]);
		}
//		
		
	}
	
}

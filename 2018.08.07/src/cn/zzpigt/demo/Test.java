package cn.zzpigt.demo;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		//输入十个数，逆序后输出
		int[] arr = new int[10];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arr.length/2; i++) {
			//0 1 2 3 4 5 6 7 8 9
			int temp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = temp;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}

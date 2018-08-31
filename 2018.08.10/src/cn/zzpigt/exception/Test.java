package cn.zzpigt.exception;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		//
		Scanner sc = new Scanner(System.in);
		System.out.println("ÇëÊäÈë10¸öÊı£º");
		int[] inputNum = new int[10];
		for (int i = 0; i < inputNum.length; i++) {
			inputNum[i] = sc.nextInt();
		}
		for (int i = 0; i < inputNum.length-1; i++) {
			for (int j = 0; j < inputNum.length-1-i; j++) {
				if(inputNum[j]<inputNum[j+1]) {
					int temp = inputNum[j];
					inputNum[j] = inputNum[j+1];
					inputNum[j+1] = temp;
				}
			}
		}
		for (int i = 0; i < inputNum.length; i++) {
			System.out.print(inputNum[i]+"   ");
		}
	}
}

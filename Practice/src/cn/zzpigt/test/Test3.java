package cn.zzpigt.test;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		//һЩ��������ķ���������ð��
		Scanner sc = new Scanner(System.in);
		int[] numArr = new int[10];
		System.out.println("������10������");
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = sc.nextInt();
		}
		
		//�����Сֵ
		int max = numArr[0];
		int min = numArr[0];
		for (int i = 0; i < numArr.length; i++) {
			if(numArr[i]>max) {
				max = numArr[i];
			}
			if(numArr[i]<min) {
				min = numArr[i];
			}
		}
		System.out.println("���ֵ��"+max);
		System.out.println("��Сֵ��"+min);
		
		//ð��
		
		for (int i = 0; i < numArr.length-1; i++) {
			for (int j = 0; j < numArr.length-1-i; j++) {
				if(numArr[j]>numArr[j+1]) {
					int temp = numArr[j];
					numArr[j] = numArr[j+1];
					numArr[j+1] = temp;
				}
			}
		}
		for(int i:numArr) {
			System.out.print(i+"  ");
		}
	}
}

package cn.zzpigt.game;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����10������ѡ������󣬴Ӵ�С���
		System.out.println("������10������");
		Scanner  sc = new Scanner(System.in);
		int[] arr = new int[10];
		for(int i=0;i<10;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("�Ӵ�С�����");
		int temp = 0;
		for(int i=0;i<10;i++) {
			for(int j =i+1;j<10;j++) {
				if(arr[i]<arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
		}
		for(int i=0;i<10;i++) {
			System.out.println(arr[i]);
		}
	}

}

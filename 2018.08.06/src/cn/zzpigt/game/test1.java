package cn.zzpigt.game;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//输入10个数，选择排序后，从大到小输出
		System.out.println("请输入10个数：");
		Scanner  sc = new Scanner(System.in);
		int[] arr = new int[10];
		for(int i=0;i<10;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("从大到小排序后：");
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

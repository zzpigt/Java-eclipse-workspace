package cn.zzpigt.test;

import java.util.Arrays;

public class Test8 {
	public static void main(String[] args) {
		int[] arr = {5,6,2,3,1,4,7,8,9};
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if(arr[j]<arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}

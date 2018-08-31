package cn.zzpigt.ArraySort;

public class ChoiceArray {
	public static void main(String[] args) {
		
		int[] arr = {36,455,4,975,155,165,554,555,415,5,478,564,645,65};
		
//		choice(arr);//选择排序
		bubbling(arr);
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  ");
		}
		
	}
	
	/**
	 * 首先知道选择排序的原理
	 * 选择排序就是每轮确定一个数，而这个数是从头开始确定的
	 * 确定的就是认为最大的，然后遍历数组进行比较，找出数组中的最大的数交换位置
	 * 缺点：就是每次找最大的数都要遍历一遍，这就很低效了
	 * @param arr
	 */
	public static void choice(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int maxNum = i;
			for(int j=i;j<arr.length;j++) {
				if(arr[j]>arr[maxNum]) {
					maxNum = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[maxNum];
			arr[maxNum] = temp;
		}
	}
	
	
	/**
	 * 也是要知道冒泡排序的原理
	 *比较相邻的两个数的大小，然后交换位置 
	 *
	 * @param arr
	 */
	public static void bubbling(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if(arr[j]<arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
}

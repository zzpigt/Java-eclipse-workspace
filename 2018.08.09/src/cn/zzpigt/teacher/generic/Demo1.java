package com.bwf.generic;

public class Demo1 {

	
	
	public static void main(String[] args) {
		
		String[] arr = {"a","b","c"};
		List<String> list = new ArrayList<>();
		
		copy(arr, list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
	}
	
	
	/**
	 * ���Ʒ���
	 * �������е�Ԫ�ظ��Ƶ�list��
	 * @param arr
	 * @param list
	 */
	public static <T> void copy(T[] arr, List<T> list) {
		
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		
	}
	
	
	
}

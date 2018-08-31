package cn.zzpigt.obj;

public class Demo1 {
	public static void main(String[] args) {
		String[] arr = {"a","b","c"};
		List<String> list = new AnyType<String>();
		for(int i=0;i<arr.length;i++) {
			
		}
		
	}
	
	
	/**
	 * ¸´ÖÆ·½·¨
	 * 
	 * @param arr
	 * @param list
	 */
	public static <T> void copy(T[] arr, List<T> list) {
		for(int i=0; i<arr.length; i++) {
			list.add(arr[i]);
		}
	}
	
	
}
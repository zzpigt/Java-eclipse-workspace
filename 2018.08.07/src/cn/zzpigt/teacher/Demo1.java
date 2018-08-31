package cn.zzpigt.teacher;

public class Demo1 {

	public static void main(String[] args) {
		
		// ÊµÀý»¯String
		
		String s1 = "abc";
		
		String s2 = new String("abc");
		
		System.out.println(s1);
		System.out.println(s2);
		
		// String(byte[] bytes) 
		byte[] bytes = {65,66,67};
		String s3 = new String(bytes,0, 3);
		System.out.println(s3);
		
		
		// String(char[] value) 
		char[] value = {'h','e','l','l','o'};
		String s4 = new String(value,2,3);
		System.out.println(s4);
		
		
	}
	
}

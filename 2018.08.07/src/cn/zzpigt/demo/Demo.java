package cn.zzpigt.demo;

public class Demo {
	public static void main(String[] args) {
		String s1 = "abc";
		
		String s2 = new String("abc");
		
		
		byte[] bytes = {65,66,67};
		String s3 = new String(bytes,0,3);
		
		
		char[] value = {'h','o','l','l','o'};
		String s4  = new String(value,0,5);
		
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		
		String a1 = "abasdfead";
		String a2 = "b";
		
		System.out.println(a1.substring(2));
		System.out.println(a1.substring(2,5));
		
		//字符串的比较，要用equals
		System.out.println(a1.equals(a2));
		System.out.println(s1.equals(s2));
		
		String a3 = "ABC";
		
		System.out.println(s1.equalsIgnoreCase(a3));
		
	}
}

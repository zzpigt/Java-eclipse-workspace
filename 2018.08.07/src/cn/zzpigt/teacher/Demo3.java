package cn.zzpigt.teacher;

public class Demo3 {

	public static void main(String[] args) {
		
		// 这是内容相等的4个字符串
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		String s4 = new String("abc");
		String s5 = "ABC";
		
		// 字符串内容比较不能使用 == 
		System.out.println(s1 == s2);	// true
		System.out.println(s2 == s3);	// false
		System.out.println(s3 == s4);	// false
		
		
		// equals 方法
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));
		System.out.println(s3.equals(s4));
		System.out.println(s4.equals(s5));
		
		// 不区分大小写验证
		System.out.println(s1.equalsIgnoreCase(s5));
		
	}
	
}

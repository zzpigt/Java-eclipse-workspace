package cn.zzpigt.teacher;

public class Demo2 {

	public static void main(String[] args) {
		
		String s1 = "abcdefghijk";
		String s2 = "b";
		// 用 + 运算符对两个字符串进行拼接
		String s3 = s1 + s2;
		
		System.out.println(s3);
		
		
		// 子串
		// 从第n位开始取，取到最后
		System.out.println(s1.substring(1));
		System.out.println(s1.substring(2, 5));
	}
	
}

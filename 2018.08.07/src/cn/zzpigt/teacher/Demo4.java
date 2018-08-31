package cn.zzpigt.teacher;

// 常量池保存数据的特点
public class Demo4 {

	public static void main(String[] args) {
		
//		String s1 = "ab";
//		String s2 = "ab";
//		String s3 = "a" + "b";
//		
//		System.out.println(s1 == s2);	// true
//		System.out.println(s2 == s3);	// true
		
		/*
		 * 首先要确定同一个字符串在常量池中只会有一份拷贝
		 * s1 必然和 s2 相等
		 * 而s3是由两个常量相加得到，常量的运算在编译时就已经决定结果
		 * 所以 s3就相当于 = "ab"
		 * 所以 s1 == s2 == s3
		 */
		
//		String s1 = "hello";
//		String s2 = new String("hello");
//		String s3 = "he" + new String("llo");
//		
//		System.out.println(s1 == s2);	// false
//		System.out.println(s1 == s3);	// false
		
		/*
		 * 由new创建的字符串保存在堆中
		 * "hello"常量保存在常量池中
		 * 所以s1 和 s2 是指向不同的空间，肯定不等
		 * 
		 * s3是由一个常量和变量相加而成，所以在不能在编译时确定地址
		 * 最终的结果肯定是在堆中，所以 s1 != s3
		 */
		
//		String a = "sfalse";
//		String b = "s" + false;
//		System.out.println(a == b);
		
		/*
		 * "s1"保存在常量池中，
		 * 而b = "s"+1 是两个常量的相加，在编译时就已经确定结果和地址
		 * 所以 a == b
		 * 
		 */
		
		
//		String s1 = "ab";
//		String s2 = "aab";
//		String s3 =  "a" + s1;
//		System.out.println(s2 == s3);
		
		/*
		 * 因为 s1 和 s2 都是变量
		 * s3 就是由一个 常量和变量相加得到，不能在编译时确定结果和地址
		 * 所以 s2 != s3
		 */
		
//		final String s1 = "ab";
//		String s2 = "aab";
//		String s3 =  "a" + s1;
//		System.out.println(s2 == s3);
		
		/*
		 * 用final修饰的s1 表示是一个常量
		 * 自定义的常量也保存在常量池中
		 * s3 是由一个字面值常量和一个自定义常量相加得到
		 * 在编译时就已经确定结果和地址
		 * 所以 s2 和 s3 是指向相同的空间
		 */
		
		
//		String s1 = "abc";
//		String s2 = getAbc();
//		System.out.println(s1 == s2);	// true
		
		
		
		String s1 = "abc";
		String s2 = getAbc2();
		System.out.println(s1 == s2);
		
	}

	private static String getAbc() {
		return "abc";
	}
	
	private static String getAbc2() {
		String s = new String("ab") + "c";
		return s;
	}
	
	
	
	
	
}

package cn.zzpigt.teacher;

import java.util.Arrays;

public class Demo9 {

	public static void main(String[] args) {
		
		// String的常用方法
		String s = "abcde";
		
		// 字符串长度
		System.out.println(s.length());
		// 指定位置的字符
		System.out.println(s.charAt(2));
		// 指定位置的字符串
		System.out.println(s.substring(2, 3));
		// 拼接
		System.out.println(s.concat("fg"));
		
		// 包含
		System.out.println("*******");
		System.out.println(s.contains("bcd"));
		System.out.println(s.startsWith("ab"));
		System.out.println(s.endsWith("e"));
		
		// 内容比较是否相等
		System.out.println(s.equals("abc"));
		System.out.println(s.equalsIgnoreCase("aBcDe"));
		
		// 变成数组(字符串其实就是字符数组，字符数组其实就是字节数组)
		char[] cArr = s.toCharArray();
		System.out.println(Arrays.toString(cArr));
		byte[] bArr = s.getBytes();
		System.out.println(Arrays.toString(bArr));
		
		// 索引
		String s2 = "abcabc";
		System.out.println(s2.indexOf("a"));
		System.out.println(s2.indexOf("b", 2));
		System.out.println(s2.indexOf("f"));
		
		System.out.println(s2.lastIndexOf("a"));
		System.out.println(s2.lastIndexOf("a", 2));
		
		
		// 替换
		String s3 = "aabbcc.ddaa";
		System.out.println(s3.replace(".", "z"));
		// 注意(暂时别去用)
		System.out.println(s3.replaceAll(".", "z"));
		
		
		// 变大小写
		String s4 = "abcABCdefDEF";
		System.out.println(s4.toUpperCase());
		System.out.println(s4.toLowerCase());
		
		
		// 去前后空格
		System.out.println("    AB    C  D     ".trim());
		
		
	}
	
}

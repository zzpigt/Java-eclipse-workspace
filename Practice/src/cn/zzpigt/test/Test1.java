package cn.zzpigt.test;

public class Test1 {
	public static void main(String[] args) {
		
		String str = "     fasdf  asdfasd HHHH asdsjjeLLL       ";
		
		System.out.println(str.trim());
		
		
		//操作字符串的一些方法
		System.out.println(str.replace(" ", ""));
		
		String str1 = str.replace(" ", "");
		//看看这个字符串的长度
		System.out.println(str1.length());
		
		//看看这个字符串中a的个数
		System.out.println(getSonOfStr(str1, "a"));
		
		//全部变成大写或小写
		System.out.println(str1.toUpperCase());
		System.out.println(str1.toLowerCase());
		
		//看看包含关系
		System.out.println(str1.contains("sdf"));
		
		
	}
	
	public static int getSonOfStr(String str,String son) {
		if(son == null && son.length()==0) {
			return 0;
		}
		
		int length1 = str.length();
		int length2 = str.replace(son, "").length();
		return (length1 - length2)/son.length();
	}
}

package cn.zzpigt.homework;

import java.util.Arrays;

public class Hw1 {
	public static void main(String[] args) {

		//		1. 用”Hello World”初始化一个字符串对象str1
		String str1 = new String("Hello World");

		//		2. 输出上述对象的长度
		System.out.println(str1.length());

		//		3. 输出str1中位置为4的字符
		System.out.println(str1.substring(4, 5));//这个返回的应该是字符串String
		System.out.println(str1.charAt(4));//这个返回的是字符

		//		4. 再用”hello world”初始化一个字符串对象str2
		String str2 = new String("hello world");
		
		//		5. 分别用equals和equalsIgnoreCase判断两个字符串是否相等
		System.out.println(str1.equals(str2));//false
		System.out.println(str1.equalsIgnoreCase(str2));//true

		//		6. 判断上述两个字符串是否以”hel”开头以”ld”结尾
		System.out.println(str1.startsWith("hel"));//false
		System.out.println(str2.startsWith("hel"));//true
		System.out.println(str1.endsWith("ld"));//true
		System.out.println(str2.endsWith("ld"));//true
		

		//		7. 判断这两个字符串的起始位置为1，长度为3这部分是否相等
		System.out.println("=================================");
		String s1 = str1.substring(1, 4);
		String s2 = str2.substring(1, 4);
//		System.out.println(s1);
		System.out.println(s1.equals(s2));
		
		//		8. 找出str1中”ll”的首次出现的位置和”o”最后一次出现的位置
		System.out.println(str1.indexOf("ll"));
		System.out.println(str1.lastIndexOf("o"));
		
		//		9. 统计str1中”l”的个数
		System.out.println("=================9================");
		String str9 = str1;
		int index = str9.indexOf("l");
//		System.out.println(index);
		String s9 = str9.substring(index,index+1);
		int length1 = str9.length();
		str9 = str9.replace(s9, "");
		int length2 = str9.length();
		System.out.println("str1中l的个数是："+(length1-length2));
		

		//		10. 在str2中从位置2开始到5结束截取该字符串的一个子串
		System.out.println("================10=================");
		String str10 = str2.substring(2,5);
		System.out.println(str10);
		

		//		11. 将str1中的”ll”替换成”oo”
		System.out.println("================11=================");
		System.out.println(str1.replace("ll", "oo"));

		//		12. 将str2转换成一个字节数组
		System.out.println("=================12================");
		byte[] bArr = str2.getBytes();
		System.out.println(Arrays.toString(bArr));

		//		13. 将str1转换成一个字符数组
		System.out.println("=================13================");
		char[] cArr = str1.toCharArray();
		System.out.println(Arrays.toString(cArr));

		//		14. 将str2全部转换成大写
		System.out.println("=================14================");
		System.out.println(str2.toUpperCase());
		

		//		15. 将”WahahaMsjijisaBBus”中原来的大写字母转换成小写，原来的小写字母转换成大写
		System.out.println("=================15================");
		/*
		 * 可以先转换成字符数组，判断大小写，大写，转换成小写，小写换成大写
		 * a-z -> 97-122
		 * A-Z -> 65-90
		 * a-A = 32
		 * */
		
		String str15 = "WahahaMsjijisaBBus";
		StringBuilder sb = new StringBuilder();
//		String newStr = "";
		byte[] bArr15 = str15.getBytes();
		System.out.println(Arrays.toString(bArr15));
		
		for (int i = 0; i < bArr15.length; i++) {
			if(bArr15[i]>=97 && bArr15[i]<=122) {
				bArr15[i] -= 32;
			}else if(bArr15[i]<=90 && bArr15[i]>=65) {
				bArr15[i] += 32;
			}
			sb.append((char)bArr15[i]);
		}
		System.out.println(Arrays.toString(bArr15));
		
		System.out.println(sb);
		

	}
}

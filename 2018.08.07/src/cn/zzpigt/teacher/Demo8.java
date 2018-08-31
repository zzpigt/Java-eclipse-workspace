package cn.zzpigt.teacher;

public class Demo8 {

	public static void main(String[] args) {
		
		// 1. 定义一个字符串变量s，在内部保存26个大写英文字母，并输出
		
//		String s = "";
//		String tmp = s;
//		for(char i = 'A'; i <= 'Z' ; i ++) {
//			s += i;
//		}
//		System.out.println(s == tmp);
		
		
		// 用 可变字符串改写
		StringBuilder sb = new StringBuilder();
		StringBuilder tmp = sb;
		
		for(char i = 'A'; i <= 'Z' ; i ++) {
			sb.append(i);
		}
		
		System.out.println(sb);
		
		
	}
	
}

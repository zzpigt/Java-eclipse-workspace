package cn.zzpigt.demo;

public class Demo3 {
	public static void main(String[] args) {
		//定一个字符串变量S,在内部保存26个大写字母，并输出
		//String s ;
		/*for (byte i = 65; i < 80; i++) {
			s += new String(i);
		}*/
		
		
		
		//可变字符串
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = sb;
		
		for(char i='A';i<='Z';i++) {
			sb.append(i);
		}
		
		System.out.println(sb);
		
	}
}

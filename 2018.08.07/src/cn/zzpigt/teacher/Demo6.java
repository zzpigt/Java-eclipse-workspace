package cn.zzpigt.teacher;

public class Demo6 {

	public static void main(String[] args) {
		
		// 空串
		String s1 = "";
		// null串
		String s2 = null;
		
		System.out.println(s2);
		
		// 如何判断空串
		System.out.println(s1.length() == 0);
		System.out.println(s1.equals(""));
		System.out.println("".equals(s1));	// 推荐
		
		// 如何判断null串
		System.out.println(s2 == null);
		
		
		// 如何判断一个字符串既不是空串，也不是null串
		System.out.println(s2 != null && s2.length() > 0);
		
	}
	
}

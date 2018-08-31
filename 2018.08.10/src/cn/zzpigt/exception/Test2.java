package cn.zzpigt.exception;

public class Test2 {
	public static void main(String[] args) {
		//定一个方法，返回某个字符串中某个子串出现的次数
		int a = test("java","a");
		System.out.println(a);
	}
	
	public static int test(String str,String strSon) {
		int count = 0;
		while(str.contains(strSon)) {
			count++;
			str = str.replace(strSon, "");
		}
		return count;
	}
}

package cn.zzpigt.test;

public class Test1 {
	public static void main(String[] args) {
		
		String str = "     fasdf  asdfasd HHHH asdsjjeLLL       ";
		
		System.out.println(str.trim());
		
		
		//�����ַ�����һЩ����
		System.out.println(str.replace(" ", ""));
		
		String str1 = str.replace(" ", "");
		//��������ַ����ĳ���
		System.out.println(str1.length());
		
		//��������ַ�����a�ĸ���
		System.out.println(getSonOfStr(str1, "a"));
		
		//ȫ����ɴ�д��Сд
		System.out.println(str1.toUpperCase());
		System.out.println(str1.toLowerCase());
		
		//����������ϵ
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

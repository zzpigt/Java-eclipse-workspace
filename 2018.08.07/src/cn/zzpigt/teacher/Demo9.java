package cn.zzpigt.teacher;

import java.util.Arrays;

public class Demo9 {

	public static void main(String[] args) {
		
		// String�ĳ��÷���
		String s = "abcde";
		
		// �ַ�������
		System.out.println(s.length());
		// ָ��λ�õ��ַ�
		System.out.println(s.charAt(2));
		// ָ��λ�õ��ַ���
		System.out.println(s.substring(2, 3));
		// ƴ��
		System.out.println(s.concat("fg"));
		
		// ����
		System.out.println("*******");
		System.out.println(s.contains("bcd"));
		System.out.println(s.startsWith("ab"));
		System.out.println(s.endsWith("e"));
		
		// ���ݱȽ��Ƿ����
		System.out.println(s.equals("abc"));
		System.out.println(s.equalsIgnoreCase("aBcDe"));
		
		// �������(�ַ�����ʵ�����ַ����飬�ַ�������ʵ�����ֽ�����)
		char[] cArr = s.toCharArray();
		System.out.println(Arrays.toString(cArr));
		byte[] bArr = s.getBytes();
		System.out.println(Arrays.toString(bArr));
		
		// ����
		String s2 = "abcabc";
		System.out.println(s2.indexOf("a"));
		System.out.println(s2.indexOf("b", 2));
		System.out.println(s2.indexOf("f"));
		
		System.out.println(s2.lastIndexOf("a"));
		System.out.println(s2.lastIndexOf("a", 2));
		
		
		// �滻
		String s3 = "aabbcc.ddaa";
		System.out.println(s3.replace(".", "z"));
		// ע��(��ʱ��ȥ��)
		System.out.println(s3.replaceAll(".", "z"));
		
		
		// ���Сд
		String s4 = "abcABCdefDEF";
		System.out.println(s4.toUpperCase());
		System.out.println(s4.toLowerCase());
		
		
		// ȥǰ��ո�
		System.out.println("    AB    C  D     ".trim());
		
		
	}
	
}

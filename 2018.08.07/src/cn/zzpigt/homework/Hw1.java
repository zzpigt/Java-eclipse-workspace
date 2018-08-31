package cn.zzpigt.homework;

import java.util.Arrays;

public class Hw1 {
	public static void main(String[] args) {

		//		1. �á�Hello World����ʼ��һ���ַ�������str1
		String str1 = new String("Hello World");

		//		2. �����������ĳ���
		System.out.println(str1.length());

		//		3. ���str1��λ��Ϊ4���ַ�
		System.out.println(str1.substring(4, 5));//������ص�Ӧ�����ַ���String
		System.out.println(str1.charAt(4));//������ص����ַ�

		//		4. ���á�hello world����ʼ��һ���ַ�������str2
		String str2 = new String("hello world");
		
		//		5. �ֱ���equals��equalsIgnoreCase�ж������ַ����Ƿ����
		System.out.println(str1.equals(str2));//false
		System.out.println(str1.equalsIgnoreCase(str2));//true

		//		6. �ж����������ַ����Ƿ��ԡ�hel����ͷ�ԡ�ld����β
		System.out.println(str1.startsWith("hel"));//false
		System.out.println(str2.startsWith("hel"));//true
		System.out.println(str1.endsWith("ld"));//true
		System.out.println(str2.endsWith("ld"));//true
		

		//		7. �ж��������ַ�������ʼλ��Ϊ1������Ϊ3�ⲿ���Ƿ����
		System.out.println("=================================");
		String s1 = str1.substring(1, 4);
		String s2 = str2.substring(1, 4);
//		System.out.println(s1);
		System.out.println(s1.equals(s2));
		
		//		8. �ҳ�str1�С�ll�����״γ��ֵ�λ�ú͡�o�����һ�γ��ֵ�λ��
		System.out.println(str1.indexOf("ll"));
		System.out.println(str1.lastIndexOf("o"));
		
		//		9. ͳ��str1�С�l���ĸ���
		System.out.println("=================9================");
		String str9 = str1;
		int index = str9.indexOf("l");
//		System.out.println(index);
		String s9 = str9.substring(index,index+1);
		int length1 = str9.length();
		str9 = str9.replace(s9, "");
		int length2 = str9.length();
		System.out.println("str1��l�ĸ����ǣ�"+(length1-length2));
		

		//		10. ��str2�д�λ��2��ʼ��5������ȡ���ַ�����һ���Ӵ�
		System.out.println("================10=================");
		String str10 = str2.substring(2,5);
		System.out.println(str10);
		

		//		11. ��str1�еġ�ll���滻�ɡ�oo��
		System.out.println("================11=================");
		System.out.println(str1.replace("ll", "oo"));

		//		12. ��str2ת����һ���ֽ�����
		System.out.println("=================12================");
		byte[] bArr = str2.getBytes();
		System.out.println(Arrays.toString(bArr));

		//		13. ��str1ת����һ���ַ�����
		System.out.println("=================13================");
		char[] cArr = str1.toCharArray();
		System.out.println(Arrays.toString(cArr));

		//		14. ��str2ȫ��ת���ɴ�д
		System.out.println("=================14================");
		System.out.println(str2.toUpperCase());
		

		//		15. ����WahahaMsjijisaBBus����ԭ���Ĵ�д��ĸת����Сд��ԭ����Сд��ĸת���ɴ�д
		System.out.println("=================15================");
		/*
		 * ������ת�����ַ����飬�жϴ�Сд����д��ת����Сд��Сд���ɴ�д
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

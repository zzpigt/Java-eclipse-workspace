package cn.zzpigt.test;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������ַ�����");
		
		String inputStr = sc.next();
		
		//��Сдת��
		System.out.println(getChangeStr(inputStr));
		
		//��������ַ�����һ���Ӵ��ĸ���
		
		System.out.println(getSonOfStr(inputStr,"as"));
		
	}
	
	public static StringBuilder getChangeStr(String str) {
		char[] cArr = str.toCharArray();
		StringBuilder nstr  = new StringBuilder();
		for (int i = 0; i < cArr.length; i++) {
			if(cArr[i]>='A' && cArr[i]<='Z') {
				nstr.append((char)(cArr[i]+32));
			}else if(cArr[i]>='a' && cArr[i]<='z') {
				nstr.append((char)(cArr[i]-32));
			}else {
				nstr.append(cArr[i]);
			}
		}
		return nstr;
	}
	
	public static int getSonOfStr(String str,String son) {
		if(son == null && son.length() == 0) {
			return 0;
		}
		int length1 = str.length();
		int length2 = str.replace(son, "").length();
		return (length1-length2)/son.length();
	}
}

package com.bwf.wrap;

import org.omg.CORBA.INTERNAL;

public class Demo3 {

	public static void main(String[] args) {
		
		// ��װ�������
		// 1. ��װ�����Ϊnull
		Integer i1 = null;
		int i2 = 0;
		
		// 2. ��װ����������
		System.out.println("int�����ֵ��" + Integer.MAX_VALUE);
		System.out.println("int����Сֵ��" + Integer.MIN_VALUE);
		
		// 3. ��װ���з���
		System.out.println(Integer.toHexString(100));
		System.out.println(Integer.toOctalString(100));
		System.out.println(Integer.toBinaryString(100));
		
		// 4. ��װ�໹���Ժ��ַ���ת��
		String str = "12345";
		int num = Integer.parseInt(str);
		System.out.println(num);
		
		
	}
	
}

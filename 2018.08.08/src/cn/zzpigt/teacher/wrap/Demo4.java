package com.bwf.wrap;

public class Demo4 {

	public static void main(String[] args) {
		// �Զ�װ��
		Integer i1 = 97;
		Integer i2 = 97;
		System.out.println(i1 == i2);	// true
		
		// �Զ�װ��
		Integer i3 = 297;
		Integer i4 = 297;
		System.out.println(i3 == i4);	// false
		
		// ����ʱ�������Զ�����
		System.out.println((i1 + 200) == (i2 + 200));	// true
		
		
	}
	
}

package cn.zzpigt.exception;

import javax.management.RuntimeErrorException;

public class Demo3 {
	public static void main(String[] args) {
		try {
			test1();
		} catch (Exception e) {
			System.out.println("catch���񲢴������쳣����");
		}
		
		
		test2();
		
		
		System.out.println("�����������У���");
	}
	
	public static void test1() throws Exception {
		//������ʵ���׳��ķ�����ʱ�쳣
		
		throw new Exception();
	}
	
	public static void test2() {
		//����ʱ�쳣���Բ��������������쳣�ǳ���Ա�߼����Ͻ�����
		throw new RuntimeException();
	}
	
}

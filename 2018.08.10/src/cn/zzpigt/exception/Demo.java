package cn.zzpigt.exception;

public class Demo {
	public static void main(String[] args) {
		
		
		test1();
		test2();
		test3();
		test4();
		
		
		
		
		
		
	}
	
	public static void test1() {
		//��ָ���쳣
//		int[] a = null;
		int[] a = new int[2];
		Object o = new Object();
		try {
			Integer i = (Integer)o;
			System.out.println(a.length);
			System.out.println(a[4]);
		}catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
			System.out.println("�쳣�����ˣ���");
		}catch(Exception e) {
			//�쳣���ڸ��ӹ�ϵ����ôҪд�ں���
			
			System.out.println("��֪��ʲô�쳣����");
		}
		System.out.println("�����������");
				
	}
	
	public static void test2() {
		//�����±�Խ���쳣
		int[] b = new int[3];
		int index = 6;
		if(index<b.length)
			System.out.println(b[5]);
	}
	
	public static void test3() {
		//ǿ������ת���쳣
		Object o = new Object();
		if(o instanceof Integer) {
			Integer i = (Integer)o;
		}
	}
	
	public static void test4() {
		//�����쳣
		int a = 5;
		int b = 0;
		if(b != 0)
			System.out.println(a/b);
	}
}

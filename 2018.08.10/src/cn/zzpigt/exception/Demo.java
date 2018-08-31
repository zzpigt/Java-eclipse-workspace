package cn.zzpigt.exception;

public class Demo {
	public static void main(String[] args) {
		
		
		test1();
		test2();
		test3();
		test4();
		
		
		
		
		
		
	}
	
	public static void test1() {
		//空指针异常
//		int[] a = null;
		int[] a = new int[2];
		Object o = new Object();
		try {
			Integer i = (Integer)o;
			System.out.println(a.length);
			System.out.println(a[4]);
		}catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
			System.out.println("异常处理了！！");
		}catch(Exception e) {
			//异常存在父子关系，那么要写在后面
			
			System.out.println("不知道什么异常！！");
		}
		System.out.println("程序结束！！");
				
	}
	
	public static void test2() {
		//数组下标越界异常
		int[] b = new int[3];
		int index = 6;
		if(index<b.length)
			System.out.println(b[5]);
	}
	
	public static void test3() {
		//强制类型转换异常
		Object o = new Object();
		if(o instanceof Integer) {
			Integer i = (Integer)o;
		}
	}
	
	public static void test4() {
		//算术异常
		int a = 5;
		int b = 0;
		if(b != 0)
			System.out.println(a/b);
	}
}

package cn.zzpigt.exception;

import javax.management.RuntimeErrorException;

public class Demo3 {
	public static void main(String[] args) {
		try {
			test1();
		} catch (Exception e) {
			System.out.println("catch捕获并处理了异常！！");
		}
		
		
		test2();
		
		
		System.out.println("程序正常运行！！");
	}
	
	public static void test1() throws Exception {
		//这里其实是抛出的非运行时异常
		
		throw new Exception();
	}
	
	public static void test2() {
		//运行时异常可以不用声明，这类异常是程序员逻辑不严谨产生
		throw new RuntimeException();
	}
	
}

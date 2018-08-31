package com.bwf.wrap;

import org.omg.CORBA.INTERNAL;

public class Demo3 {

	public static void main(String[] args) {
		
		// 包装类的作用
		// 1. 包装类可以为null
		Integer i1 = null;
		int i2 = 0;
		
		// 2. 包装类里有属性
		System.out.println("int的最大值：" + Integer.MAX_VALUE);
		System.out.println("int的最小值：" + Integer.MIN_VALUE);
		
		// 3. 包装类有方法
		System.out.println(Integer.toHexString(100));
		System.out.println(Integer.toOctalString(100));
		System.out.println(Integer.toBinaryString(100));
		
		// 4. 包装类还可以和字符串转换
		String str = "12345";
		int num = Integer.parseInt(str);
		System.out.println(num);
		
		
	}
	
}

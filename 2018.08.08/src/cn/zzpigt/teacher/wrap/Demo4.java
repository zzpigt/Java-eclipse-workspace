package com.bwf.wrap;

public class Demo4 {

	public static void main(String[] args) {
		// 自动装箱
		Integer i1 = 97;
		Integer i2 = 97;
		System.out.println(i1 == i2);	// true
		
		// 自动装箱
		Integer i3 = 297;
		Integer i4 = 297;
		System.out.println(i3 == i4);	// false
		
		// 运算时隐含了自动拆箱
		System.out.println((i1 + 200) == (i2 + 200));	// true
		
		
	}
	
}

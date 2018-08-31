package com.bwf.wrap;

public class Demo1 {

	public static void main(String[] args) {
		
		// 基本类型 -> 包装类型
		// 不推荐
		Integer integer1 = new Integer(123);
		// 推荐
		Integer integer2 = Integer.valueOf(123);
		
		// 包装类型 -> 基本类型
		int i1 = integer1.intValue();
		
		
	}
	
}

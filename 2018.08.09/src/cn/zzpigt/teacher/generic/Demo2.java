package com.bwf.generic;

public class Demo2 {

	public static void main(String[] args) {
		
		// 数组具有协变性
		// 如果B是A，那么B的数组也是A的数组
		A a = new B();
		A[] arr1 = new B[3];
		
		// 泛型不具备协变性
		List<A> list1 = new ArrayList<B>();
		
		// 通配符
		List<?> list2 = new ArrayList<ArrayList<B>>();
		
		// 下边界
		List<? super B> list3 = new ArrayList<A>();
		List<? super B> list4 = new ArrayList<B>();
		List<? super B> list5 = new ArrayList<C>();
		List<? super B> list6 = new ArrayList<D>();
		
		// 上边界
		List<? extends B> list7 = new ArrayList<A>();
		List<? extends B> list8 = new ArrayList<B>();
		List<? extends B> list9 = new ArrayList<C>();
		List<? extends B> list0 = new ArrayList<D>();
		
	}
	
	
	
}


class A{
	
	
}

class B extends A{
	
	
}

class C extends B{
	
	
}

class D extends C{
	
	
}

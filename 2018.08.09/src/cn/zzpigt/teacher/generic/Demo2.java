package com.bwf.generic;

public class Demo2 {

	public static void main(String[] args) {
		
		// �������Э����
		// ���B��A����ôB������Ҳ��A������
		A a = new B();
		A[] arr1 = new B[3];
		
		// ���Ͳ��߱�Э����
		List<A> list1 = new ArrayList<B>();
		
		// ͨ���
		List<?> list2 = new ArrayList<ArrayList<B>>();
		
		// �±߽�
		List<? super B> list3 = new ArrayList<A>();
		List<? super B> list4 = new ArrayList<B>();
		List<? super B> list5 = new ArrayList<C>();
		List<? super B> list6 = new ArrayList<D>();
		
		// �ϱ߽�
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

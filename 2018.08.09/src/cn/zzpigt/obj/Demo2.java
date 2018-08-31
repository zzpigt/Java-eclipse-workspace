package cn.zzpigt.obj;

public class Demo2 {
	public static void main(String[] args) {
		//数组具有协变性
		
		
		//通配符是为了泛型也具有协变性
		List<?> lst1 = new AnyType<B>();
	
		//上边界
		List<? super B> lst2 = new AnyType<A>();
		List<? super B> lst3 = new AnyType<B>();
//		List<? super B> lst4 = new AnyType<C>();
//		List<? super B> lst5 = new AnyType<D>();
		
		
	}
}

class A{}

class B extends A{}

class C extends B{}

class D extends C{}

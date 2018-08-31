package cn.zzpigt.demo;

public class Singleton {
	
	private static Singleton instance = null;
	
	
	//先把构造器私有，然后自己实例一个对象赋值为Null，写一个方法调用对象，判断是否为null，如果是就创建，不是就直接返回
	
	private Singleton() {
		System.out.println("构造了！！");
	}
	
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	
}

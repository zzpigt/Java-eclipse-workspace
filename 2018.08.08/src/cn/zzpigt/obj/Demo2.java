package cn.zzpigt.obj;

public class Demo2 {
	public static void main(String[] args) {
		Cat c = new Cat();
		c = null;
		
		//提醒一下Gc可以进行回收了
		//平常不建议进行这种重写，频繁的调用会大量消耗内存
		System.gc();
	}	
}

class Cat{
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("回收垃圾！！！");
	}
	
	
}
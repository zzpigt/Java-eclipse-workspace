package cn.zzpigt.teacher.obj;

public class Demo3 {

	public static void main(String[] args) {
		Cat c = new Cat();
		c = null;
		// 提醒一下GC可以回收了
		System.gc();
		
	}
	
}

class Cat{
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("啊 我被回收了！");
	}
	
}

package cn.zzpigt.tread;

public class Demo1 {
	public static void main(String[] args) {
		
		MyThread mt = new MyThread();
		mt.start();
		Thread main = Thread.currentThread();
		main.setName("sb");
		System.out.println(main.getName()+"��������");
		
	}
	
	private static class MyThread extends Thread{
		@Override
		public void run() {
			setName("���߳�");
			for (int i = 0; i < 10; i++) {
				System.out.println(getName()+i);
			}
		}
	}
}


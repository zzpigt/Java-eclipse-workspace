package cn.zzpigt.tread;

public class Demo4 {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mt.interrupt();
		System.out.println("中断子线程！！");
		
		
	}
	
	static class MyThread extends Thread{
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
				System.out.println("子线程："+i);
			}
		}
	}
}

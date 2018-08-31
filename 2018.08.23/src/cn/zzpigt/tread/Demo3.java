package cn.zzpigt.tread;

public class Demo3 {
	public static void main(String[] args) {
		new MyThread().start();
		
		for (int i = 0; i < 10; i++) {
			if(i == 5) {
				System.out.println("sb让一步----------------");
				Thread.yield();
			}
			System.out.println("sb"+i);
		}
		
		
		
	}
	static class MyThread extends Thread{
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("子线程："+i);
			}
		}
	}
}

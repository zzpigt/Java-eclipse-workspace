package cn.zzpigt.tread;

public class Demo6 {
	public static void main(String[] args) {
		
		Thread t = new MyThread();
		t.start();
		
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("计时结束！！");
		
		
	}
	static class MyThread extends Thread{
		@Override
		public void run() {
			for(int i=0;i<5;i++) {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("倒计时："+(5-i));
			}
		}
	}
}

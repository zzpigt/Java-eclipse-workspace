package cn.zzpigt.tread;

import cn.zzpigt.tread.Demo4.MyThread;

public class Demo5 {
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
			while(!interrupted()) {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
				System.out.println("子线程");
			}
		}
	}
}

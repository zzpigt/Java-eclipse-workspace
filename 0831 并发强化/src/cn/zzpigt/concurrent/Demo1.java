package cn.zzpigt.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo1 {
	public static void main(String[] args) {

		// 写个卖票的线程系统

		new ShopThread("上海").start();
		new ShopThread("深圳").start();
		new ShopThread("广州").start();
		new ShopThread("北京").start();

	}

	static class ShopThread extends Thread {

		private static int tacket = 100;
		private static Lock lock = new ReentrantLock();

		public ShopThread(String name) {
			super(name);
		}

		@Override
		public void run() {
			while (true) {

				try {
					lock.lock();					
					if (tacket > 0) {
						// 上锁
						try {
							sleep(50);
							tacket--;
							System.out.println(getName() + "卖出去1张票，剩余：" + tacket);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						break;
					}

				} finally {

					// 去锁
					lock.unlock();
				}
			}

		}

	}
}

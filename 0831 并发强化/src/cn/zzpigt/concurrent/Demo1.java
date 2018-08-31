package cn.zzpigt.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo1 {
	public static void main(String[] args) {

		// д����Ʊ���߳�ϵͳ

		new ShopThread("�Ϻ�").start();
		new ShopThread("����").start();
		new ShopThread("����").start();
		new ShopThread("����").start();

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
						// ����
						try {
							sleep(50);
							tacket--;
							System.out.println(getName() + "����ȥ1��Ʊ��ʣ�ࣺ" + tacket);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						break;
					}

				} finally {

					// ȥ��
					lock.unlock();
				}
			}

		}

	}
}

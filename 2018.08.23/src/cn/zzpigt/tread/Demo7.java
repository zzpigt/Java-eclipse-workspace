package cn.zzpigt.tread;

public class Demo7 {
	public static void main(String[] args) {
		
		Thread t1 = new MyThread("�Ϻ�");
		Thread t2 = new MyThread("����");
		Thread t3 = new MyThread("����");
		Thread t4 = new MyThread("����");
		Thread t5 = new MyThread("�㶫");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		
	}
	
	static class MyThread extends Thread{
		private static int tackit = 100;
		private static Object obj = new Object();
		
		
		public MyThread(String name) {
			super(name);
		}



		@Override
		public void run() {

			while(true) {
				synchronized (obj) {
					if(tackit > 0) {
						try {
							sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(getName()+"���� 1��Ʊ��ʣ�ࣺ"+(--tackit));
					}else {
						return;
					}
				}
			}
		}
	}
}

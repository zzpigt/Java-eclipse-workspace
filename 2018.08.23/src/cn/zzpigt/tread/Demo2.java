package cn.zzpigt.tread;

public class Demo2 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
}

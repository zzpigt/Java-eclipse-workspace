package cn.zzpigt.tread;

public class Demo8 {
	public static void main(String[] args) {
		
		new Thread(){
			@Override
			public void run() {
				Single.getInstance();
			}
		}.start();
		
		new Thread(){
			@Override
			public void run() {
				Single.getInstance();
			}
		}.start();
		
		Single.getInstance();
		
	}
	
	static class Single {
		private static Single instance = null;
		private Single() {
			System.out.println("ÀÁººÄ£Ê½");
		}
		
		public static Single getInstance() {
			if(instance == null) {
				synchronized (Single.class) {
					if(instance == null) {
						instance = new Single();
					}
				}
			}
			return instance;
		}
	}
}

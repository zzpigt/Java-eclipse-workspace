package cn.zzpigt.demo;

public abstract class GetTime {

	public void calTime() {
		long time1 = System.currentTimeMillis();
		code();
		long time2 = System.currentTimeMillis();
		System.out.println(time2 - time1+"ms");
		
	}

	public void code() {
		
	}
	
}

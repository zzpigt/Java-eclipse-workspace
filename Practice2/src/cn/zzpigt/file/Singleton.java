package cn.zzpigt.file;

public class Singleton {
	//����ģʽ
//	private static Singleton intance = null;
//	
//	private Singleton() {
//		
//	}
//	
//	public Singleton getIntance() {
//		intance = new Singleton();
//		return intance;
//	}
	
	//����ģʽ
	private static Singleton intance = new Singleton();
	
	private Singleton() {
		
	}
	
	public Singleton getIntance() {
		return intance;
	}
}

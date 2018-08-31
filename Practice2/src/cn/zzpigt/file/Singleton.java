package cn.zzpigt.file;

public class Singleton {
	//懒汉模式
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
	
	//饿汉模式
	private static Singleton intance = new Singleton();
	
	private Singleton() {
		
	}
	
	public Singleton getIntance() {
		return intance;
	}
}

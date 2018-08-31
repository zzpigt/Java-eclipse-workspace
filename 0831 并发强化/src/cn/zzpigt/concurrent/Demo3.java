package cn.zzpigt.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Demo3 {
	
	public static void main(String[] args) {
		
		MyCallable<String> myCallable = new MyCallable<>();
		try {
			FutureTask<java.lang.String> ft = new FutureTask<>(myCallable);
			
			new Thread(ft).start();
			
			Thread.sleep(1000);
			if(ft.isDone()) {
				System.out.println("子线程关闭了！！");
			}else {
				System.out.println("子线没有关闭！！");
			}
			
			String str = ft.get();
			System.out.println(str);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	static class MyCallable<String> implements Callable<String>{

		@Override
		public String call() throws Exception {

			Thread.sleep(5000);
			
			String str = (String) "fuck";
			
			return str;
		}
		
	}
	
	
}

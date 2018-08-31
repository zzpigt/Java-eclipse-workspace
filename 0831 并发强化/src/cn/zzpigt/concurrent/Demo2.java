package cn.zzpigt.concurrent;

import java.util.Timer;
import java.util.TimerTask;

public class Demo2 {
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("boom!!");
				
			}
		}, 2000, 1000);
		
	}
	
}

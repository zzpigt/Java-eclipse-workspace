package cn.zzpigt.hw;

import java.util.Random;
import java.util.Scanner;

public class Hw {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * 1. 随机生成一个加法表达式(10以内的) 让用户计算, 告诉用户是否答对 如果用户10秒内还没答出, 就打印 太慢了! 程序结束!
		 */
		Scanner sc = new Scanner(System.in);
		int num1 = new Random().nextInt(10);
		int num2 = new Random().nextInt(10);

		System.out.println(num1+ "+" + num2 +"= ?");
		//这里开启一个倒计时的线程
		new Thread() {
			{
				setDaemon(true);
			}
			public void run() {
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("太慢了！！");
				System.exit(0);
			}
		}.start();
		
		int ans = sc.nextInt();
		if(ans == num1+num2) {
			System.out.println("答对了！！");
		}else {
			System.out.println("答错了！！");
		}
		
		
	}

	static class MyThread extends Thread {
		@Override
		public void run() {
			
		}
	}
}

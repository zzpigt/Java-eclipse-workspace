package cn.zzpigt.hw;

import java.lang.Thread.State;
import java.util.Random;
import java.util.Scanner;

public class Hw1 {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * 1. 随机生成一个加法表达式(10以内的) 让用户计算, 告诉用户是否答对 如果用户10秒内还没答出, 就打印 太慢了! 程序结束!
		 */

		Thread t = new MyThread2();
		t.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		State state = t.getState();
		if ("RUNNABLE".equals(state.toString())) {
			sc.close();
			System.out.println("你太慢了！！！");
		} else {
			t.interrupt();
		}

	}

	static class MyThread2 extends Thread {
		@Override
		public void run() {
			int num1 = new Random().nextInt(10);
			int num2 = new Random().nextInt(10);
			System.out.println(num1 + "+" + num2 + "= ?  请输入答案：");

			if (!interrupted()) {
				int ans = sc.nextInt();
				if (ans == (num1 + num2)) {
					System.out.println("答对了！！！");
				} else {
					System.out.println("太蠢了！！！");
				}
			}
		}
	}

}

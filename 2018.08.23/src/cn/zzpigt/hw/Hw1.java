package cn.zzpigt.hw;

import java.lang.Thread.State;
import java.util.Random;
import java.util.Scanner;

public class Hw1 {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * 1. �������һ���ӷ����ʽ(10���ڵ�) ���û�����, �����û��Ƿ��� ����û�10���ڻ�û���, �ʹ�ӡ ̫����! �������!
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
			System.out.println("��̫���ˣ�����");
		} else {
			t.interrupt();
		}

	}

	static class MyThread2 extends Thread {
		@Override
		public void run() {
			int num1 = new Random().nextInt(10);
			int num2 = new Random().nextInt(10);
			System.out.println(num1 + "+" + num2 + "= ?  ������𰸣�");

			if (!interrupted()) {
				int ans = sc.nextInt();
				if (ans == (num1 + num2)) {
					System.out.println("����ˣ�����");
				} else {
					System.out.println("̫���ˣ�����");
				}
			}
		}
	}

}

package cn.zzpigt.hw;

import java.util.Random;
import java.util.Scanner;

public class Hw {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * 1. �������һ���ӷ����ʽ(10���ڵ�) ���û�����, �����û��Ƿ��� ����û�10���ڻ�û���, �ʹ�ӡ ̫����! �������!
		 */
		Scanner sc = new Scanner(System.in);
		int num1 = new Random().nextInt(10);
		int num2 = new Random().nextInt(10);

		System.out.println(num1+ "+" + num2 +"= ?");
		//���￪��һ������ʱ���߳�
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
				System.out.println("̫���ˣ���");
				System.exit(0);
			}
		}.start();
		
		int ans = sc.nextInt();
		if(ans == num1+num2) {
			System.out.println("����ˣ���");
		}else {
			System.out.println("����ˣ���");
		}
		
		
	}

	static class MyThread extends Thread {
		@Override
		public void run() {
			
		}
	}
}

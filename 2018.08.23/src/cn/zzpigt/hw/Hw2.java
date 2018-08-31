package cn.zzpigt.hw;

import java.util.Random;

public class Hw2 {
	public static void main(String[] args) {
		/**
		 * 
		 * ģ��������� �����ڹ������������, ͬʱ��ʼ�ܲ�, ����Ϊ1000�� �ڹ�ÿ���� 3-5֮�������� ������һ����Ϣ2��, ÿ����5-10֮��������
		 * ����֮�������̴߳�ӡ˭Ӯ��
		 * 
		 * 
		 */
		System.out.println("��ʼ�ܣ�---------------");
		Tortoise tor = new Tortoise();
		Rabbit rab = new Rabbit();
		
		tor.setRabbit(rab);
		rab.setTortoise(tor);
		
		tor.start();
		rab.start();
		
		try {
			tor.join();
			rab.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(tor.getRunDistance() > rab.getRunDistance()) {
			System.out.println("�ڹ�Ӯ�ˣ���");
		}else {
			System.out.println("����Ӯ�ˣ���");
		}
		
		System.out.println("��Ϸ��������");

	}

}

class Tortoise extends Thread {
	private  int runDistance = 0;

	private Rabbit rabbit;
	
	
	public void setRabbit(Rabbit rabbit) {
		this.rabbit = rabbit;
	}



	public int getRunDistance() {
		return runDistance;
	}



	@Override
	public void run() {
		
		while(!interrupted() && runDistance < 1000) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				System.out.println("�ڹ�˯���б�����ˣ���");
				return;
			}
			int dis = new Random().nextInt(3)+3;
			runDistance += dis;
			System.out.println("�ڹ��ܵ���"+runDistance);
		}
		rabbit.interrupt();

	}

}

class Rabbit extends Thread {
	private  int runDistance = 0;
	private Tortoise tortoise;
	
	

	public void setTortoise(Tortoise tortoise) {
		this.tortoise = tortoise;
	}



	public int getRunDistance() {
		return runDistance;
	}

	

	@Override
	public void run() {
		
		while(!interrupted() && runDistance < 1000) {
			try {
				sleep(200);
			} catch (InterruptedException e) {
				System.out.println("����˯���б���ϣ���");
				return;
			}
			int dis = new Random().nextInt(6)+5;
			runDistance += dis;
			System.out.println("�����ܵ���"+runDistance);
		}
		tortoise.interrupt();
		
	}

}
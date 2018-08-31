package cn.zzpigt.hw;

import java.util.Random;

public class Hw2 {
	public static void main(String[] args) {
		/**
		 * 
		 * 模拟龟兔赛跑 定义乌龟和兔子两个类, 同时开始跑步, 举例为1000米 乌龟每秒跑 3-5之间的随机数 兔子跑一次休息2秒, 每次跑5-10之间的随机数
		 * 跑完之后由主线程打印谁赢了
		 * 
		 * 
		 */
		System.out.println("开始跑：---------------");
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
			System.out.println("乌龟赢了！！");
		}else {
			System.out.println("兔子赢了！！");
		}
		
		System.out.println("游戏结束！！");

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
				System.out.println("乌龟睡眠中被打断了！！");
				return;
			}
			int dis = new Random().nextInt(3)+3;
			runDistance += dis;
			System.out.println("乌龟跑到了"+runDistance);
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
				System.out.println("兔子睡眠中被打断！！");
				return;
			}
			int dis = new Random().nextInt(6)+5;
			runDistance += dis;
			System.out.println("兔子跑到了"+runDistance);
		}
		tortoise.interrupt();
		
	}

}
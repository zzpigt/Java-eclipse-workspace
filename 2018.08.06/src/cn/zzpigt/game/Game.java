package cn.zzpigt.game;

import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		System.out.println("=============猜数字游戏=============");
		int rightNum = new Random().nextInt(100)+1;
		int count =0; //计数猜测的轮数
		
		System.out.println(rightNum);
		System.out.println("游戏开始，现在你可以猜一个数，我会告诉你大了，还是小了.......");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		while(num != rightNum ) {
			if(num > rightNum) {
				System.out.println("你猜的数大了，请继续猜.......");
			}else {
				System.out.println("你猜的数小了，请继续猜.......");
			}
			num = sc.nextInt();
			count++;
		}
		System.out.println("恭喜你，经过"+(count+1)+"次猜测后你过关了！！！！");
	}

}

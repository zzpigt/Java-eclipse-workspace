package com.zzpigt.homework;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		//让用户输入一个数，请电脑去猜
		System.out.println("请输入一个数：[1,100]");
		Scanner sc = new Scanner(System.in);
		int rightNum = sc.nextInt();
		System.out.println(rightNum);
		System.out.println("==================游戏开始============");
		int start = 1;
		int end = 100;
		int count =0;
		boolean isRight = false;
		do {
			//电脑输入一个中间数
			int midNum = (int)(start+end)/2;
			count++;
			System.out.print("电脑输入数字："+midNum);
			if(midNum>rightNum) {
				System.out.println("      大了！！！");
				end = midNum;
			}else if(midNum<rightNum){
				System.out.println("      小了！！！");
				start = midNum;
			}else {
				System.out.println("      对了！！！");
				isRight = true;
			}
		} while (!isRight);
		
		System.out.println("=====游戏结束！电脑猜测了"+count+"次！！！=======");
	}
}

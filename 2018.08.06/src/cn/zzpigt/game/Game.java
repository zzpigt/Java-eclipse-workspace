package cn.zzpigt.game;

import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		System.out.println("=============��������Ϸ=============");
		int rightNum = new Random().nextInt(100)+1;
		int count =0; //�����²������
		
		System.out.println(rightNum);
		System.out.println("��Ϸ��ʼ����������Բ�һ�������һ��������ˣ�����С��.......");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		while(num != rightNum ) {
			if(num > rightNum) {
				System.out.println("��µ������ˣ��������.......");
			}else {
				System.out.println("��µ���С�ˣ��������.......");
			}
			num = sc.nextInt();
			count++;
		}
		System.out.println("��ϲ�㣬����"+(count+1)+"�β²��������ˣ�������");
	}

}

package com.zzpigt.homework;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		//���û�����һ�����������ȥ��
		System.out.println("������һ������[1,100]");
		Scanner sc = new Scanner(System.in);
		int rightNum = sc.nextInt();
		System.out.println(rightNum);
		System.out.println("==================��Ϸ��ʼ============");
		int start = 1;
		int end = 100;
		int count =0;
		boolean isRight = false;
		do {
			//��������һ���м���
			int midNum = (int)(start+end)/2;
			count++;
			System.out.print("�����������֣�"+midNum);
			if(midNum>rightNum) {
				System.out.println("      ���ˣ�����");
				end = midNum;
			}else if(midNum<rightNum){
				System.out.println("      С�ˣ�����");
				start = midNum;
			}else {
				System.out.println("      ���ˣ�����");
				isRight = true;
			}
		} while (!isRight);
		
		System.out.println("=====��Ϸ���������Բ²���"+count+"�Σ�����=======");
	}
}

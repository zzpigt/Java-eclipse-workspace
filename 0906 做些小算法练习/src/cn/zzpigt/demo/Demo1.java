package cn.zzpigt.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Demo1 {
	
	public static void main(String[] args) {
		/**
		 * һ����1��N���ƣ�ÿ�δ��ƶѶ�ȡһ�ŷ��������ϣ���ȡһ�ŷ����ƶѵ��£�
		 * ѭ��ֱ������û�ƣ���������ϵ����Ǵ�1��N������Ƴ�������N������ƶѵ�˳������
		 * ���ϣ���1��2��3��4��5��
		 * ���ϣ���1��3��5��4��2��
		 * ��null��2��3��4��5��-----��1��null��null��null��null��
		 * ��null��3��4��5��2��-----��1��null��null��null��null��
		 * ��null��null��4��5��2��-----��1��3��null��null��null��
		 * ��null��null��5��2��4��-----��1��3��null��null��null��
		 * ��null��null��null��2��4��-----��1��3��5��null��null��
		 * ��null��null��null��4��2��-----��1��3��5��null��null��
		 * ��null��null��null��null��2��-----��1��3��5��4��null��
		 * ��null��null��null��null��null��-----��1��3��5��4��2��
		 */
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		//��ʼ��������
		List<Integer> nList = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			nList.add(i+1);
		}
		//�����ϵ���
		List<Integer> gList = new ArrayList<>();
		int count = 0;
		for (Iterator iterator = nList.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			if(count%2 == 0) {
				gList.add(integer);
			}else {
				nList.add(integer);
			}
			iterator.remove();
			count++;
		}
		for (Integer integer : gList) {
			System.out.println(integer);
		}
		
	}

}

package cn.zzpigt.teacher.time;

import java.util.Calendar;

public class Demo2 {

	public static void main(String[] args) {
		
		Calendar rightNow = Calendar.getInstance();
		// ��ʹ�� Calendar ��ȡ���ڵ������գ���ݼ�֮�����Ϣ
		
		System.out.println(rightNow.get(Calendar.YEAR));
		// �·ݴ�0��ʼ
		System.out.println(rightNow.get(Calendar.MONTH) + 1);
		System.out.println(rightNow.get(Calendar.DATE));
		// ��ݼ�
		System.out.println(rightNow.get(Calendar.DAY_OF_WEEK) - 1);
		// ���ó�2�·�
		rightNow.set(Calendar.MONTH, 1);
		// ���������м���
		System.out.println(rightNow.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		
	}
	
}

package cn.zzpigt.teacher.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.event.CaretListener;

public class Demo3 {

	public static void main(String[] args) {
		// ��ӡ���������
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��");
		System.out.println(sdf.format(date));
		
		System.out.println("��	һ	��	��	��	��	��");
		
		// ʱ�����������1��
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 1);
		
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		int dayCount = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		// ��һ��
		for(int i = 1; i < dayOfWeek; i ++) {
			System.out.print('\t');
		}
		
		System.out.print(1 + "\t");
		
		for (int i = 2; i <= dayCount ; i++) {
			// ����c�е�����
			c.set(Calendar.DAY_OF_MONTH, i);
			System.out.print(i + "\t");
			// �����ʱ����
			if(c.get(Calendar.DAY_OF_WEEK) == 7)
				System.out.println();
		}
		
		
		
		
		
		
	}
	
}

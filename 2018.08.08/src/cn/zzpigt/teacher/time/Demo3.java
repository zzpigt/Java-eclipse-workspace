package cn.zzpigt.teacher.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.event.CaretListener;

public class Demo3 {

	public static void main(String[] args) {
		// 打印这个月月历
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
		System.out.println(sdf.format(date));
		
		System.out.println("日	一	二	三	四	五	六");
		
		// 时间拉到这个月1号
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 1);
		
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		int dayCount = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		// 第一天
		for(int i = 1; i < dayOfWeek; i ++) {
			System.out.print('\t');
		}
		
		System.out.print(1 + "\t");
		
		for (int i = 2; i <= dayCount ; i++) {
			// 设置c中的日期
			c.set(Calendar.DAY_OF_MONTH, i);
			System.out.print(i + "\t");
			// 礼拜六时候换行
			if(c.get(Calendar.DAY_OF_WEEK) == 7)
				System.out.println();
		}
		
		
		
		
		
		
	}
	
}

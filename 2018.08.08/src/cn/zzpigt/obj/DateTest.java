package cn.zzpigt.obj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
		
		//时间转字符串
		String s_date = sdf.format(date);
		System.out.println(s_date);
		
		//字符串转时间
		//看API，先看构造，然后看方法，如果没有找到需要的，可以看看父类中的方法
		Date date2 = sdf.parse(s_date);
		System.out.println(date2);
		
		
		
		//打印这个月的月历
		Calendar rightNow = Calendar.getInstance();
		
		System.out.println(rightNow.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		System.out.println("====================="+s_date+"====================");
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		rightNow.set(Calendar.DAY_OF_MONTH, 1);
		int maxDay = rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayofWeek = rightNow.get(Calendar.DAY_OF_WEEK);
		//System.out.println(dayofWeek);
		for (int i = 1; i < dayofWeek; i++) {
			System.out.print("\t");
		}
		//第一天放进去
		System.out.print(1+"\t");
		
		for (int i = 2; i <= maxDay; i++) {
			rightNow.set(Calendar.DAY_OF_MONTH,i);
			System.out.print(i+"\t");
			if(rightNow.get(Calendar.DAY_OF_WEEK) == 7) {
				System.out.println();
			}
		}
		
		//实验getActualMaximum()方法
		//所以这个方法是给什么值，比如给一个星期中的一天（DAY_OF_WEEK）,	那么就是最大值就是相对星期来说是7天 
		System.out.println();
		System.out.println("========================================");
		int num = rightNow.getActualMaximum(Calendar.DAY_OF_WEEK);
		System.out.println(num);
		
		
	}
}

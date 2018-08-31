package cn.zzpigt.teacher.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo1 {

	public static void main(String[] args) throws ParseException {
		
		// Date
		Date date = new Date();
		//System.out.println(date);
		
		// 2018年8月8日  15：09：50
		// java.text.SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		// 时间转成字符串
		String s_date = sdf.format(date);
		System.out.println(s_date);
		
		
		// 字符串转时间
		Date date2 = sdf.parse(s_date);
		System.out.println(date2);
		
		
	}
	
}

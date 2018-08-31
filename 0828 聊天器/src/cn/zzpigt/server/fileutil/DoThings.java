package cn.zzpigt.server.fileutil;

import java.lang.reflect.Field;

import cn.zzpigt.bean.MyRequest;
import cn.zzpigt.bean.MyResponse;

public abstract class DoThings {

	public MyResponse getResponse(MyRequest request) {
		Class<?> clazz = request.getClass();
		//拿到request中所有的常量值，String类型的常量
		Field[] fields = clazz.getFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			if("String".equals(field.getType().getSimpleName())) {
				//拿到以后就取出里面所有的值
				
			}
			
		}
		
		
		return null;
	}

	private void Code(MyRequest request) {
		
	}
	
	
	
	
}

package cn.zzpigt.server.fileutil;

import java.lang.reflect.Field;

import cn.zzpigt.bean.MyRequest;
import cn.zzpigt.bean.MyResponse;

public abstract class DoThings {

	public MyResponse getResponse(MyRequest request) {
		Class<?> clazz = request.getClass();
		//�õ�request�����еĳ���ֵ��String���͵ĳ���
		Field[] fields = clazz.getFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			if("String".equals(field.getType().getSimpleName())) {
				//�õ��Ժ��ȡ���������е�ֵ
				
			}
			
		}
		
		
		return null;
	}

	private void Code(MyRequest request) {
		
	}
	
	
	
	
}

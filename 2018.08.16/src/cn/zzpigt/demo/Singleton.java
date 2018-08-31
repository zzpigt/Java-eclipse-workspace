package cn.zzpigt.demo;

public class Singleton {
	
	private static Singleton instance = null;
	
	
	//�Ȱѹ�����˽�У�Ȼ���Լ�ʵ��һ������ֵΪNull��дһ���������ö����ж��Ƿ�Ϊnull������Ǿʹ��������Ǿ�ֱ�ӷ���
	
	private Singleton() {
		System.out.println("�����ˣ���");
	}
	
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	
}

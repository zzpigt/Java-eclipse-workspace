package cn.zzpigt.obj;

public class Demo2 {
	public static void main(String[] args) {
		Cat c = new Cat();
		c = null;
		
		//����һ��Gc���Խ��л�����
		//ƽ�����������������д��Ƶ���ĵ��û���������ڴ�
		System.gc();
	}	
}

class Cat{
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("��������������");
	}
	
	
}
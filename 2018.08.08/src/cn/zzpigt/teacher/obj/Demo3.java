package cn.zzpigt.teacher.obj;

public class Demo3 {

	public static void main(String[] args) {
		Cat c = new Cat();
		c = null;
		// ����һ��GC���Ի�����
		System.gc();
		
	}
	
}

class Cat{
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("�� �ұ������ˣ�");
	}
	
}

package cn.zzpigt.exception;

public class Demo2 {
	public static void main(String[] args) {
		//fianlly��ִ�кͺ���Ĵ��벻ͬ���ڣ�finally���ǳ���return��Ҳ��ִ�еĿ�
		
		try {
			String str = null;
			System.out.println(str.length());
			System.out.println("tryִ����");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("catch�������쳣");
			return;
		} finally {
			System.out.println("����ִ�У�������");
		}
		System.out.println("��������ִ�У���");
	}
}

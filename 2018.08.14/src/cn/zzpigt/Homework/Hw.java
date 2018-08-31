package cn.zzpigt.Homework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Hw {
	public static void main(String[] args) {
		
//		1. ����һ��HashSet����hs������Hello��,5,2,��World��,��Java��,��Hello���ֱ���ӵ�hs�У���ʹ�õ�����ʽ������Ԫ����������������ظ�Ԫ��
		Set hs = new HashSet();
		
		hs.add("Hello");
		hs.add(5);
		hs.add(2);
		hs.add("World");
		hs.add("Java");
		hs.add("Hello");
		
		for (Iterator iterator = hs.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
//		4. ����Java���Ƴ����鿴hs�ĳ���
		hs.remove("Java");
		System.out.println("����Java���Ƴ����鿴hs�ĳ���:"+hs.size());
		
//		2. ���hs�е�Ԫ�أ��鿴Ԫ���Ƿ�Ϊ�գ��������20��1��100֮����������ֱ���ӵ�hs�У��鿴hs�ĳ���Ϊ���٣���ʹ�õ����ķ�ʽ������Ԫ�����
		hs.clear();
		System.out.println("���hs�е�Ԫ�أ��鿴Ԫ���Ƿ�Ϊ��:"+hs.isEmpty());
		
		for(int i=0;i<20;i++) {
			int num = new Random().nextInt(100)+1;
			hs.add(num);
		}
		System.out.println("�������20��1��100֮����������ֱ���ӵ�hs�У��鿴hs�ĳ���Ϊ����");
		System.out.println(hs.size());
		for (Iterator iterator = hs.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.print(object+"  ");
		}
		System.out.println();
//		3. �鿴hs���Ƿ���Ԫ�ء�JavaSE��
		System.out.println("�鿴hs���Ƿ���Ԫ�ء�JavaSE");
		System.out.println(hs.contains("JavaSE"));
		
		

		
		
	}
}

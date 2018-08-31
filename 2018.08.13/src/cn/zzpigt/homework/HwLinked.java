package cn.zzpigt.homework;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class HwLinked {
	public static void main(String[] args) {
		// 1. ����һ��LinkedList����lList���ֱ𽫡�JavaSE������JavaME������JavaEE����ӵ�lList��
		LinkedList<Object> lList = new LinkedList<>();
		lList.add("JavaSE");
		lList.add("JavaME");
		lList.add("JavaEE");
		
		// 2. ����lList�ֱ�ȡ����Ԫ�ؽ������
		for (Object o : lList) {
			System.out.println(o);
		}
		
		// 3. ֱ��ȡ����lList���׸������һ��Ԫ�ز����
		System.out.println("��һ����"+lList.getFirst());
		System.out.println("���һ����"+lList.getLast());
		
		// 4. ����JDK����ӵ�lList�Ŀ�ͷ
		lList.addFirst("JDK");
		
		// 5. ����һ��LinkedList����lList_2���ֱ𽫡�HTML������XML������JSON����ӵ�lList_2��
		LinkedList<String> lList_2 = new LinkedList<>();
		lList_2.add("HTML");
		lList_2.add("XML");
		lList_2.add("JSON");
		
		
		// 6. ��lList_2��ӵ�lList������Ϊ2��λ��
		lList.add(2, lList_2);
		
		for (Object object : lList) {
			System.out.println(object);
		}
		
		// 7. �ֱ��ж�lList��lList_2�Ƿ��С�JavaSE�����Ԫ��
		System.out.println("lList�Ƿ��С�JavaSE�����Ԫ��:"+lList.contains("JavaSE"));
		System.out.println("lList_2�Ƿ��С�JavaSE�����Ԫ��:"+lList_2.contains("JavaSE"));
		
		// 8. ��ȡlList���������������ͨ���õ������ֱ�ȡ��lList�е�Ԫ�ؽ������
		Collections.reverse(lList);
		System.out.println(" ��ȡlList�����������======================");
		for (Iterator iterator = lList.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
		
		// 9. ��ȡlList��˳�����������ͨ���õ������ֱ�ȡ��lList�е�Ԫ�����
		Collections.sort(lList_2, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() > o2.length()) {
					return 1;
				}else if(o1.length() < o2.length()) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		
		for (String string : lList_2) {
			System.out.println("��ȡlList��˳�����������ͨ���õ������ֱ�ȡ��lList�е�Ԫ�����"+string);
		}
		
		// 10. ȡ�������Ƴ��б��һ�������һ��Ԫ�أ���������Ԫ�����
		System.out.println("ȡ�������Ƴ��б��һ�������һ��Ԫ�أ���������Ԫ�����:");
		
		System.out.println(lList.getFirst());
		System.out.println(lList.getLast());
		
		
		
		for (Object o : lList) {
			System.out.println(o);
		}
		
		// 11. ȡ�����Ƴ���һ�������һ��Ԫ�أ���������Ԫ�����
		System.out.println(lList.removeFirst());
		System.out.println(lList.removeLast());
		// 12. ���б��е���һ��Ԫ�أ��������Ԫ��
		Collections.shuffle(lList_2);
		System.out.println("�������һ��Ԫ�أ�"+lList_2.getFirst());
		
		// 13. �ѡ�Android��������б�
		lList_2.addFirst("Android");
	}
}

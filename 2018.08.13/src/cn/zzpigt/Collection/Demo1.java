package cn.zzpigt.Collection;

import java.util.Iterator;
import java.util.LinkedList;

public class Demo1 {
	public static void main(String[] args) {
		//LinkedList
		LinkedList<Integer> list = new LinkedList<>();
		 
		list.add(5);
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(2);
		
		list.addFirst(8);
		list.addLast(9);
		
		System.out.println(list.removeFirst());
		System.out.println();
		System.out.println("+++++++++++++++++");
		
		/*for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}*/
		
		//ʹ�õ���������,��������������
		/*Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}*/
		
		/*for(Iterator iterator =  list.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}*/
		
		//foreachѭ����Ч�����ܺ͵�����ȫһ��
		
		for(int i:list) {
			System.out.println(i);
		}
		
		
	}
}

package cn.zzpigt.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HwArray {
	public static void main(String[] args) {
		//1. ����һ��ArrayList����arrList1���жϸ��б��Ƿ�Ϊ��
		List<Object> arrList1 = new ArrayList<>();
//		if(arrList1 == null || arrList1.size() == 0) {
//			System.out.println("���б�Ϊ�գ���");
//		}
		
		// 2. �ٽ�1,2,3,4,5��5��int�����մ�С����˳����ӽ�ȥ����ȡһ�¸��б���
		Integer[] arr1 = {1,2,3,4,5};
		for(int i=0;i<arr1.length-1;i++) {
			for (int j = 0; j < arr1.length-1-i; j++) {
				if(arr1[j]>arr1[j+1]) {
					Integer temp = arr1[j];
					arr1[j] = arr1[j+1];
					arr1[j+1] = temp;
				}
			}
		}
		for (Integer i : arr1) {
			arrList1.add(i);
		}
		System.out.println("���б���:"+arrList1.size());
		// 3. �ٽ�1,2,3,4,5��5��int�����մӴ�С˳����ӽ�ȥ
		for(int i=0;i<arr1.length-1;i++) {
			for (int j = 0; j < arr1.length-1-i; j++) {
				if(arr1[j]<arr1[j+1]) {
					int temp = arr1[j];
					arr1[j] = arr1[j+1];
					arr1[j+1] = temp;
				}
			}
		}
		for (int i : arr1) {
			arrList1.add(i);
		}
		
		
		// 4. �����������ֵ����ȡ������ӡ����
//		for (Object i : arrList1) {
//			System.out.println(i);
//		}
//		
		// 5. ������Ӵ��ˡ���ӵ�����ArrayList���������Ϊ2��λ�ã�����ӡ�鿴
		arrList1.add(2,	"��Ӵ��ˣ���");
//		for (Object i : arrList1) {
//			System.out.println(i);
//		}
		// 6. ����һ��ArrayList����arrList2����arrList1������arrList2
		List<Object> arrList2 = arrList1;

		// 7. �鿴arrList2���Ƿ��������Ӵ򷹡����Ԫ��
		for (Object i : arrList2) {
			System.out.println(i);
		}
		
		// 8. �ж�1���Ԫ�ص�һ�κ����һ�γ��ֵ�λ��
		System.out.println("��һ��:"+arrList1.indexOf(1));
		System.out.println("���һ��:"+arrList1.lastIndexOf(1));
		
		// 9. �Ȳ鿴�б��ȣ�Ȼ���Ƴ�����λ��Ϊ3��Ԫ��ֵ���鿴�б����Ƿ�ı�
		System.out.println(arrList2.size());
		arrList2.remove(3);
		System.out.println("�Ƴ�����λ��Ϊ3��Ԫ��:"+arrList2.size());
		
		// 10. �Ȳ鿴�б��ȣ�Ȼ���Ƴ��б���4���Ԫ�أ��鿴�б����Ƿ�ı�
		System.out.println(arrList2.size());
		for (Iterator iterator = arrList2.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			if(object == (Integer)4) {
				iterator.remove();
			}
		}
		System.out.println("�Ƴ�4��Ԫ��:"+arrList2.size());
		
		// 11. �Ƴ�λ��1��3֮���Ԫ�أ������б��е�����Ԫ�ش�ӡ����
		System.out.println("�Ƴ�λ��1��3֮���Ԫ��");
		int count = 0;
		for (Iterator iterator = arrList2.iterator(); iterator.hasNext();count++) {
			Object object = (Object) iterator.next();
			if(count>=1 && count<=3) {
				iterator.remove();
			}else {
				System.out.print(object+"  ");
			}
		}
		
		// 12. ��ż��λ���ϵ�Ԫ��ͳһ�滻�ɡ�ż����
		System.out.println("��ż��λ���ϵ�Ԫ��ͳһ�滻�ɡ�ż����:");

		for(int i=0;i < arrList1.size();i += 2) {
			arrList2.set(i, (int)arrList2.get(i)*2);
		}
		
		for (Object i : arrList2) {
			System.out.println(i);
		}
		// 13. ����б��鿴�б���
		System.out.println("����б��鿴�б���:");
		arrList2.clear();
		System.out.println(arrList2.size());

		
	}
}

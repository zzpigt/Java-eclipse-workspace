package cn.zzpigt.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HwArray {
	public static void main(String[] args) {
		//1. 创建一个ArrayList对象arrList1，判断该列表是否为空
		List<Object> arrList1 = new ArrayList<>();
//		if(arrList1 == null || arrList1.size() == 0) {
//			System.out.println("该列表为空！！");
//		}
		
		// 2. 再将1,2,3,4,5共5个int数按照从小到大顺序添加进去，获取一下该列表长度
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
		System.out.println("该列表长度:"+arrList1.size());
		// 3. 再将1,2,3,4,5共5个int数按照从大到小顺序添加进去
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
		
		
		// 4. 将上述对象的值依次取出来打印出来
//		for (Object i : arrList1) {
//			System.out.println(i);
//		}
//		
		// 5. 将“插队打饭了”添加到上述ArrayList对象的索引为2的位置，并打印查看
		arrList1.add(2,	"插队打饭了！！");
//		for (Object i : arrList1) {
//			System.out.println(i);
//		}
		// 6. 定义一个ArrayList变量arrList2，将arrList1拷贝到arrList2
		List<Object> arrList2 = arrList1;

		// 7. 查看arrList2中是否包含“插队打饭”这个元素
		for (Object i : arrList2) {
			System.out.println(i);
		}
		
		// 8. 判断1这个元素第一次和最后一次出现的位置
		System.out.println("第一次:"+arrList1.indexOf(1));
		System.out.println("最后一次:"+arrList1.lastIndexOf(1));
		
		// 9. 先查看列表长度，然后移除索引位置为3的元素值，查看列表长度是否改变
		System.out.println(arrList2.size());
		arrList2.remove(3);
		System.out.println("移除索引位置为3的元素:"+arrList2.size());
		
		// 10. 先查看列表长度，然后移除列表中4这个元素，查看列表长度是否改变
		System.out.println(arrList2.size());
		for (Iterator iterator = arrList2.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			if(object == (Integer)4) {
				iterator.remove();
			}
		}
		System.out.println("移除4的元素:"+arrList2.size());
		
		// 11. 移除位置1到3之间的元素，并将列表中的所有元素打印出来
		System.out.println("移除位置1到3之间的元素");
		int count = 0;
		for (Iterator iterator = arrList2.iterator(); iterator.hasNext();count++) {
			Object object = (Object) iterator.next();
			if(count>=1 && count<=3) {
				iterator.remove();
			}else {
				System.out.print(object+"  ");
			}
		}
		
		// 12. 将偶数位置上的元素统一替换成“偶数”
		System.out.println("将偶数位置上的元素统一替换成“偶数”:");

		for(int i=0;i < arrList1.size();i += 2) {
			arrList2.set(i, (int)arrList2.get(i)*2);
		}
		
		for (Object i : arrList2) {
			System.out.println(i);
		}
		// 13. 清空列表，查看列表长度
		System.out.println("清空列表，查看列表长度:");
		arrList2.clear();
		System.out.println(arrList2.size());

		
	}
}

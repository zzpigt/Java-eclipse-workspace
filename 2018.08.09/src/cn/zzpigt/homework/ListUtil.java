package cn.zzpigt.homework;

public class ListUtil {
	
	public static void main(String[] args) {
		LinkedList<Integer> linkList = new LinkedList<>();
		//添加一个动物
//		linkList.add(new Animal("Dog"));
//		linkList.add(new Animal("Cat"));
//		linkList.add(new Animal("Sheep"));
//		linkList.add(new Animal("cow"));
		
		linkList.add(9);
		linkList.add(8);
		linkList.add(7);
		linkList.add(6);
		linkList.add(5);
		linkList.add(4);
		linkList.add(3);
		
		
		ArrayList<Integer> arrList = new ArrayList<>();
//		arrList.add(new Animal("Dog1"));
//		arrList.add(new Animal("Cat2"));
//		arrList.add(new Animal("Sheep3"));
//		arrList.add(new Animal("cow4"));
//		
		arrList.add(9);
		arrList.add(8);
		arrList.add(7);
		arrList.add(6);
		arrList.add(5);
		arrList.add(4);
		arrList.add(3);
		

//		swap(linkList,0,3);
//		reverse(linkList);
//		linkList.set(3, new Animal("fuck"));
//		linkList.set(0, linkList.get(3));
		sort(arrList);
		
		for (int i = 0; i < arrList.size(); i++) {
			System.out.println(arrList.get(i));
		}
		
	}
	
	// 交换i和j两个元素的位置
	public static  void swap(List list, int i, int j) {
		//分为链表和数组两种
		//这里交换节点，其实只用交换双方的数据就可以了
		if(list.get(i) != null && list.get(j) != null) {
			Object iChange = list.get(i);
			list.set(i, list.get(j));
			list.set(j, iChange);
		}
		
	}
	/**
	 * 知道链表交换其实就是把里面的数据进行交换，那么就简单了
	 * 
	 * @param list
	 */
	// 元素顺序逆序（反转）
	public static void reverse(List list) {
		
		for(int i=0; i<list.size()/2;i++) {
			swap(list,i,list.size()-i-1);
		}
		
	}

	/**
	 * 那么链表存储的就是Integer类型的数
	 * 每次比较的话考虑转成int基本数据类型再排序
	 * @param list
	 */
	// 排序（升序）
	public static void sort(List<Integer> list) {
		for(int i=0; i<list.size()-1; i++) {
			for(int j=0;j<list.size()-i-1;j++) {
				if(list.get(j)>list.get(j+1)) {
					swap(list,j,j+1);
				}
			}
		}
	}
}

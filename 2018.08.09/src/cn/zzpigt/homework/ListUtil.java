package cn.zzpigt.homework;

public class ListUtil {
	
	public static void main(String[] args) {
		LinkedList<Integer> linkList = new LinkedList<>();
		//���һ������
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
	
	// ����i��j����Ԫ�ص�λ��
	public static  void swap(List list, int i, int j) {
		//��Ϊ�������������
		//���ｻ���ڵ㣬��ʵֻ�ý���˫�������ݾͿ�����
		if(list.get(i) != null && list.get(j) != null) {
			Object iChange = list.get(i);
			list.set(i, list.get(j));
			list.set(j, iChange);
		}
		
	}
	/**
	 * ֪����������ʵ���ǰ���������ݽ��н�������ô�ͼ���
	 * 
	 * @param list
	 */
	// Ԫ��˳�����򣨷�ת��
	public static void reverse(List list) {
		
		for(int i=0; i<list.size()/2;i++) {
			swap(list,i,list.size()-i-1);
		}
		
	}

	/**
	 * ��ô����洢�ľ���Integer���͵���
	 * ÿ�αȽϵĻ�����ת��int������������������
	 * @param list
	 */
	// ��������
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

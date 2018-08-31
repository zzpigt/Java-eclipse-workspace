package com.bwf.obj;


class Hw1{

	public static void main(String[] args){

		// 测试我们的动态数组
		List list = new ArrayList();
		
		list.add(new Animal("猫"));
		list.add(new Animal("狗"));
		list.add(new Animal("牛"));

		list.add("abc");
		list.add(1);
		

		
		for(int i = 0; i < list.size(); i ++) {
			if(list.get(i) instanceof Animal) {
				System.out.println(((Animal)list.get(i)).name);
			} else {
				System.out.println(list.get(i));
			}
		}


	}

}
package com.bwf.generic;


class Hw1{

	public static void main(String[] args){

		// 测试我们的动态数组
		List<Animal> list = new ArrayList<Animal>();
		
		list.add(new Animal("猫"));
		list.add(new Animal("狗"));
		list.add(new Animal("牛"));

		// 如果代码一定会出问题，你希望它出现在编译时，还是运行时？
		//
		
		list.add("abc");
		list.add(1);
		
		for(int i = 0; i < list.size(); i ++) {
			System.out.println(list.get(i).name);
		}


	}

}
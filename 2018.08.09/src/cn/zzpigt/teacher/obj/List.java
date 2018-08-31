package com.bwf.obj;


interface List{
	
  	//添加一个动物
	void add(Object o);
	//删除一个动物
	Object remove(int index);
 	//根据索引取出任意一个动物
	Object get(int index);
  	//根据索引设置一个动物
	Object set(int index, Object o);
	// 获取内部动物数量
	int size();
}

class Animal{
	public String name;
	public Animal(String name){
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
	
}
package com.bwf.generic;

// 泛型 - 参数化类型
interface List<T>{
	
  	//添加一个动物
	void add(T t);
	//删除一个动物
	T remove(int index);
 	//根据索引取出任意一个动物
	T get(int index);
  	//根据索引设置一个动物
	T set(int index, T t);
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
package com.bwf.generic;


class ArrayList<T> implements List<T>{

	private Object[] arr = new Object[3];

	private int size = 0;	// 保存动物真实数量
	
  	//添加一个动物
	public void add(T o){
		if(size >= arr.length){
			// 数组长度不够，开辟一个新数组，长度是原来的2倍
			Object[] tmp = new Object[2*arr.length];
			// 原来数组的内容搬到新数组的头部
			for(int i = 0; i < arr.length; i ++){
				tmp[i] = arr[i];
			}
			// 原数组引用指向新数组
			arr = tmp;
		}
		// 紧跟着放新动物
		arr[size] = o;
		size ++;
	}

 	//根据索引取出任意一个动物
	public T get(int index){
		if(index >= size)
			return null;
	
		return (T) arr[index];
	}

	// 获取内部动物数量
	public int size(){
		return size;
	}


	//删除一个动物
	public T remove(int index){

		// 把原来的动物拿出来
		Object pri = get(index);

		if(pri == null)
			return null;

		// 先把后面的数往前移
		for(int i = index; i < size - 1; i ++){
			arr[i] = arr[i+1];
		}
		
		// 最后一个元素置为null
		arr[size - 1] = null;

		// 真实长度 -1 
		size--;

		return (T) pri;
	}

  	//根据索引设置一个动物
	public T set(int index, T o){
		if(index >= 0 && index < size){
			// 把原来这个索引的动物拿出来
			Object pri = get(index);
			// 把要设置的动物放在指定索引
			arr[index] = o;
			// 把原来这个位置的动物返回出去
			return (T) pri;
		}	

		return null;
	}


}
package com.bwf.obj;


class ArrayList implements List{

	private Object[] arr = new Object[3];

	private int size = 0;	// ���涯����ʵ����
	
  	//���һ������
	public void add(Object o){
		if(size >= arr.length){
			// ���鳤�Ȳ���������һ�������飬������ԭ����2��
			Object[] tmp = new Object[2*arr.length];
			// ԭ����������ݰᵽ�������ͷ��
			for(int i = 0; i < arr.length; i ++){
				tmp[i] = arr[i];
			}
			// ԭ��������ָ��������
			arr = tmp;
		}
		// �����ŷ��¶���
		arr[size] = o;
		size ++;
	}

 	//��������ȡ������һ������
	public Object get(int index){
		if(index >= size)
			return null;
	
		return arr[index];
	}

	// ��ȡ�ڲ���������
	public int size(){
		return size;
	}


	//ɾ��һ������
	public Object remove(int index){

		// ��ԭ���Ķ����ó���
		Object pri = get(index);

		if(pri == null)
			return null;

		// �ȰѺ��������ǰ��
		for(int i = index; i < size - 1; i ++){
			arr[i] = arr[i+1];
		}
		
		// ���һ��Ԫ����Ϊnull
		arr[size - 1] = null;

		// ��ʵ���� -1 
		size--;

		return pri;
	}

  	//������������һ������
	public Object set(int index, Object o){
		if(index >= 0 && index < size){
			// ��ԭ����������Ķ����ó���
			Object pri = get(index);
			// ��Ҫ���õĶ������ָ������
			arr[index] = o;
			// ��ԭ�����λ�õĶ��ﷵ�س�ȥ
			return pri;
		}	

		return null;
	}


}
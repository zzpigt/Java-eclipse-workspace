package cn.zzpigt.obj;

class Hw {


	public static void main(String[] args){

		AnyType<Animal> any = new AnyType<Animal>();
		//添加一个动物
		any.add(new Animal("Dog"));
		any.add(new Animal("Cat"));
		any.add(new Animal("Sheep"));
		
//		any.add("adfa");
//		any.add(123);
		//System.out.println(any.arrAnimal[1].name);
		//System.out.println(any.size());
		for (int i = 0; i < any.size(); i++) {
			System.out.println(any.get(i));
			
		}
		
		
		
		
		
	}


}

class AnyType<T> implements List<T>{
	
	
	 
	public int size = 0;
	public  Object[] arrAnimal = new Object[3];	
	
	
	public void add(T o){
		if(size>=arrAnimal.length){
			Object[] temp = new Object[2*arrAnimal.length];
			for(int i=0;i<arrAnimal.length;i++){
				temp[i]=arrAnimal[i];
			} 
			arrAnimal = temp;
		}
		arrAnimal[size++] = o;
	}

	public void remove(int index){
		if(index<size){

			for(int i=index;i<size;i++){
				arrAnimal[i] = arrAnimal[i+1];
			}
			size--;


		}
		
	}

	public T get(int index){
		if(index>size){
			return null;
		}
		return (T) arrAnimal[index];
	}

	public void set(int index,T o){
		if(index<size){
			//判断这个数组是不是满来，如果满了，那么就要先扩充
			if(size>=arrAnimal.length){
				Object[] tempArr = new Object[2*arrAnimal.length];
				for(int i=0;i<arrAnimal.length;i++){
					tempArr[i]=arrAnimal[i];
				} 
				arrAnimal = (T[]) tempArr;
			}		
			
			
		}

		for(int i=size;i>index;i--){
			arrAnimal[i] = arrAnimal[i-1];
		}
		arrAnimal[index] = o;
		size++;
	}

	public int size(){
		return size;
	}
}
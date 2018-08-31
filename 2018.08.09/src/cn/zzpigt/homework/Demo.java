package cn.zzpigt.homework;


public class Demo {

	public static void main(String[] args) {
		
		LinkedList<Animal> list = new LinkedList<Animal>();
		//添加一个动物
		list.add(new Animal("Dog"));
		list.add(new Animal("Cat"));
		list.add(new Animal("Sheep"));
		list.add(new Animal("Dog"));
		list.add(new Animal("Cat"));
		list.add(new Animal("Sheep"));
		list.add(new Animal("Dog"));
		list.add(new Animal("Cat"));
		list.add(new Animal("Sheep"));
		
//		list.remove(1);
//		list.set(1, new Animal("Cow"));
		System.out.println(list.size());
		System.out.println(list.get(3));
		System.out.println(list.get(7));
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
	}
	
	
	
}



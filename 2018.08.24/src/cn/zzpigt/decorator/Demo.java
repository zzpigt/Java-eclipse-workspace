package cn.zzpigt.decorator;


import cn.zzpigt.decorator.decoration.Milk;
import cn.zzpigt.decorator.tea.BlackTea;

public class Demo {
	public static void main(String[] args) {
//		Drink tea = new GreenTea();
//		System.out.println(tea.getDesc());
//		System.out.println(tea.cost());
		
		
		Drink t = new Milk(new BlackTea());
		System.out.println(t.getDesc());
		System.out.println(t.cost());
	}
}

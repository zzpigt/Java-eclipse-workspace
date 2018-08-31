package cn.zzpigt.decorator.decoration;

import cn.zzpigt.decorator.Drink;

public class Milk extends Decorator{

	
	public Milk(Drink drink) {
		super(drink);
		setPrice(4.5);
		setDesc("еёдл - "+ getPrice());
	}


	
}

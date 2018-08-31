package cn.zzpigt.decorator.decoration;

import cn.zzpigt.decorator.Drink;

public class MilkCream extends Decorator{

	
	public MilkCream(Drink drink) {
		super(drink);
		setPrice(5);
		setDesc("длк╙ - "+getPrice());
	}

	
}

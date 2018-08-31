package cn.zzpigt.decorator.decoration;

import cn.zzpigt.decorator.Drink;

public class Pearl extends Decorator{

	
	public Pearl(Drink drink) {
		super(drink);
		setPrice(2.5);
		setDesc("’‰÷È - "+getPrice());
		
	}


	
}

package cn.zzpigt.decorator.decoration;

import cn.zzpigt.decorator.Drink;

public abstract class Decorator extends Drink{
	
	private Drink drink;
	
	public Decorator(Drink drink) {
		super();
		this.drink = drink;
	}
	
	@Override
	public String getDesc() {
		return super.getDesc() +" & "+ drink.getDesc();
	}

	@Override
	public double cost() {
		return getPrice()+drink.getPrice();
	}
	
	
	
	

}

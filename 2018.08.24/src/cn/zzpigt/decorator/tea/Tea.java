package cn.zzpigt.decorator.tea;

import cn.zzpigt.decorator.Drink;

public abstract class Tea extends Drink{
	
	public Tea() {
		super();
	}
	
	@Override
	public double cost() {
		return getPrice();
	}
	
}

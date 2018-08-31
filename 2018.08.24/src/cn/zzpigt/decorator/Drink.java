package cn.zzpigt.decorator;

public abstract class Drink {
	
	private String desc;
	private double price;
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public abstract double cost();
	
	
	
	
	
	
}

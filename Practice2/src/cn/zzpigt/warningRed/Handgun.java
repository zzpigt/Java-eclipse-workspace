package cn.zzpigt.warningRed;

class Handgun extends Weapon{

	public Handgun() {
		super(" ÷«π", 10, 30);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void reloading() {
		this.bulletNum = this.MAX_B_COUNT;
	}
	
}

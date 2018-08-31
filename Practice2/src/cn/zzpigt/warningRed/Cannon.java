package cn.zzpigt.warningRed;

class Cannon extends Weapon{

	public Cannon() {
		super("╦жез", 30, 10);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void reloading() {
		this.bulletNum = this.MAX_B_COUNT;
	}
	
}

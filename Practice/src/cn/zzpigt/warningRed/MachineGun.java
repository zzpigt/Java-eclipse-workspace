package cn.zzpigt.warningRed;

class MachineGun extends Weapon{

	public MachineGun() {
		super("��ǹ", 20, 20);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void reloading() {
		this.bulletNum = this.MAX_B_COUNT;
	}
}
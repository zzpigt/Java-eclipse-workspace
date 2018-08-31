package cn.zzpigt.warningRed;

public class Soldier {
	public int Hp = 200;
	public Weapon weapon;
	
	public Soldier(Weapon weapon) {
		super();
		this.weapon = weapon;
	}

	
	
	//攻击方法
	public void attack(Soldier s) {
		//攻击之前判断该士兵血量有没有，然后判断该士兵子弹有没有，再判断被攻击的士兵血量有没有，最后再攻击
		if(this.Hp>0) {
			if(this.weapon.bulletNum == 0) {
				this.weapon.reloading();
			}else {
				if(s.Hp > 0){
					s.Hp -= this.weapon.ac;
					this.weapon.bulletNum--;
				}
			}
		}
	}
	
}

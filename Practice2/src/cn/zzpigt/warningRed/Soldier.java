package cn.zzpigt.warningRed;

public class Soldier {
	public int Hp = 200;
	public Weapon weapon;
	
	public Soldier(Weapon weapon) {
		super();
		this.weapon = weapon;
	}

	
	
	//��������
	public void attack(Soldier s) {
		//����֮ǰ�жϸ�ʿ��Ѫ����û�У�Ȼ���жϸ�ʿ���ӵ���û�У����жϱ�������ʿ��Ѫ����û�У�����ٹ���
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

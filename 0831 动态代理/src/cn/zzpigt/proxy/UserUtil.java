package cn.zzpigt.proxy;

public class UserUtil  implements InterfaceUser{

	@Override
	public void insert() {
		System.out.println("��");
	}

	@Override
	public void delete() {
		System.out.println("ɾ");
	}

	@Override
	public void updata() {
		System.out.println("��");
		
	}

	@Override
	public void query() {
		System.out.println("��");
		
	}

}

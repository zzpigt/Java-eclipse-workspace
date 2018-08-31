package cn.zzpigt.proxy;

public class UserUtil  implements InterfaceUser{

	@Override
	public void insert() {
		System.out.println("Ôö");
	}

	@Override
	public void delete() {
		System.out.println("É¾");
	}

	@Override
	public void updata() {
		System.out.println("¸Ä");
		
	}

	@Override
	public void query() {
		System.out.println("²é");
		
	}

}

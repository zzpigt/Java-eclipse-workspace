package cn.zzpigt.fruits;

public class Admin {

	public static void main(String[] args) {
		Tool tool = new Tool();
		// 1. 用管理员帐号密码才能登录进行后续操作 admin 123
		login();
		boolean isOver = false;
		do {
			System.out.println("=======================================");
			System.out.println("您现在的身份是管理员，可以进行如下操作：");
			System.out.println("1.查看\n2.进货\n3.出货\n4.删除\n5.记录\n7.退出");
			int choseNum = 0;
			try {
				choseNum = Tool.sc.nextInt();
			} catch (Exception e) {
				System.out.println("输入错误！！重新输入");
				Tool.sc.nextLine();
				continue;
			}
			switch (choseNum) {
			case 1:
				// 2. 查看所有水果
				// 5. 对所有水果进行排序（价格排序 库存排序）
				tool.showDoFruit();
				break;

			case 2:
				// 3. 进货，添加新的水果（注意水果是否已经存在）
				tool.addFruits();
				break;

			case 3:
				// 4. 出货，减少库存
				tool.shipment();
				break;
			case 4:
				// 6. 删除指定水果（根据id和水果名）
				tool.delFruits();
				break;
			case 5:
				// 7. 查看进货和出货记录
				tool.showShipmentMeg();
				break;
			case 7:
				// 8. 退出系统
				isOver = true;
				System.out.println("【退出成功！！】");
				break;
			default:
				System.out.println("【请输入正确的操作对应的整数！】");
				break;
			}
		} while (!isOver);
	}

	// login登入
	private static void login() {
		System.out.println("================水果管理系统===============");
		boolean isRight = false;
		do {
			System.out.print("请输入帐号：");
			String inputName = Tool.sc.next();
			System.out.println();
			System.out.print("请输入密码：");
			int inputPwd = 0;
			try {
				inputPwd = Tool.sc.nextInt();
			} catch (Exception e) {
				System.out.println("输入错误！！重新输入");
				Tool.sc.nextLine();
				continue;
			}
			if ("admin".equals(inputName) && inputPwd == 123 ) {
				isRight = true;
				System.out.println("=================登入成功！！==============");
			} else {
				isRight = false;
				System.out.print("*帐号/密码输入错误或不存在！！");
				System.out.println();
			}

		} while (!isRight);

	}

}

package cn.zzpigt.fruits;

public class Admin {

	public static void main(String[] args) {
		Tool tool = new Tool();
		// 1. �ù���Ա�ʺ�������ܵ�¼���к������� admin 123
		login();
		boolean isOver = false;
		do {
			System.out.println("=======================================");
			System.out.println("�����ڵ�����ǹ���Ա�����Խ������²�����");
			System.out.println("1.�鿴\n2.����\n3.����\n4.ɾ��\n5.��¼\n7.�˳�");
			int choseNum = 0;
			try {
				choseNum = Tool.sc.nextInt();
			} catch (Exception e) {
				System.out.println("������󣡣���������");
				Tool.sc.nextLine();
				continue;
			}
			switch (choseNum) {
			case 1:
				// 2. �鿴����ˮ��
				// 5. ������ˮ���������򣨼۸����� �������
				tool.showDoFruit();
				break;

			case 2:
				// 3. ����������µ�ˮ����ע��ˮ���Ƿ��Ѿ����ڣ�
				tool.addFruits();
				break;

			case 3:
				// 4. ���������ٿ��
				tool.shipment();
				break;
			case 4:
				// 6. ɾ��ָ��ˮ��������id��ˮ������
				tool.delFruits();
				break;
			case 5:
				// 7. �鿴�����ͳ�����¼
				tool.showShipmentMeg();
				break;
			case 7:
				// 8. �˳�ϵͳ
				isOver = true;
				System.out.println("���˳��ɹ�������");
				break;
			default:
				System.out.println("����������ȷ�Ĳ�����Ӧ����������");
				break;
			}
		} while (!isOver);
	}

	// login����
	private static void login() {
		System.out.println("================ˮ������ϵͳ===============");
		boolean isRight = false;
		do {
			System.out.print("�������ʺţ�");
			String inputName = Tool.sc.next();
			System.out.println();
			System.out.print("���������룺");
			int inputPwd = 0;
			try {
				inputPwd = Tool.sc.nextInt();
			} catch (Exception e) {
				System.out.println("������󣡣���������");
				Tool.sc.nextLine();
				continue;
			}
			if ("admin".equals(inputName) && inputPwd == 123 ) {
				isRight = true;
				System.out.println("=================����ɹ�����==============");
			} else {
				isRight = false;
				System.out.print("*�ʺ�/�����������򲻴��ڣ���");
				System.out.println();
			}

		} while (!isRight);

	}

}

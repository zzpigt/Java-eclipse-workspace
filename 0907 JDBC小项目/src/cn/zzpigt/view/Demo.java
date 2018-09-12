package cn.zzpigt.view;

import java.util.List;
import java.util.Scanner;

import cn.zzpigt.bean.Record;
import cn.zzpigt.bean.Users;
import cn.zzpigt.context.ApplicationContext;
import cn.zzpigt.service.RecordService;
import cn.zzpigt.service.UserService;
import cn.zzpigt.service.impl.RecordServiceImpl;
import cn.zzpigt.service.impl.UserServiceImpl;

public class Demo {

	static Scanner sc = new Scanner(System.in);
	private static UserService us;
	private static Users me;

	public static void main(String[] args) {
		//��ʼ��
		ApplicationContext.init();
		//
		us = (UserService) ApplicationContext.getBean("UserService");
		
		startMeun();

		// 4. ��Ǯ , ȡǮ , ת�˹���

	}

	private static void startMeun() {
		// ���ע��, ��¼����
		while (true) {
			System.out.println("ϵͳ���棺1-ע�ᣬ2-���룬3-�˳�");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				reg();
				break;
			case 2:
				login();
				break;
			case 3:
				sc.close();
				System.exit(0);
				break;

			default:
				break;
			}

		}
	}

	/**
	 * ���빦��
	 */
	private static void login() {
//		if(sc.hasNext()) {
//			sc.nextLine();
//		}
		
		System.out.println("������棺");
		System.out.println("�������û�����");
		System.out.println("���������룺");
		String name = sc.next();
		String pwd = sc.next();
		
		try {
			me = us.loginer(name, pwd);
			userMeun();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void userMeun() {
		// ��������
		System.out.println("�������棺");
		boolean isOver = false;
		do {
			System.out.println("1-��Ǯ��2-ȡǮ��3-ת�ˣ�4-�鿴��¼��5-�鿴��6-�˳�");
			int chose = sc.nextInt();
			switch (chose) {
			case 1:
				saveMoney();
				break;
			case 2:
				drawMoney();
				break;
			case 3:
				transfer();
				break;
			case 4:
				readMyLog();
				break;
			case 5:
				showMyMoney();
				break;
			case 6:
				isOver = true;
				break;

			default:
				break;
			}
			
		}while(!isOver);
	}

	private static void showMyMoney() {
		System.out.println("���������");
		double money;
		try {
			Users u = us.getMyMoney(me);
			System.out.println(u.getMoney());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void transfer() {
		System.out.println("��������Ҫת�˵Ķ����û�����");
		String name = sc.next();
		System.out.println("������ת�˵Ľ�");
		double money = sc.nextDouble();
		
		try {
			us.transfer(me,name,money);
			System.out.println("ת�˳ɹ�����");
		} catch (Exception e) {
			System.out.println("ת��ʧ�ܣ���");
			System.out.println(e.getMessage());
		}
		
	}

	private static void readMyLog() {
		System.out.println("�������ҵĲ�����¼��");
		try {
			RecordService rs = new RecordServiceImpl();
			List<Record> myLog = rs.getMyLog(me, ConnectionFactory.getConnection());
			for (Record record : myLog) {
				System.out.println(record);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void drawMoney() {
//		if(sc.hasNext()) {
//			sc.nextLine();
//		}
		System.out.println("������Ҫȡ�Ľ�");
		double money = sc.nextDouble();
		try {
			us.drawMoney(me,money);
			System.out.println("ȡǮ�ɹ�����");
		} catch (Exception e) {
			System.out.println("ȡǮʧ�ܣ���");
			System.out.println(e.getMessage());
		}
	}

	private static void saveMoney() {
//		if(sc.hasNext()) {
//			sc.nextLine();
//		}
		System.out.println("������Ҫ��Ľ�");
		double money = sc.nextDouble();
		try {
			us.saveMoney(me,money);
			System.out.println("��Ǯ�ɹ�����");
		} catch (Exception e) {
			System.out.println("��Ǯʧ�ܣ���");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * ע�Ṧ��
	 */
	private static void reg() {
		// ҵ���߼����û�ע�������û��������룬���ݿ��бȶ��û����Ƿ����
		System.out.println("ע����棺");
		System.out.println("�������û�����");
		System.out.println("���������룺");
		String name = sc.next();// �û���Ӧ����Ψһ�ģ��Լ�ȡ������
		String pwd = sc.next();
		
		try {
			us.register(name, pwd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}


}

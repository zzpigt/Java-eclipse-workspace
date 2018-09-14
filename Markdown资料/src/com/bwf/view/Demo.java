package com.bwf.view;

import java.util.List;
import java.util.Scanner;

import com.bwf.bean.Record;
import com.bwf.bean.User;
import com.bwf.context.ApplicationContext;
import com.bwf.service.UserService;
import com.bwf.service.impl.UserServiceImpl;

public class Demo {

	public static Scanner sc = new Scanner(System.in);
	
	private static UserService us;
	
	private static User me = null;
	
	public static void main(String[] args) {
		// �ȳ�ʼ��Ӧ�ó���������
		ApplicationContext.init();
		// �ٻ�ȡservice��ʵ��
		us = (UserService) ApplicationContext.getBean("UserService");
		
		System.out.println(us);
		
		startMenu();
	}

	
	/**
	 * ��¼��˵�
	 */
	private static void secondMenu() {
		boolean isOver = false;
		do {
			System.out.println("1-��Ǯ 2-ȡǮ 3-ת�� 4-�鿴��¼  5-�˳���¼");
			int chose = sc.nextInt();
			switch (chose) {
			case 1:
				saveMoney();
				break;
			case 2:
				drawMoney();
				break;
			case 3:
				tranMoney();
				break;
			case 4:
				showRecord();
				break;
			case 5:
				isOver = true;
				break;

			default:
				break;
			}
			
			
			
		}while(!isOver);
		
		
	}
	
	/**
	 * ת��
	 */
	private static void tranMoney() {
		System.out.println("����Ҫת���û���id:");
		int target = sc.nextInt();
		System.out.println("Ҫת�˵Ľ��:");
		double money = sc.nextDouble();
		
		try {
			us.tranMoney(me, target, money);
			System.out.println("�����ɹ���");
		} catch (Exception e) {
			System.out.println("����ʧ�ܣ�");
			System.out.println(e.getMessage());
		}
		
	}


	/**
	 * ȡǮ
	 */
	private static void drawMoney() {
		System.out.println("������Ҫȡ�Ľ��");
		
		double money = sc.nextDouble();
		
		try {
			us.drawMoney(me, money);
			System.out.println("�����ɹ�!");
		} catch (Exception e) {
			System.out.println("����ʧ��!");
			System.out.println(e.getMessage());
		}
		
	}


	/**
	 * �鿴��¼
	 */
	private static void showRecord() {
		
		System.out.println("���������Ĳ�����¼:");
		List<Record> list;
		try {
			list = us.getRecordList(me);
			for (Record record : list) {
				System.out.println(record);
			}
		} catch (Exception e) {
			
		}
		
		
	}


	private static void saveMoney() {
		System.out.println("����Ҫ��Ľ��:");
		double money = sc.nextDouble();
		
		try {
			us.saveMoney(me, money);
			System.out.println("�����ɹ�!");
		} catch (Exception e) {
			System.out.println("����ʧ��!");
			System.out.println(e.getMessage());
		}
		
	}


	public static void startMenu() {
		boolean isOver = false;
		do {
			
			System.out.println("1-ע�� 2-��¼ 3-�˳�");
			int chose = sc.nextInt();
			
			switch (chose) {
			case 1:
				regist();
				break;
				
			case 2:
				login();
				break;
				
			case 3:
				isOver = true;
				break;
				
			default:
				break;
			}
		}while(!isOver);
		
		
	}
	
	
	

	/**
	 * ��¼�˵�
	 */
	private static void login() {
		// �����һ�»���
		if(sc.hasNextLine()) {
			sc.nextLine();
		}
		System.out.println("�������û���:");
		String uname = sc.nextLine();
		System.out.println("����������");
		String upwd = sc.nextLine();
		// ����service�ĵ�¼����
		try {
			me = us.login(uname, upwd);
			System.out.println("��¼�ɹ�!");
			secondMenu();
		} catch (Exception e) {
			System.out.println("��¼ʧ��!");
			System.out.println(e.getMessage());
		}
	}



	/**
	 * ע��˵�
	 */
	private static void regist() {
		System.out.println("�������û���:");
		String uname = sc.next();
		System.out.println("����������");
		String upwd = sc.next();
		// ����serice���ж�
		try {
			us.regist(uname, upwd);
			System.out.println("ע��ɹ�!");
		} catch (Exception e) {
			System.out.println("ע��ʧ�ܣ�");
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
}

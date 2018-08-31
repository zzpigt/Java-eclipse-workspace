package cn.zzpigt.fruits;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Tool {

	static Scanner sc = new Scanner(System.in);
	static int count = 0;

	// ���ﻹ��Ҫһ����¼���н�������Ϣ�Ĵ洢��ʱ��Ļ���Map
	static Map<String, Fruits> fmeg = new TreeMap<>();
	static List<Fruits> flist = new LinkedList<>();

	// ����ʱ��ķ���
	private String getTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		return time;
	}

	// ��ʾ����ˮ��
	private static void showAllFruits() {
		System.out.println("=============����ˮ������Ϣ============");
		System.out.println("ID\tˮ����\t����\t�۸�");
		for (Iterator iterator = flist.iterator(); iterator.hasNext();) {
			Fruits fruit = (Fruits) iterator.next();
			System.out.println(
					fruit.getID() + "\t" + fruit.getName() + "\t" + fruit.getfNum() + "\t" + fruit.getfPrice());
		}
		System.out.println("=======================================");
	}

	// ˮ���Ľ���������Ӳ���
	public void addFruits() { 
		boolean isOver = false;
		do {
			System.out.println("�����ˮ��������˳��<ˮ����><����><�۸�>�����м��ÿո����,��exit���˳�����");
			String addName = sc.next();
			if ("exit".equals(addName)) {
				// sc.nextLine();
				isOver = true;
				System.out.println("����ӽ���������");
				break;
			}
			int addFNum = 0;
			double addFPrice = 0;
			try {
				addFNum = sc.nextInt();
				addFPrice = sc.nextDouble();
			} catch (Exception e) {
				System.out.println("��ע�⡿���������д��󣡣�");
				sc.nextLine();
				continue;
			}
			Fruits nFruit = new Fruits(count++, addName, addFNum, addFPrice);

			if (flist.contains(nFruit)) {
				flist.get(flist.indexOf(nFruit)).setfNum(addFNum + flist.get(flist.indexOf(nFruit)).getfNum());
				flist.get(flist.indexOf(nFruit)).setfPrice(addFPrice);
			} else {
				flist.add(nFruit);
			}

			fmeg.put(getTime() + "��������", new Fruits(nFruit.getID(), addName, addFNum, addFPrice));
		} while (!isOver);
	}

	// ˮ���ĳ�������
	public void shipment() {
		showAllFruits();
		boolean isOver = false;
		do {
			System.out.println("����д������������˳��<ˮ��ID><����><�۸�>�����м��ÿո��������exit���˳�����");
			int smFId=0;
			int smFnum=0;
			double smFPrice = 0;
			try {
				smFId = sc.nextInt();
				smFnum = sc.nextInt();
				smFPrice = sc.nextDouble();
			} catch (Exception e) {
				if("exit".equals(sc.nextLine())) {
					break;
				}
				System.out.println("�������ͳ�����");				
				continue;
			}

			// ������Ҫ��ѯ����ôֻ���õ�������(ID��Ψһ��)
			for (Iterator iterator = flist.iterator(); iterator.hasNext();) {
				Fruits fruits = (Fruits) iterator.next();
				if (fruits.getID() == smFId) {
					if (fruits.getfNum() > smFnum) {// ����㹻
						fruits.setfNum(fruits.getfNum() - smFnum);
						isOver = true;
					} else if (fruits.getfNum() == smFnum) {// ��ֺ���ѡ�����ˮ��ɾ��
						iterator.remove();
						System.out.println(fruits.getName() + "ȫ�������꣡��");
						isOver = true;
					} else {
						System.out.println("��û����ô����������³�������");
						break;
					}
					System.out.println("�������ɹ���");
					fmeg.put(getTime() + "��������", new Fruits(smFId, fruits.getName(), smFnum, smFPrice));
				}
			}

		} while (!isOver);
	}

	// ��ʾˮ�������н�������ɾ���ļ�¼
	public void showShipmentMeg() {
		System.out.println("���������н��������ļ�¼��");
		System.out.println("ʱ��\t\t\t\t��¼");
		Set<Entry<String, Fruits>> entrySet = fmeg.entrySet();
		for (Entry<String, Fruits> entry : entrySet) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}

	// �鿴ˮ������������ˮ����Ȼ����Խ�������Ĳ���
	public void showDoFruit() {
		boolean isQuit = false;
		do {
			showAllFruits();
			System.out.println("ѡ����Ĳ�����");
			System.out.println("1)���۸�����\n2)���������\n3)������һ��");
			int inputNum = 0;
			try {
				inputNum = sc.nextInt();
			} catch (Exception e) {
				System.out.println("���������Ӧ����������������");
				sc.nextLine();
			}
			switch (inputNum) {
			case 1:
				// �۸�
				Collections.sort(flist, new Comparator<Fruits>() {
					@Override
					public int compare(Fruits o1, Fruits o2) {
						if (o1.getfPrice() > o2.getfPrice()) {
							return 1;
						} else if (o1.getfPrice() < o2.getfPrice()) {
							return -1;
						} else {
							return 0;
						}
					}

				});
				break;
			case 2:
				// ���
				Collections.sort(flist, new Comparator<Fruits>() {
					@Override
					public int compare(Fruits o1, Fruits o2) {
						return o1.getfNum() - o2.getfNum();
					}
				});
				break;
			case 3:
				// ����
				Collections.sort(flist);
				isQuit = true;
				break;
			default:
				break;
			}
		} while (!isQuit);

	}

	// ˮ�����ϵ�ɾ������
	public void delFruits() {
		showAllFruits();
		boolean isOver = false;
		do {
			System.out.println("�����������Ҫɾ����ˮ��ID��ˮ������(����exit���˳�)");
			int delFId = 0;
			try {
				delFId = sc.nextInt();
			} catch (Exception e) {
				if ("exit".equals(sc.nextLine())) {
					break;
				}
				System.out.println("������󣡣���");
				continue;
			}
			String delFName = sc.next();
			// ɾ��ˮ��
			for (Iterator iterator = flist.iterator(); iterator.hasNext();) {
				Fruits fruits = (Fruits) iterator.next();
				if (fruits.getID() == delFId && fruits.getName().equals(delFName)) {
					System.out.println("���Ƿ�ɾ��" + delFName + "���� (Y/N������������Ĭ��ΪN):");
					String isDel = sc.next();
					if ("Y".equals(isDel) || "y".equals(isDel)) {
						Fruits delF = new Fruits(fruits.getID(), fruits.getName(), fruits.getfNum(),
								fruits.getfPrice());
						fmeg.put(getTime() + "��ɾ����", delF);
						iterator.remove();
						System.out.println("ɾ���ɹ�����");
						isOver = true;
						break;
					} else {
						System.out.println("ȡ����ɾ��������");
						isOver = true;
						break;
					}
				}
			}
			if (!isOver)
				System.out.println("����û�гɹ����������������룡��");

		} while (!isOver);

	}

}

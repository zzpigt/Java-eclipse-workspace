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

	// 这里还需要一个记录所有进出货信息的存储有时间的话，Map
	static Map<String, Fruits> fmeg = new TreeMap<>();
	static List<Fruits> flist = new LinkedList<>();

	// 处理时间的方法
	private String getTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		return time;
	}

	// 显示所有水果
	private static void showAllFruits() {
		System.out.println("=============所有水果的信息============");
		System.out.println("ID\t水果名\t数量\t价格");
		for (Iterator iterator = flist.iterator(); iterator.hasNext();) {
			Fruits fruit = (Fruits) iterator.next();
			System.out.println(
					fruit.getID() + "\t" + fruit.getName() + "\t" + fruit.getfNum() + "\t" + fruit.getfPrice());
		}
		System.out.println("=======================================");
	}

	// 水果的进货处理，添加操作
	public void addFruits() { 
		boolean isOver = false;
		do {
			System.out.println("请添加水果【输入顺序：<水果名><数量><价格>】（中间用空格隔开,【exit】退出）：");
			String addName = sc.next();
			if ("exit".equals(addName)) {
				// sc.nextLine();
				isOver = true;
				System.out.println("【添加结束！！】");
				break;
			}
			int addFNum = 0;
			double addFPrice = 0;
			try {
				addFNum = sc.nextInt();
				addFPrice = sc.nextDouble();
			} catch (Exception e) {
				System.out.println("【注意】输入类型有错误！！");
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

			fmeg.put(getTime() + "【进货】", new Fruits(nFruit.getID(), addName, addFNum, addFPrice));
		} while (!isOver);
	}

	// 水果的出货处理
	public void shipment() {
		showAllFruits();
		boolean isOver = false;
		do {
			System.out.println("请填写出货单【输入顺序：<水果ID><数量><价格>】（中间用空格隔开，【exit】退出）：");
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
				System.out.println("输入类型出错！！");				
				continue;
			}

			// 这里需要查询，那么只有用迭代器做(ID是唯一的)
			for (Iterator iterator = flist.iterator(); iterator.hasNext();) {
				Fruits fruits = (Fruits) iterator.next();
				if (fruits.getID() == smFId) {
					if (fruits.getfNum() > smFnum) {// 库存足够
						fruits.setfNum(fruits.getfNum() - smFnum);
						isOver = true;
					} else if (fruits.getfNum() == smFnum) {// 清仓后我选择这个水果删除
						iterator.remove();
						System.out.println(fruits.getName() + "全部出货完！！");
						isOver = true;
					} else {
						System.out.println("并没有那么多货！！重新出货！！");
						break;
					}
					System.out.println("【出货成功】");
					fmeg.put(getTime() + "【出货】", new Fruits(smFId, fruits.getName(), smFnum, smFPrice));
				}
			}

		} while (!isOver);
	}

	// 显示水果的所有进货出货删除的记录
	public void showShipmentMeg() {
		System.out.println("以下是所有进货出货的记录：");
		System.out.println("时间\t\t\t\t记录");
		Set<Entry<String, Fruits>> entrySet = fmeg.entrySet();
		for (Entry<String, Fruits> entry : entrySet) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}

	// 查看水果集合中所有水果，然后可以进行排序的操作
	public void showDoFruit() {
		boolean isQuit = false;
		do {
			showAllFruits();
			System.out.println("选择你的操作：");
			System.out.println("1)按价格排序\n2)按库存排序\n3)返回上一级");
			int inputNum = 0;
			try {
				inputNum = sc.nextInt();
			} catch (Exception e) {
				System.out.println("【请输入对应操作的整数！！】");
				sc.nextLine();
			}
			switch (inputNum) {
			case 1:
				// 价格
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
				// 库存
				Collections.sort(flist, new Comparator<Fruits>() {
					@Override
					public int compare(Fruits o1, Fruits o2) {
						return o1.getfNum() - o2.getfNum();
					}
				});
				break;
			case 3:
				// 返回
				Collections.sort(flist);
				isQuit = true;
				break;
			default:
				break;
			}
		} while (!isQuit);

	}

	// 水果集合的删除操作
	public void delFruits() {
		showAllFruits();
		boolean isOver = false;
		do {
			System.out.println("请谨慎输入你要删除的水果ID和水果名：(输入exit可退出)");
			int delFId = 0;
			try {
				delFId = sc.nextInt();
			} catch (Exception e) {
				if ("exit".equals(sc.nextLine())) {
					break;
				}
				System.out.println("输入错误！！！");
				continue;
			}
			String delFName = sc.next();
			// 删除水果
			for (Iterator iterator = flist.iterator(); iterator.hasNext();) {
				Fruits fruits = (Fruits) iterator.next();
				if (fruits.getID() == delFId && fruits.getName().equals(delFName)) {
					System.out.println("【是否删除" + delFName + "！】 (Y/N，输入其它都默认为N):");
					String isDel = sc.next();
					if ("Y".equals(isDel) || "y".equals(isDel)) {
						Fruits delF = new Fruits(fruits.getID(), fruits.getName(), fruits.getfNum(),
								fruits.getfPrice());
						fmeg.put(getTime() + "【删除】", delF);
						iterator.remove();
						System.out.println("删除成功！！");
						isOver = true;
						break;
					} else {
						System.out.println("取消了删除！！！");
						isOver = true;
						break;
					}
				}
			}
			if (!isOver)
				System.out.println("操作没有成功！！！！重新输入！！");

		} while (!isOver);

	}

}

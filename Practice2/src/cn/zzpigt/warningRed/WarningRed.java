package cn.zzpigt.warningRed;

import java.util.Random;
import java.util.Scanner;

public class WarningRed {
	
	public static Soldier[] me;
	public static Soldier[] pc;
	public static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		init();
		choseWeapon();
		Pk();
		over();
	}
	
	//1：敌我双方各初始化10名士兵
	public static void init() {
		me = new Soldier[10];
		pc = new Soldier[10];
	}
	//2：依次为10名士兵配备武器（我方由控制台选择武器，敌方随机武器）
	public static void choseWeapon() {
		//先分配我方武器
		for (int i = 0; i < me.length; i++) {
			System.out.println("为我方第"+i+"号士兵选择武器：1-手枪，2-机枪，3-钢炮：");
			int chose = sc.nextInt()-1;
			me[i] = new Soldier(new Weapon[]{new Handgun(), new MachineGun(), new Cannon()}[chose]); 
		}
		//为敌方自动生成10名士兵
		System.out.println("敌方阵营自动生成！！！");
		for (int i = 0; i < pc.length; i++) {
			int chose = new Random().nextInt(3);
			pc[i] = new Soldier(new Weapon[]{new Handgun(), new MachineGun(), new Cannon()}[chose]); 
		}
		showSoldier();
		
	}
	
	//打印双方的阵营pvp
	public static void showSoldier() {
		for (int i = 0; i < me.length; i++) {
			System.out.print(i+"号"+me[i].weapon.name+"兵【HP:"+me[i].Hp+"】"+"  \t");
			if(i%2 == 1) {
				System.out.println();
			}
			
		}
		System.out.println();
		System.out.println("================pvp==============");
		for (int i = 0; i < pc.length; i++) {
			System.out.print(i+"号"+pc[i].weapon.name+"兵【HP:"+pc[i].Hp+"】"+"  \t");
			if(i%2 == 1) {
				System.out.println();
			}
		}
		
	}
	
	//3：双方每回合攻击一次（我方由控制台选择攻击目标，敌方随机攻击目标）
	//4：生命值降为0的士兵将不能行动
	//5：武器弹药为0的士兵当前回合将填充弹药（消耗1回合）
	public static void Pk() {
		boolean isOver = false;
		do {
			int countMe = 0;
			int countPc = 0;
			System.out.println("请输入我方攻击的目标：");
			int target = sc.nextInt();
			for (int i = 0; i < me.length; i++) {
				me[i].attack(pc[target]);
				
			}
			int random = new Random().nextInt(10);
			System.out.println("现在敌方选择攻击我方"+random+"号士兵.....");
			for (int i = 0; i < pc.length; i++) {
				pc[i].attack(me[random]);
			}
			showSoldier();
			for (int i = 0; i < me.length; i++) {
				if (me[i].Hp<=0) {
					countMe++;
				}
			}
			for (int i = 0; i < pc.length; i++) {
				if (pc[i].Hp<=0) {
					countPc++;
				}
			}
			if(countMe==10||countPc==10) {
				isOver = true;
			}
		}while(!isOver);
	}
	
	//6：一方士兵全部阵亡后，宣布结果
	public static void over() {
		int countMe = 0;
		int countPc = 0;
		for (int i = 0; i < me.length; i++) {
			if (me[i].Hp<=0) {
				countMe++;
			}
		}
		for (int i = 0; i < pc.length; i++) {
			if (pc[i].Hp<=0) {
				countPc++;
			}
		}
		
		System.out.println("============对战结果==========");
		if(countMe==10) {
			System.out.println("电脑胜利！！！");
		}else if(countPc == 10){
			System.out.println("我们赢了！！！");
		}
	}
	
	
}

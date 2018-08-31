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
	
	//1������˫������ʼ��10��ʿ��
	public static void init() {
		me = new Soldier[10];
		pc = new Soldier[10];
	}
	//2������Ϊ10��ʿ���䱸�������ҷ��ɿ���̨ѡ���������з����������
	public static void choseWeapon() {
		//�ȷ����ҷ�����
		for (int i = 0; i < me.length; i++) {
			System.out.println("Ϊ�ҷ���"+i+"��ʿ��ѡ��������1-��ǹ��2-��ǹ��3-���ڣ�");
			int chose = sc.nextInt()-1;
			me[i] = new Soldier(new Weapon[]{new Handgun(), new MachineGun(), new Cannon()}[chose]); 
		}
		//Ϊ�з��Զ�����10��ʿ��
		System.out.println("�з���Ӫ�Զ����ɣ�����");
		for (int i = 0; i < pc.length; i++) {
			int chose = new Random().nextInt(3);
			pc[i] = new Soldier(new Weapon[]{new Handgun(), new MachineGun(), new Cannon()}[chose]); 
		}
		showSoldier();
		
	}
	
	//��ӡ˫������Ӫpvp
	public static void showSoldier() {
		for (int i = 0; i < me.length; i++) {
			System.out.print(i+"��"+me[i].weapon.name+"����HP:"+me[i].Hp+"��"+"  \t");
			if(i%2 == 1) {
				System.out.println();
			}
			
		}
		System.out.println();
		System.out.println("================pvp==============");
		for (int i = 0; i < pc.length; i++) {
			System.out.print(i+"��"+pc[i].weapon.name+"����HP:"+pc[i].Hp+"��"+"  \t");
			if(i%2 == 1) {
				System.out.println();
			}
		}
		
	}
	
	//3��˫��ÿ�غϹ���һ�Σ��ҷ��ɿ���̨ѡ�񹥻�Ŀ�꣬�з��������Ŀ�꣩
	//4������ֵ��Ϊ0��ʿ���������ж�
	//5��������ҩΪ0��ʿ����ǰ�غϽ���䵯ҩ������1�غϣ�
	public static void Pk() {
		boolean isOver = false;
		do {
			int countMe = 0;
			int countPc = 0;
			System.out.println("�������ҷ�������Ŀ�꣺");
			int target = sc.nextInt();
			for (int i = 0; i < me.length; i++) {
				me[i].attack(pc[target]);
				
			}
			int random = new Random().nextInt(10);
			System.out.println("���ڵз�ѡ�񹥻��ҷ�"+random+"��ʿ��.....");
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
	
	//6��һ��ʿ��ȫ���������������
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
		
		System.out.println("============��ս���==========");
		if(countMe==10) {
			System.out.println("����ʤ��������");
		}else if(countPc == 10){
			System.out.println("����Ӯ�ˣ�����");
		}
	}
	
	
}

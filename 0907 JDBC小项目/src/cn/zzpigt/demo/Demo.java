package cn.zzpigt.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import cn.zzpigt.bean.Record;
import cn.zzpigt.bean.Users;
import cn.zzpigt.dao.impl.RecordDaoImpl;
import cn.zzpigt.dao.impl.UsersDaoImpl;

public class Demo {

	static Scanner  sc = new Scanner(System.in);
	public static void main(String[] args) {
		// ���ע��, ��¼����
		while(true) {
			System.out.println("ϵͳ���棺1-ע�ᣬ2-���룬3-�˳�");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				register();
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
		
		
		
		
		//4. ��Ǯ , ȡǮ , ת�˹���

	}
	
	/**
	 * ���빦��
	 */
	private static void login() {
		System.out.println("������棺");
		System.out.println("�������û�����");
		System.out.println("���������룺");
		String name = sc.next();
		String pwd = sc.next();
		UsersDaoImpl ud = new UsersDaoImpl();
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			boolean sl = ud.isSuccessLogin(name, pwd, conn);
			if(sl) {
				//����ɹ�,�����������
				userMeun();
				//��¼��־
				writeLog(conn);
			}else {
				//����ʧ��
				boolean sameName = ud.isSameName(name, conn);
				if(sameName) {
					//�������
					System.out.println("�����������д���룡��");
				}else {
					//�û�������
					System.out.println("�û������ڣ�����ȥע�ᣡ��");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void userMeun() {
		//��������
		System.out.println("�������棡��");
	}

	/**
	 * ע�Ṧ��
	 */
	private static void register() {
		//ҵ���߼����û�ע�������û��������룬���ݿ��бȶ��û����Ƿ����
		System.out.println("ע����棺");
		System.out.println("�������û�����");
		System.out.println("���������룺");
		String name = sc.next();//�û���Ӧ����Ψһ�ģ��Լ�ȡ������
		String pwd = sc.next();
		UsersDaoImpl ud = new UsersDaoImpl();
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			boolean issameName = ud.isSameName(name, conn);
			if(issameName) {
				//�û����Ѿ�����
				System.out.println("�û����Ѿ����ڣ�����");
			}else {
				//�û�����ע��
				ud.insert(new Users(null, name, pwd, 0.0), conn);
				//������¼�Ϳ��Է���־��
				writeLog(conn);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	private static void writeLog(Connection conn) throws SQLException {
		String connect = UsersDaoImpl.lastSql;
		System.out.println(connect);
		String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss ").format(new Date());
		new RecordDaoImpl().insert(new Record(null,connect,date), conn);
	}

}

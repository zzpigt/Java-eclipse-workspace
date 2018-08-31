package cn.zzpigt.file;

import java.io.File;
import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		// 1. ����һ����Ŀ¼�����ڵ��ļ�
		//
		File file = new File("D:\\a\\b\\c.txt");
		// File dirFile = new File("D:\\a\\b");
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// if(dirFile.mkdirs()) {
		// try {
		// if(file.createNewFile()) {
		// System.out.println("�����ɹ�����");
		// }
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }

		//
		// 2. ��װ����,����File����,��ӡ��ȡ�����ļ�������Ϣ
		// �ļ���
		System.out.println("�ļ���:" + file.getName());
		// �ļ�·��
		System.out.println("�ļ�·��:" + file.getPath());
		// ����·��
		System.out.println("����·��:" + file.getAbsolutePath());

		// ���ļ�������
		System.out.println("���ļ�������:" + file.getParent());
		// �ļ��Ƿ����
		System.out.println("�ļ��Ƿ����" + file.exists());
		// �ļ��Ƿ��д
		System.out.println("�ļ��Ƿ��д:" + file.canWrite());
		// �ļ��Ƿ�ɶ�
		System.out.println("�ļ��Ƿ�ɶ�:" + file.canRead());
		// �ļ��ǲ���Ŀ¼
		System.out.println("�ļ��ǲ���Ŀ¼:" + file.isDirectory());
		// �ļ��ǲ����ļ�
		System.out.println("�ļ��ǲ����ļ�" + file.isFile());
		// ·���ǲ��Ǿ���·��
		System.out.println("·���ǲ��Ǿ���·��:" + file.isAbsolute());
		// �ļ�����޸�ʱ��
		System.out.println("�ļ�����޸�ʱ��:" + file.lastModified());
		// �ļ���С
		System.out.println("�ļ���С:" + file.getTotalSpace());

	}
}

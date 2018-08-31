package cn.zzpigt.Thread;

import java.util.Random;

public class StudyFar extends Thread {
	private String answer = null;
	private boolean isDone = false;// ѧ�������ˣ�����û�𳭺�

	// ��ѧ����
	public synchronized String getAnswer() {
		if (!isDone) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isDone = false;
		notify();
		return answer;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++){
			WriteAns();
		}
	}

	// �Լ�����
	private synchronized void WriteAns() {

		if (isDone) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

//		try {
//			sleep(500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		String[] ans = { "A", "B", "C", "D" };
		int ran = new Random().nextInt(4);
		System.out.println("ѧ��ѡ����" + ans[ran]);
		answer = ans[ran];
		isDone = true;
		notify();

	}

}

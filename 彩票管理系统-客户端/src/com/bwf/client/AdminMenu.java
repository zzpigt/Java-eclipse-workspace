package com.bwf.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.bwf.jar.MyRequest;
import com.bwf.jar.MyResponse;

public class AdminMenu {
	private ObjectOutputStream oos;
	private MyResponse lastResponse;

	public AdminMenu(ObjectOutputStream oos, MyResponse lastResponse) {
		this.oos = oos;
		this.lastResponse = lastResponse;
	}

	public void amdinMenu(String uName) throws IOException {
		boolean isOver = false;
		do {
			System.out.println(uName + "����Ա����ӭ���ĵ��룡��");

			System.out.println("ѡ���ܣ�1-������2-��ѯ������Ϣ��3-���򣨲�ѯ�����в�����Ϣ����");
			int chose = ClientDemo.sc.nextInt();
			switch (chose) {
			case 1:
				issue(uName);
				continue;
			case 2:
				findBuyer(uName);
				continue;
			case 3:
				sortBuyer(uName);
				continue;
			case 4:
				AdminLogout(uName);

			default:
				break;
			}

		} while (!isOver);

	}

	private void AdminLogout(String uName) throws IOException {
		System.out.println("������ʾ���Ƿ�Ҫ�˳���Y/N");
		String chose = ClientDemo.sc.next();
		if ("y".equals(chose) || "Y".equals(chose)) {

			MyRequest request = new MyRequest(MyRequest.TYPE_ADMIN_LOGOUT);
			request.getUmap().put(MyRequest.MEG_USERNAME, uName);
			request.getUmap().put(MyRequest.MEG_LEVEL, "����Ա");
			// ��װ���ˣ��ͷ��͹�ȥ�����л�
			oos.writeObject(request);
			oos.flush();

		}

	}

	private void issue(String uName) throws IOException {
		if (lastResponse.isIssue()) {
			System.out.println("���ڲ�Ʊ��δ���������ܷ�����һ�ڣ���");
			return;
		}
		//ȥ֪ͨ�����������в�����Ϣ
		MyRequest request2 = new MyRequest(MyRequest.TYPE_ADMIN_GETHISTORY);
		request2.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request2.getUmap().put(MyRequest.MEG_LEVEL, "����Ա");

		// ��װ���ˣ��ͷ��͹�ȥ�����л�
		oos.writeObject(request2);
		oos.flush();

		// ���Է���
		System.out.println("��������һ�ڲ�Ʊ�ĵ��ۣ�");
		String newPrice = ClientDemo.sc.next();

		MyRequest request = new MyRequest(MyRequest.TYPE_ADMIN_ISSUE);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_LEVEL, "����Ա");
		request.getUmap().put(MyRequest.LOTTERY_NEWPRICE, newPrice);
		// ��װ���ˣ��ͷ��͹�ȥ�����л�
		oos.writeObject(request);
		oos.flush();

		synchronized (ClientDemo.class) {
			if (ClientDemo.lastResponse == null) {
				try {
					ClientDemo.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// ��������Ϣ
			MyResponse lastResponse = ClientDemo.lastResponse;
			ClientDemo.lastResponse = null;
			System.out.println(lastResponse.getrMeg().get(MyResponse.MEG_CONTENT));
			// �õ����еĲ�Ʊ��Ϣ
			List<String> lotteryMeg = lastResponse.getHistoryList();
			int pageNum = 5;// ÿҳ5����Ϣ
			Integer pageCount = null;
			if (lotteryMeg.size() % pageNum > 0) {
				pageCount = lotteryMeg.size() / pageNum + 1;
			} else {
				pageCount = lotteryMeg.size() / pageNum;
			}

//			int pageCount = (int) Math.ceil(buyerMeg.size()/pageNum);//�ж���ҳ
			// 1-[0,4] 2-[5,9] 3-[11,15]

			System.out.println("������Ҫ��ת��ҳ������" + pageCount + "ҳ��");
			int page = ClientDemo.sc.nextInt();
			List<String> pageMeg = getMegByPage((page * pageNum - 5), lotteryMeg);

			for (String p : pageMeg) {
				System.out.println(p);
			}

			ClientDemo.class.notify();
		}

	}

	private void findBuyer(String uName) throws IOException {
		System.out.println("��������Ҫ��ѯ�Ĳ���ı�ţ�");
		String buyerId = ClientDemo.sc.next();

		MyRequest request = new MyRequest(MyRequest.TYPE_ADMIN_FINDBUYER);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_LEVEL, "����Ա");
		request.getUmap().put(MyRequest.ADMIN_BUYERID, buyerId);
		// ��װ���ˣ��ͷ��͹�ȥ�����л�
		oos.writeObject(request);
		oos.flush();

		synchronized (ClientDemo.class) {
			if (ClientDemo.lastResponse == null) {
				try {
					ClientDemo.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// ��������Ϣ
			MyResponse lastResponse = ClientDemo.lastResponse;
			ClientDemo.lastResponse = null;
			System.out.println(lastResponse.getrMeg().get(MyResponse.MEG_CONTENT));
			// ��ѯ�ֳɹ�ʧ��,�ɹ��ǰѲ�ѯ���Ĳ�����Ϣ����historylist�з��ع�����
			if (lastResponse.isSuccess()) {
				// ��ʾ��Ϣ
				List<String> buyerMeg = lastResponse.getHistoryList();
				System.out.println(buyerId);
			} else {
				System.out.println("��ѯʧ�ܣ����������룡��");
			}

			ClientDemo.class.notify();
		}

	}

	private void sortBuyer(String uName) throws IOException {
		System.out.println("��ѡ������ʽ��1-���ʺ�����2-���������");
		String sort = ClientDemo.sc.next();
		switch (sort) {
		case "�ʺ�":
			sortById(uName);
			break;
		case "���":
			sortByMoney(uName);
			break;

		default:
			break;
		}

		synchronized (ClientDemo.class) {
			if (ClientDemo.lastResponse == null) {
				try {
					ClientDemo.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// ��������Ϣ
			MyResponse lastResponse = ClientDemo.lastResponse;
			ClientDemo.lastResponse = null;
			System.out.println(lastResponse.getrMeg().get(MyResponse.MEG_CONTENT));
			// ������õĲ�����Ϣ����historylist�з��ع�����
			List<String> buyerMeg = lastResponse.getHistoryList();
			for (String b : buyerMeg) {
				System.out.println(b);
			}

			ClientDemo.class.notify();
		}

	}

	private List<String> getMegByPage(int start, List<String> buyerMeg) {
		List<String> pageList = new ArrayList<>();
		;
		for (int i = start; i < buyerMeg.size() && i <= (start + 4); i++) {
			pageList.add(buyerMeg.get(i));
		}
		return pageList;
	}

	private void sortByMoney(String uName) throws IOException {
		MyRequest request = new MyRequest(MyRequest.TYPE_ADMIN_SORTBUYER_BYMONEY);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_LEVEL, "����Ա");
		// ��װ���ˣ��ͷ��͹�ȥ�����л�
		oos.writeObject(request);
		oos.flush();

	}

	private void sortById(String uName) throws IOException {
		MyRequest request = new MyRequest(MyRequest.TYPE_ADMIN_SORTBUYER_BYID);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_LEVEL, "����Ա");
		// ��װ���ˣ��ͷ��͹�ȥ�����л�
		oos.writeObject(request);
		oos.flush();

	}

}

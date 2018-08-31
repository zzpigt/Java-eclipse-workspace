package cn.zzpigt.client;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import cn.zzpigt.bean.MyRequest;
import cn.zzpigt.bean.MyResponse;

public class ClientMenu {
	private Socket socket;
	private ObjectOutputStream oos;
	private String uName;

	public ClientMenu(Socket socket) throws IOException {
		super();
		this.socket = socket;
		oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
	}

	// ��������пͻ��˵Ĳ˵�����

	public void startMenu() throws IOException {
		while (true) {
			System.out.println("����ϵͳ��");
			System.out.println("1.ע��");
			System.out.println("2.����");
			System.out.println("3.�˳�");

			int chose = ClientDemo.sc.nextInt();

			switch (chose) {
			case MyRequest.TYPE_REGIST:
				regist();
				break;
			case MyRequest.TYPE_LOGIN:
				login();
				break;
			case 3:
				logout();
				break;

			default:
				break;
			}
		}

	}

	private void logout() throws IOException {
		tellServer();
		System.exit(0);
	}

	private void login() throws IOException {
		System.out.println("����룺");
		System.out.println("�������û�����");
		String uName = ClientDemo.sc.next();
		System.out.println("���������룺");
		String uPwd = ClientDemo.sc.next();

		// ��װ��һ����
		MyRequest request = new MyRequest(MyRequest.TYPE_LOGIN);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_USERPWD, uPwd);

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
			// �жϵ����Ƿ�ɹ����ɹ������������棬���ɹ��ͷ��ص���ʼ����
			if (lastResponse.isSuccess()) {
				// ��������
				this.uName = uName;
				chatMenu();
			} else {
				startMenu();
			}

			ClientDemo.class.notify();
		}

	}

	private void chatMenu() throws IOException {
		while (true) {

			System.out.println("1.����, 2.Ⱥ��  3.����");
			int nextInt = ClientDemo.sc.nextInt();
			switch (nextInt) {
			case 1:
				singleChat();
				break;
			case 2:
				moreChat();
				break;
			case 3:
				tellServer();
				startMenu();
				break;

			default:
				break;
			}
		}

	}

	private void tellServer() throws IOException {
		MyRequest request = new MyRequest(MyRequest.TYPE_LOGOUT);
		request.getUmap().put(MyRequest.MEG_CHATCONTENT, "�û�����!!!");
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		
		oos.writeObject(request);
		oos.flush();
		
	}

	private void moreChat() throws IOException {
		System.out.println("=============Ⱥ��=============");
		System.out.println(":  ");

		String str = ClientDemo.sc.next();

		MyRequest request = new MyRequest(MyRequest.TYPE_MORECHAT);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_CHATCONTENT, str);

		oos.writeObject(request);
		oos.flush();

	}

	private void singleChat() throws IOException {
		System.out.println("=============����=============");
		System.out.println("��������Ҫ���ĵ��û�����");
		String chatToName = ClientDemo.sc.next();
		System.out.println("��������Ҫ����˵�Ļ�:  ");
		String chatContent = ClientDemo.sc.next();

		MyRequest request = new MyRequest(MyRequest.TYPE_SINGLECHAT);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_CHAT_TO_USERNAME, chatToName);
		request.getUmap().put(MyRequest.MEG_CHATCONTENT, chatContent);

		oos.writeObject(request);
		oos.flush();

	}

	private void regist() throws IOException {
		// �����û�������û���������
		System.out.println("��ע�᣺");
		System.out.println("�������û�����");
		String uName = ClientDemo.sc.next();
		System.out.println("���������룺");
		String uPwd = ClientDemo.sc.next();

		// ��װ��һ����
		MyRequest request = new MyRequest(MyRequest.TYPE_REGIST);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_USERPWD, uPwd);

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
			startMenu();
			notify();
		}

	}

}

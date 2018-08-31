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

	// 这里放所有客户端的菜单方法

	public void startMenu() throws IOException {
		while (true) {
			System.out.println("聊天系统：");
			System.out.println("1.注册");
			System.out.println("2.登入");
			System.out.println("3.退出");

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
		System.out.println("请登入：");
		System.out.println("请输入用户名：");
		String uName = ClientDemo.sc.next();
		System.out.println("请输入密码：");
		String uPwd = ClientDemo.sc.next();

		// 包装成一个类
		MyRequest request = new MyRequest(MyRequest.TYPE_LOGIN);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_USERPWD, uPwd);

		// 包装好了，就发送过去，序列化
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

			// 读到了消息
			MyResponse lastResponse = ClientDemo.lastResponse;
			ClientDemo.lastResponse = null;
			System.out.println(lastResponse.getrMeg().get(MyResponse.MEG_CONTENT));
			// 判断登入是否成功，成功则进入操作界面，不成功就返回到开始界面
			if (lastResponse.isSuccess()) {
				// 操作界面
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

			System.out.println("1.单聊, 2.群聊  3.下线");
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
		request.getUmap().put(MyRequest.MEG_CHATCONTENT, "用户下线!!!");
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		
		oos.writeObject(request);
		oos.flush();
		
	}

	private void moreChat() throws IOException {
		System.out.println("=============群聊=============");
		System.out.println(":  ");

		String str = ClientDemo.sc.next();

		MyRequest request = new MyRequest(MyRequest.TYPE_MORECHAT);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_CHATCONTENT, str);

		oos.writeObject(request);
		oos.flush();

	}

	private void singleChat() throws IOException {
		System.out.println("=============单聊=============");
		System.out.println("请输入你要单聊的用户名：");
		String chatToName = ClientDemo.sc.next();
		System.out.println("请输入你要对他说的话:  ");
		String chatContent = ClientDemo.sc.next();

		MyRequest request = new MyRequest(MyRequest.TYPE_SINGLECHAT);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_CHAT_TO_USERNAME, chatToName);
		request.getUmap().put(MyRequest.MEG_CHATCONTENT, chatContent);

		oos.writeObject(request);
		oos.flush();

	}

	private void regist() throws IOException {
		// 接受用户输入的用户名和密码
		System.out.println("请注册：");
		System.out.println("请输入用户名：");
		String uName = ClientDemo.sc.next();
		System.out.println("请输入密码：");
		String uPwd = ClientDemo.sc.next();

		// 包装成一个类
		MyRequest request = new MyRequest(MyRequest.TYPE_REGIST);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_USERPWD, uPwd);

		// 包装好了，就发送过去，序列化
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

			// 读到了消息
			MyResponse lastResponse = ClientDemo.lastResponse;
			ClientDemo.lastResponse = null;
			System.out.println(lastResponse.getrMeg().get(MyResponse.MEG_CONTENT));
			startMenu();
			notify();
		}

	}

}

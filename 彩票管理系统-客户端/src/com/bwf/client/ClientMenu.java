package com.bwf.client;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.bwf.jar.MyRequest;
import com.bwf.jar.MyResponse;


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
			//开始界面就是登入界面
			login();
		}

	}

	private void login() throws IOException {
		//这里修改成GUI的界面
		System.out.println("登入界面：");
		System.out.println("请输入你是否需要注册：0-是，1-不是");
		int chose = ClientDemo.sc.nextInt();
		if(chose == 0) {
			regist();
			return ;
		}
		
		System.out.println("请输入用户名：");
		String uName = ClientDemo.sc.next();
		
		System.out.println("请输入密码：");
		String uPwd = ClientDemo.sc.next();
		
		System.out.println("还需要接收一个值，表示登入者的身份：");
		//三个身份（1-彩民，2-管理员，3-公证员）这个身份也决定了服务器从那个表中查询数据
		//String level = "彩民";
		String level = "公证员";

		// 包装成一个类
		MyRequest request = new MyRequest(MyRequest.TYPE_LOGIN);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_USERPWD, uPwd);
		request.getUmap().put(MyRequest.MEG_LEVEL, level);

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
				// 登入成功进入第二层操作界面
				this.uName = uName;
				SecondMenu sm = new SecondMenu(oos,lastResponse);
				sm.operateMenu(level,uName);//登入成功后三个身份界面
			} else {
				startMenu();
			}

			ClientDemo.class.notify();
		}

	}

//	private void tellServer() throws IOException {
//		MyRequest request = new MyRequest(MyRequest.TYPE_LOGOUT);
//		request.getUmap().put(MyRequest.MEG, "用户下线!!!");
//		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
//		
//		oos.writeObject(request);
//		oos.flush();
//		
//	}

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
			if (lastResponse.isSuccess()) {
				startMenu();
			}else {
				
				
			}
			notify();
		}

	}

}

package com.bwf.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.bwf.context.ApplicationContext;
import com.bwf.jar.MyRequest;
import com.bwf.jar.MyResponse;
import com.bwf.service.UserService;



public class ServerThread implements Runnable {

	private Socket socket;
	
	
	private UserService us;
	
	//这个记录所有在线的客户
	public static Map<String, ObjectOutputStream> onLineMap = new HashMap<>();

	public ServerThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			MyRequest request = null;
			//初始化读取xml文件,实例化对象并存入map,注入依赖
			ApplicationContext.init();
			us=(UserService) ApplicationContext.getBean("UserService");
			
			while ((request = (MyRequest) ois.readObject()) != null) {
				System.out.println(request);//测试通信
				
				
				
				MyResponse response = null;//日志功能暂时不做，但是保留这个
				
				switch (request.getType()) {
				case MyRequest.TYPE_REGIST:
					try {
						response = us.doRegist(request, oos);
						System.out.println("注册成功！！");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case MyRequest.TYPE_LOGIN:
					try {
						response = us.doLogin(request, oos);
					} catch (Exception e) {
						System.out.println("登入失败！！");
						System.out.println(e.getMessage());
					}
					break;
				case MyRequest.TYPE_CHANGEPWD:
					try {
						response = us.doChangePwd(request, oos);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case MyRequest.TYPE_RECHARGE:
					try {
						response = us.doRecharge(request, oos);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case MyRequest.TYPE_BET:
					try {
						response = us.doBet(request, oos);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case MyRequest.TYPE_SHOWMESSAGE:
					try {
						response = us.doShowMessage(request, oos);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case MyRequest.TYPE_LOGOUT:
					delClientUser(request);
					break;
				case MyRequest.TYPE_DELETEME:
					try {
						response = us.doDeleteMe(request, oos);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;

				default:
					break;
				}

//				if(response != null) {
//					LogRecord log = new LogRecord(new Date(), socket.getInetAddress().toString(), request, response);
//					FileUtil.saveLog(log);
//				}
			}

		} catch (SocketException e) {
			
			Iterator<Entry<String, ObjectOutputStream>> iterator = onLineMap.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<String, ObjectOutputStream> next = iterator.next();
				if(next.getValue().equals(oos)) {
					iterator.remove();
					System.out.println(next.getKey()+"删除成功！！");
				}
			}
			
			System.out.println("客户端退出！！");
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 

	}

	private void delClientUser(MyRequest request) {
		String name = request.getUmap().get(MyRequest.MEG_USERNAME);
		onLineMap.remove(name);
	}

//	private String getNewContent(String content, String name, String str) {
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss  ");
//		String s_date = sdf.format(date);
//
//		StringBuilder sb = new StringBuilder(s_date).append(name).append(str).append(" ： ").append(content);
//		return sb.toString();
//	}



}

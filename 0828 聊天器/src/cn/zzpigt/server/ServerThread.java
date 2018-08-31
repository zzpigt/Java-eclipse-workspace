package cn.zzpigt.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import cn.zzpigt.bean.LogRecord;
import cn.zzpigt.bean.MyRequest;
import cn.zzpigt.bean.MyResponse;
import cn.zzpigt.bean.User;
import cn.zzpigt.server.fileutil.FileUtil;

public class ServerThread extends Thread {

	private Socket socket;

	private static List<User> ulist = FileUtil.loadUserList();
//	public static List<ObjectOutputStream> chatList = new ArrayList<>();
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
			while ((request = (MyRequest) ois.readObject()) != null) {
				
				MyResponse response = null;
				
				switch (request.getType()) {
				case MyRequest.TYPE_REGIST:
					response = doRegist(request, oos);
					break;
				case MyRequest.TYPE_LOGIN:
					response = doLogin(request, oos);
					break;
				case MyRequest.TYPE_MORECHAT:
					doMoreChat(request, oos);
					break;
				case MyRequest.TYPE_SINGLECHAT:
					response = doSingleChat(request, oos);
					break;
				case MyRequest.TYPE_LOGOUT:
					delClientUser(request);
					break;

				default:
					break;
				}

				if(response != null) {
					LogRecord log = new LogRecord(new Date(), socket.getInetAddress().toString(), request, response);
					FileUtil.saveLog(log);
				}
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
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void delClientUser(MyRequest request) {

		String name = request.getUmap().get(MyRequest.MEG_USERNAME);

		
		onLineMap.remove(name);

	}

	
	
	private MyResponse doSingleChat(MyRequest request, ObjectOutputStream oos) throws IOException {
		String content = request.getUmap().get(MyRequest.MEG_CHATCONTENT);
		String name = request.getUmap().get(MyRequest.MEG_USERNAME);
		String chatToName = request.getUmap().get(MyRequest.MEG_CHAT_TO_USERNAME);

		String newContent = getNewContent(content, name, " 私聊 ");

		MyResponse response = new MyResponse(MyResponse.TYPE_SINGLECHAT);
		response.setSuccess(true);
		response.getrMeg().put(MyResponse.MEG_CONTENT, newContent);

		ObjectOutputStream s = onLineMap.get(chatToName);
		if (s != null) {
			s.writeObject(response);
			s.flush();
		} else {

		}
		return response;

	}

	private void doMoreChat(MyRequest request, ObjectOutputStream oos) throws IOException {
		String content = request.getUmap().get(MyRequest.MEG_CHATCONTENT);
		String name = request.getUmap().get(MyRequest.MEG_USERNAME);
		// 处理content
		String newContent = getNewContent(content, name, " 群发消息 ");

		Collection<ObjectOutputStream> values = onLineMap.values();
		for (ObjectOutputStream oosMap : values) {
			if (!oos.equals(oosMap)) {
				MyResponse response = new MyResponse(MyResponse.TYPE_MORECHAT);
				response.setSuccess(true);
				response.getrMeg().put(MyResponse.MEG_CONTENT, newContent);
				
				oosMap.writeObject(response);
				oosMap.flush();
				
				LogRecord log = new LogRecord(new Date(), socket.getInetAddress().toString(), request, response);
				FileUtil.saveLog(log);
			}
			
		}
	}

	private String getNewContent(String content, String name, String str) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss  ");
		String s_date = sdf.format(date);

		StringBuilder sb = new StringBuilder(s_date).append(name).append(str).append(" ： ").append(content);

		return sb.toString();
	}

	private MyResponse doLogin(MyRequest request, ObjectOutputStream oos) throws IOException {
		String uName = request.getUmap().get(MyRequest.MEG_USERNAME);
		String uPwd = request.getUmap().get(MyRequest.MEG_USERPWD);

		// 判断输入的用户名和密码是否正确
		for (User user : ulist) {
			if (uName.equals(user.getuName()) && uPwd.equals(user.getuPwd())) {
				Set<String> keySet = onLineMap.keySet();
				for (String s_name : keySet) {
					if(s_name.equals(uName)) {
						System.out.println("用户已经登入，不要重复上线！！");
						MyResponse response = new MyResponse(MyResponse.TYPE_LOGIN);
						response.setSuccess(false);
						response.getrMeg().put(MyResponse.MEG_CONTENT, "用户已经登入，不要重复上线！！");
						
						oos.writeObject(response);
						oos.flush();
						return response;
						
					}
				}

				// 登入成功
//				chatList.add(oos);
				onLineMap.put(uName, oos);
				MyResponse response = new MyResponse(MyResponse.TYPE_LOGIN);
				response.setSuccess(true);
				response.getrMeg().put(MyResponse.MEG_CONTENT, "登入成功！！！");

				oos.writeObject(response);
				oos.flush();
				return response;
			}
		}
		// 登入失败
		MyResponse response = new MyResponse(MyResponse.TYPE_LOGIN);
		response.setSuccess(false);
		response.getrMeg().put(MyResponse.MEG_CONTENT, "登入失败！！");

		oos.writeObject(response);
		oos.flush();

		return response;

	}

	private MyResponse doRegist(MyRequest request, ObjectOutputStream oos) throws IOException {

		String uName = request.getUmap().get(MyRequest.MEG_USERNAME);
		String uPwd = request.getUmap().get(MyRequest.MEG_USERPWD);

		// 判断是有用户名已经存在
		for (User user : ulist) {
			if (uName.equals(user.getuName())) {
				// 用户名已经存在,包装一个返回信息的类
				MyResponse response = new MyResponse(MyResponse.TYPE_REGISE);
				response.setSuccess(false);
				response.getrMeg().put(MyResponse.MEG_CONTENT, "用户名已经存在，请重新输入！！");

				oos.writeObject(response);
				oos.flush();
				return response;
			}
		}
		// 放入list
		ulist.add(new User(uName, uPwd));
		// 把信息写入文件
		System.out.println(ulist);
		FileUtil.saveUserList(ulist);

		// 返回成功信息给客户端
		MyResponse response = new MyResponse(MyResponse.TYPE_REGISE);
		response.setSuccess(true);
		response.getrMeg().put(MyResponse.MEG_CONTENT, "注册成功");

		oos.writeObject(response);
		oos.flush();

		return response;
	}

}

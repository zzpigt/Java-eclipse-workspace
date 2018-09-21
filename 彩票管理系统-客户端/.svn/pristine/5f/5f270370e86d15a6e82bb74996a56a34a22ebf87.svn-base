package com.bwf.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.bwf.jar.MyRequest;
import com.bwf.jar.MyResponse;

public class GreffierMenu {
	
	ObjectOutputStream oos;
	MyResponse lastResponse;

	public GreffierMenu(ObjectOutputStream oos, MyResponse lastResponse) {
		this.oos = oos;
		this.lastResponse = lastResponse;
	}

	public void greffierMenu(String uName) throws IOException {
		boolean isOver = false;
		do {
			System.out.println(uName+"公证员，欢迎您的登入！！");
			System.out.println("1-开奖，2-查看彩票信息");
			String chose = ClientDemo.sc.next();
			switch (chose) {
			case "开奖":	
				drawLottery(uName);
				break;
			case "查看彩票信息":	
				showLotteryMeg(uName);
				break;
				
			default:
				break;
			}
			
		}while(!isOver);
	}

	private void drawLottery(String uName) throws IOException {
		//拿到开奖号码
		//String winNum = getWinNum();
		String winNum ="01-02-03-04-05-06:07";
		//先向服务器发送请求，拿到当前的开奖状态
		MyRequest request = new MyRequest(MyRequest.TYPE_GREFFIER_DRAWLOTTERY);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_LEVEL, "公证员");
		request.getUmap().put(MyRequest.LOTTERY_WINNUM, winNum);
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
			// 拿到开奖状态
			if(lastResponse.isState()) {
				//已开奖，返回的就是提示：已经开奖，等待下次发行
				System.out.println(lastResponse.getrMeg().get(MyResponse.MEG_CONTENT));
			}else {
				//未开奖，可以开奖，返回提示：开奖完成！！！
				System.out.println(lastResponse.getrMeg().get(MyResponse.MEG_CONTENT));
			}

			ClientDemo.class.notify();
		}
		
		
	}

	private String getWinNum() {
		StringBuilder sb = new StringBuilder();
		List<Integer> numAll = new ArrayList<>();
		boolean isHere = true;
		boolean isDone = false;
		do{
			int num = new Random().nextInt(32) + 1;// 随机产生一个数【1-32】
			for (int j : numAll) {
				if (j == num) {
					isHere = false;
					break;
				}
			}
			if (isHere) {
				numAll.add(num);
			}
			if(numAll.size() > 5) {
				isDone = true;
			}
		}while(!isDone);
		Collections.sort(numAll);
		for (int i = 0; i < numAll.size(); i++) {
			if (numAll.get(i) < 10) {
				sb.append("0").append(numAll.get(i));
			} else {
				sb.append(numAll.get(i));
			}
			if (i < numAll.size() - 1) {
				sb.append("-");
			}
		}
		int endNum = new Random().nextInt(16) + 1;
		if (endNum < 10) {
			sb.append(":0").append(endNum);
		} else {
			sb.append(":").append(endNum);
		}
		return sb.toString();
	}

	private void showLotteryMeg(String uName) throws IOException {
		System.out.println("查看所有彩票的信息：");
		MyRequest request = new MyRequest(MyRequest.TYPE_GREFFIER_SHOWLOTTERYMEG);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_LEVEL, "公证员");
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
			// 拿到所有的彩票信息
			List<String> lotteryMeg = lastResponse.getHistoryList();
			
			for (String  p: lotteryMeg) {
				System.out.println(p);
			}

			ClientDemo.class.notify();
		}
		
	}

}

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
			System.out.println(uName + "管理员，欢迎您的登入！！");

			System.out.println("选择功能：1-发布，2-查询彩民信息，3-排序（查询到所有彩民信息），");
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
		System.out.println("弹出提示：是否要退出：Y/N");
		String chose = ClientDemo.sc.next();
		if ("y".equals(chose) || "Y".equals(chose)) {

			MyRequest request = new MyRequest(MyRequest.TYPE_ADMIN_LOGOUT);
			request.getUmap().put(MyRequest.MEG_USERNAME, uName);
			request.getUmap().put(MyRequest.MEG_LEVEL, "管理员");
			// 包装好了，就发送过去，序列化
			oos.writeObject(request);
			oos.flush();

		}

	}

	private void issue(String uName) throws IOException {
		if (lastResponse.isIssue()) {
			System.out.println("当期彩票尚未开奖，不能发行下一期！！");
			return;
		}
		//去通知服务器拿所有彩民信息
		MyRequest request2 = new MyRequest(MyRequest.TYPE_ADMIN_GETHISTORY);
		request2.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request2.getUmap().put(MyRequest.MEG_LEVEL, "管理员");

		// 包装好了，就发送过去，序列化
		oos.writeObject(request2);
		oos.flush();

		// 可以发行
		System.out.println("请输入新一期彩票的单价：");
		String newPrice = ClientDemo.sc.next();

		MyRequest request = new MyRequest(MyRequest.TYPE_ADMIN_ISSUE);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_LEVEL, "管理员");
		request.getUmap().put(MyRequest.LOTTERY_NEWPRICE, newPrice);
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
			int pageNum = 5;// 每页5条信息
			Integer pageCount = null;
			if (lotteryMeg.size() % pageNum > 0) {
				pageCount = lotteryMeg.size() / pageNum + 1;
			} else {
				pageCount = lotteryMeg.size() / pageNum;
			}

//			int pageCount = (int) Math.ceil(buyerMeg.size()/pageNum);//有多少页
			// 1-[0,4] 2-[5,9] 3-[11,15]

			System.out.println("请输入要跳转的页数，共" + pageCount + "页：");
			int page = ClientDemo.sc.nextInt();
			List<String> pageMeg = getMegByPage((page * pageNum - 5), lotteryMeg);

			for (String p : pageMeg) {
				System.out.println(p);
			}

			ClientDemo.class.notify();
		}

	}

	private void findBuyer(String uName) throws IOException {
		System.out.println("请输入需要查询的彩民的编号：");
		String buyerId = ClientDemo.sc.next();

		MyRequest request = new MyRequest(MyRequest.TYPE_ADMIN_FINDBUYER);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_LEVEL, "管理员");
		request.getUmap().put(MyRequest.ADMIN_BUYERID, buyerId);
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
			// 查询分成功失败,成功是把查询到的彩民信息发到historylist中返回过来的
			if (lastResponse.isSuccess()) {
				// 显示信息
				List<String> buyerMeg = lastResponse.getHistoryList();
				System.out.println(buyerId);
			} else {
				System.out.println("查询失败，请重新输入！！");
			}

			ClientDemo.class.notify();
		}

	}

	private void sortBuyer(String uName) throws IOException {
		System.out.println("请选择排序方式：1-按帐号排序，2-按余额排序");
		String sort = ClientDemo.sc.next();
		switch (sort) {
		case "帐号":
			sortById(uName);
			break;
		case "余额":
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

			// 读到了消息
			MyResponse lastResponse = ClientDemo.lastResponse;
			ClientDemo.lastResponse = null;
			System.out.println(lastResponse.getrMeg().get(MyResponse.MEG_CONTENT));
			// 把排序好的彩民信息发到historylist中返回过来的
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
		request.getUmap().put(MyRequest.MEG_LEVEL, "管理员");
		// 包装好了，就发送过去，序列化
		oos.writeObject(request);
		oos.flush();

	}

	private void sortById(String uName) throws IOException {
		MyRequest request = new MyRequest(MyRequest.TYPE_ADMIN_SORTBUYER_BYID);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_LEVEL, "管理员");
		// 包装好了，就发送过去，序列化
		oos.writeObject(request);
		oos.flush();

	}

}

package com.bwf.client;

import java.io.IOException;
import java.io.ObjectOutputStream;

import com.bwf.jar.MyRequest;
import com.bwf.jar.MyResponse;

public class SecondMenu {

	private ObjectOutputStream oos;
	MyResponse lastResponse;

	public SecondMenu(ObjectOutputStream oos,MyResponse lastResponse) {
		super();
		this.oos = oos;
		this.lastResponse = lastResponse;
	}

	public void operateMenu(String level, String uName) {
		// 后面再写（switch 3个身份的界面）
		System.out.println(level + "登入成功后的界面！！这个地方就需要判断是哪个身份登入了");
		switch (level) {
		case "彩民":
			try {
				buyerMenu(uName);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "管理员":
//					amdinMenu(lastResponse);
			break;
		case "公证员":
//					greffierMenu(lastResponse);
			break;

		default:
			System.out.println("sb");
			break;
		}

	}

	private void buyerMenu(String uName) throws IOException {
		boolean isOver = false;
		do {
			// 显示彩民信息
			System.out.println("彩民信息：");
			System.out.print("姓名: " + uName);
			System.out.print("\tID: " + lastResponse.getrMeg().get(MyResponse.MEG_ID));
			System.out.println("\t余额: " + lastResponse.getrMeg().get(MyResponse.MEG_MONEY));

			// 按钮功能--
			System.out.println("请选择功能：1-修改密码，2-账户充值，3-下注，4-退出登入，5-查看记录，6-注销");
			int chose = ClientDemo.sc.nextInt();
			switch (chose) {
			case 1:
				changePwd(uName);
				continue;
			case 2:
				recharge(uName);
				continue;
			case 3:
				bet(uName);
				continue;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;

			default:
				break;
			}

		} while (!isOver);

	}

	/**
	 * 下注
	 * @param uName
	 */
	private void bet(String uName) {
		System.out.println("显示关彩票信息:");
		System.out.print("期号："+lastResponse.getrMeg().get(MyResponse.LETTERY_TIME));
		System.out.print("\t单价："+lastResponse.getrMeg().get(MyResponse.LETTERY_PRICE));
		System.out.print("\t售出："+lastResponse.getrMeg().get(MyResponse.LETTERY_SELLNUM));
		System.out.print("\t奖池："+lastResponse.getrMeg().get(MyResponse.LETTERY_POOLMONEY));
		System.out.println();
		
		System.out.println("请输入需要购买的彩票号码：");
		String buyNum = ClientDemo.sc.next();
		System.out.println("买多少注，最多5注：");
		String buyCount = ClientDemo.sc.next();
		
		
		
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
			// 判断是否
			
			ClientDemo.class.notify();
		}
		
		
	}

	/**
	 * 账户重置
	 * 
	 * @param uName
	 * @throws IOException
	 */
	private void recharge(String uName) throws IOException {
		System.out.println("请输入要充值的金额：");
		String addMoney = ClientDemo.sc.next();

		MyRequest request = new MyRequest(MyRequest.TYPE_RECHARGE);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_LEVEL, "彩民");
		request.getUmap().put(MyRequest.MEG_ADDMONEY, addMoney);

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
			String string = lastResponse.getrMeg().get(MyResponse.MEG_MONEY);
			ClientDemo.lastResponse = null;
			System.out.println(lastResponse.getrMeg().get(MyResponse.MEG_CONTENT));
			
			// 判断是否修改成功
			ClientDemo.class.notify();
		}

	}

	/**
	 * 修改密码
	 * 
	 * @param uName
	 * @throws IOException
	 */
	private void changePwd(String uName) throws IOException {
		// 允许输入的次数
		boolean isOver = false;

		do {
			// 第一步，先让用户输入旧密码进行验证,然后输入修改后的密码
			System.out.println("用户输入旧密码进行验证,然后输入修改后的密码:");
			String oldPwd = ClientDemo.sc.next();
			System.out.println("新密码：");
			String newPwd = ClientDemo.sc.next();
			System.out.println("再次输入：");
			String secondNewPwd = ClientDemo.sc.next();

			// 判断
			if (!newPwd.equals(secondNewPwd)) {
				System.out.println("两次输入的新密码错误,请重新输入");
				
				continue;
			}

			MyRequest request = new MyRequest(MyRequest.TYPE_CHANGEPWD);
			request.getUmap().put(MyRequest.MEG_USERNAME, uName);
			request.getUmap().put(MyRequest.MEG_USERPWD, oldPwd);
			request.getUmap().put(MyRequest.MEG_LEVEL, "彩民");
			request.getUmap().put(MyRequest.MEG_NEWPWD, newPwd);

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
				// 判断是否修改成功
				if (lastResponse.isSuccess()) {
					// 修改成功！！
					isOver = true;
				} else {
					// 修改失败，密码不正确
					continue;
				}

				ClientDemo.class.notify();
			}
		} while (!isOver);
	}

}

package com.bwf.service.impl;

import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.bwf.bean.Admin;
import com.bwf.bean.Lottery_info;
import com.bwf.bean.User;
import com.bwf.bean.User_lottery;
import com.bwf.dao.AdminDao;
import com.bwf.dao.Lottery_infoDao;
import com.bwf.dao.UserDao;
import com.bwf.dao.User_lotteryDao;
import com.bwf.database.ConnectionFactory;
import com.bwf.jar.MyRequest;
import com.bwf.jar.MyResponse;
import com.bwf.service.UserService;

public class UserServiceImpl implements UserService {

	private User u = null;
	private AdminDao ad;
	private UserDao ud;
	private Lottery_infoDao ld;
	private User_lotteryDao uld;
	public static String uName;
	public static String aName;

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public void setAd(AdminDao ad) {
		this.ad = ad;
	}

	public void setLd(Lottery_infoDao ld) {
		this.ld = ld;
	}

	public void setUld(User_lotteryDao uld) {
		this.uld = uld;
	}

	// 将彩票信息添加到response中
	private void addLotteryMeg(MyResponse response) throws Exception {
		Lottery_info li = null;
		Connection conn = ConnectionFactory.getConnection();
		li = ld.getLastMeg(conn);
		System.out.println(li);
		if (li != null) {
			response.getrMeg().put(MyResponse.LETTERY_TIME, li.getTime());
			response.getrMeg().put(MyResponse.LETTERY_PRICE, String.valueOf(li.getPrice()));
			response.getrMeg().put(MyResponse.LETTERY_SELLNUM, String.valueOf(li.getSellnum()));
			response.getrMeg().put(MyResponse.LETTERY_POOLMONEY, String.valueOf(li.getPoolmoney()));
			response.setIssue(true);

		} else {
			response.setIssue(false);
			response.getrMeg().put(MyResponse.LETTERY_CONTENT, "没有正在发行的彩票信息");
		}

	}

	@Override
	public MyResponse doRegist(MyRequest request, ObjectOutputStream oos) throws Exception {
		String uName = request.getUmap().get(MyRequest.MEG_USERNAME);
		String uPwd = request.getUmap().get(MyRequest.MEG_USERPWD);

		// 判断是有用户名已经存在【数据库】
		Connection conn = ConnectionFactory.getConnection();

		if (ud.getByName(uName, conn) != null) {
			// 用户名已经存在,包装一个返回信息的类
			MyResponse response = new MyResponse(MyResponse.TYPE_REGISE);
			response.setSuccess(false);
			response.getrMeg().put(MyResponse.MEG_CONTENT, "用户名已经存在，请重新输入！！");
			addLotteryMeg(response);

			oos.writeObject(response);
			oos.flush();
			throw new Exception("用户名已经存在！！");
		}
		// 可以注册
		u = new User();
		u.setName(uName);
		u.setPwd(uPwd);
		u.setState(0);// 这个需要写成默认的
		u.setMoney(0.0);
		ud.insert(u, conn);
		// 用户插入数据库后，返回给客户端信息
		MyResponse response = new MyResponse(MyResponse.TYPE_REGISE);
		response.setSuccess(true);
		response.getrMeg().put(MyResponse.MEG_CONTENT, "注册成功");
		addLotteryMeg(response);

		oos.writeObject(response);
		oos.flush();

		conn.close();
		return response;

	}

	@Override
	public MyResponse doLogin(MyRequest request, ObjectOutputStream oos) throws Exception {
		String uName = request.getUmap().get(MyRequest.MEG_USERNAME);
		String uPwd = request.getUmap().get(MyRequest.MEG_USERPWD);
		String level = request.getUmap().get(MyRequest.MEG_LEVEL);

		// 判断输入的用户名和密码是否正确
		Connection conn = ConnectionFactory.getConnection();
		MyResponse response = null;

		// 这里判断请求者的身份，彩民就是ud，管理者和公证员就是ad
		Object whichMen = null;
		if ("彩民".equals(level)) {
			whichMen = ud.getByNameAndPwd(uName, uPwd, conn);
		} else {
			int levelNum = 0;
			if("管理员".equals(level)) {
				levelNum = 1;
			}else if("公证员".equals(level)){
				levelNum = 2;
			}
			whichMen = ad.getByNameAndPwd(levelNum,uName, uPwd, conn);
		}
		if (whichMen != null) {
			// 判断用户是否已经登入过了
			Integer state = null;
			if (whichMen instanceof User) {
				state = ((User) whichMen).getState();
			}else if (whichMen instanceof Admin) {
				state = ((Admin)whichMen).getState();
			}
			if(state == 1) {
				System.out.println("用户已经登入，不要重复上线！！");
				response = new MyResponse(MyResponse.TYPE_LOGIN);
				response.setSuccess(false);
				response.getrMeg().put(MyResponse.MEG_CONTENT, "用户已经登入，不要重复上线！！");
				addLotteryMeg(response);

				oos.writeObject(response);
				oos.flush();
				conn.close();
				return response;
			}
			
//			Set<String> keySet = ServerThread.onLineMap.keySet();
//			for (String s_name : keySet) {
//				if (s_name.equals(uName)) {
//					System.out.println("用户已经登入，不要重复上线！！");
//					response = new MyResponse(MyResponse.TYPE_LOGIN);
//					response.setSuccess(false);
//					response.getrMeg().put(MyResponse.MEG_CONTENT, "用户已经登入，不要重复上线！！");
//					addLotteryMeg(response);
//
//					oos.writeObject(response);
//					oos.flush();
//					return response;
//
//				}
//			}
			// 登入成功
//			ServerThread.onLineMap.put(uName, oos);
			//登入成功，改状态
			
			
			
			response = new MyResponse(MyResponse.TYPE_LOGIN);
			response.setSuccess(true);
			response.getrMeg().put(MyResponse.MEG_CONTENT, "登入成功！！");
			if (whichMen instanceof User) {
				this.uName = uName;
				User u = new User();
				u.setId(((User) whichMen).getId());
				u.setName(((User) whichMen).getName());
				u.setPwd(((User) whichMen).getPwd());
				u.setMoney(((User) whichMen).getMoney());
				u.setState(1);
				ud.update(u, conn);
				response.getrMeg().put(MyResponse.MEG_ID, String.valueOf(((User) whichMen).getId()));
				response.getrMeg().put(MyResponse.MEG_MONEY, String.valueOf(((User) whichMen).getMoney()));
			} else if (whichMen instanceof Admin) {
				this.aName = uName;
				((Admin) whichMen).setState(1);
				System.out.println(whichMen);
				ad.update((Admin) whichMen, conn);
				response.getrMeg().put(MyResponse.MEG_ID, String.valueOf(((Admin) whichMen).getId()));
			}

			addLotteryMeg(response);
			oos.writeObject(response);
			oos.flush();
		} else {
			// 登入失败
			response = new MyResponse(MyResponse.TYPE_LOGIN);
			response.setSuccess(false);
			response.getrMeg().put(MyResponse.MEG_CONTENT, "登入失败！！");

			addLotteryMeg(response);
			oos.writeObject(response);
			oos.flush();
		}
		conn.close();
		return response;
	}

	@Override
	public MyResponse doChangePwd(MyRequest request, ObjectOutputStream oos) throws Exception {
		String uname = request.getUmap().get(MyRequest.MEG_USERNAME);
		String uPwd = request.getUmap().get(MyRequest.MEG_USERPWD);
		String newPwd = request.getUmap().get(MyRequest.MEG_NEWPWD);
		Connection conn = ConnectionFactory.getConnection();
		u = ud.getByName(uname, conn);
		MyResponse response = new MyResponse(MyResponse.TYPE_CHANGEPWD);
		if (u.getPwd().equals(uPwd)) {
			u.setPwd(newPwd);
			ud.update(u, conn);
			response.setSuccess(true);
			response.getrMeg().put(MyResponse.MEG_CONTENT, "修改密码成功");

		} else {
			response.setSuccess(false);
			response.getrMeg().put(MyResponse.MEG_CONTENT, "修改密码失败,原密码错误");

		}
		addLotteryMeg(response);
		oos.writeObject(response);
		oos.flush();
		conn.close();
		return response;
	}

	@Override
	public MyResponse doRecharge(MyRequest request, ObjectOutputStream oos) throws Exception {
		String uName = request.getUmap().get(MyRequest.MEG_USERNAME);
		Double money = Double.parseDouble(request.getUmap().get(MyRequest.MEG_ADDMONEY));
		String level = request.getUmap().get(MyRequest.MEG_LEVEL);
		Connection conn = null;
		MyResponse response = new MyResponse(MyResponse.TYPE_RECHARGE);
		conn = ConnectionFactory.getConnection();
		u = ud.getByName(uName, conn);
		response.getrMeg().put(MyResponse.MEG_MONEY, String.valueOf(money + u.getMoney()));
		u.setMoney(money + u.getMoney());
		ud.update(u, conn);
		response.setSuccess(true);
		response.getrMeg().put(MyResponse.MEG_CONTENT, "充值成功!");

		addLotteryMeg(response);
		oos.writeObject(response);
		oos.flush();
		conn.close();
		return response;
	}

	@Override
	public MyResponse doBet(MyRequest request, ObjectOutputStream oos) throws Exception {
		Connection conn = null;
		try {
			conn=ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			Lottery_info Li = ld.getLastMeg(conn);
			// 这期彩票的单价
			Double singleprice = Li.getPrice();
			String ltime = request.getUmap().get(MyRequest.LOTTERY_TIME);
			String selectNum = request.getUmap().get(MyRequest.LOTTERY_SELECTNUM);
			String uName = request.getUmap().get(MyRequest.MEG_USERNAME);
			u = ud.getByName(uName, conn);
			Integer uid = u.getId();
			Integer buyCount = Integer.parseInt(request.getUmap().get(MyRequest.LOTTERY_BUYCOUNT));
			Integer sumcount = uld.getBySelectnumAndUid(selectNum, uid, ltime, conn);
			MyResponse response = new MyResponse(MyResponse.TYPE_BET);
			if (sumcount + buyCount <= 5 && (u.getMoney() - buyCount * singleprice) >= 0) {
				String buyTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				User_lottery ul = new User_lottery();
				ul.setLtime(ltime);
				ul.setSelectednum(selectNum);
				ul.setUid(uid);
				ul.setBuycount(buyCount);
				ul.setWinmoney(0.0);
				ul.setBuytime(buyTime);
				uld.insert(ul, conn);
				

				// 扣除余额
				Double rest = u.getMoney() - buyCount * singleprice;
				u.setMoney(rest);
				ud.update(u, conn);
				// 奖池加钱,增加卖出数量
				Li.setPoolmoney(Li.getPoolmoney() + buyCount * singleprice);
				Li.setSellnum(Li.getSellnum() + buyCount);
				ld.update(Li, conn);
				// 返回对象添加余额
				response.getrMeg().put(MyResponse.MEG_MONEY, String.valueOf(rest));
				response.setSuccess(true);
				addLotteryMeg(response);
				response.getrMeg().put(MyResponse.MEG_CONTENT, "下注成功!");

			} else {

				response.setSuccess(false);
				response.getrMeg().put(MyResponse.MEG_CONTENT, "下注失败!");
			}
			addLotteryMeg(response);
			conn.commit();
			oos.writeObject(response);
			oos.flush();
			return response;
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
		return null;
	}

	@Override
	public MyResponse doShowMessage(MyRequest request, ObjectOutputStream oos) throws Exception {
		String uName = request.getUmap().get(MyRequest.MEG_USERNAME);
		Connection conn = ConnectionFactory.getConnection();

		u = ud.getByName(uName, conn);

		List<String> list = uld.getByUid(u.getId(), conn);
		MyResponse response = new MyResponse(MyResponse.TYPE_SHOWMESSAGE);
		response.setSuccess(true);
		response.setHistoryList(list);
		System.out.println(list);
		response.getrMeg().put(MyResponse.MEG_CONTENT, "显示购买历史记录");
		addLotteryMeg(response);
		oos.writeObject(response);
		oos.flush();
		conn.close();
		return response;
	}

	@Override
	public MyResponse doBetFlush(MyRequest request, ObjectOutputStream oos) throws Exception {
		String uName = request.getUmap().get(MyRequest.MEG_USERNAME);
		String time = request.getUmap().get(MyRequest.LOTTERY_TIME);
		Connection conn = ConnectionFactory.getConnection();
		u = ud.getByName(uName, conn);
		List<String> list = uld.getByUidAndTime(u.getId(), time, conn);
		MyResponse response = new MyResponse(MyResponse.TYPE_SHOWMESSAGE);
		response.setSuccess(true);
		response.setHistoryList(list);
		response.getrMeg().put(MyResponse.MEG_CONTENT, "显示本期购买历史记录");
		addLotteryMeg(response);
		oos.writeObject(response);
		oos.flush();
		conn.close();
		return response;

	}

	@Override
	public MyResponse doUserLogout(MyRequest request, ObjectOutputStream oos) throws Exception {
		String name = request.getUmap().get(MyRequest.MEG_USERNAME);
		Connection conn = ConnectionFactory.getConnection();
		ud.updateStateByName(name,conn);
		return null;
	}

	@Override
	public void exit(String uName) throws Exception {
		Connection conn = ConnectionFactory.getConnection();
		ad.updateStateByName(uName,conn);
	}

}

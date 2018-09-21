package com.bwf.service;

import java.io.ObjectOutputStream;

import com.bwf.jar.MyRequest;
import com.bwf.jar.MyResponse;

public interface AdminService {

	MyResponse doIssue(MyRequest request, ObjectOutputStream oos) throws Exception;

	MyResponse doFindBuyer(MyRequest request, ObjectOutputStream oos) throws Exception;

	MyResponse doSortBuyerById(MyRequest request, ObjectOutputStream oos)throws Exception;

	MyResponse doSortBuyerByMoney(MyRequest request, ObjectOutputStream oos)throws Exception;

	MyResponse doShowLotteryMeg(MyRequest request, ObjectOutputStream oos)throws Exception;

	MyResponse doDrawLottery(MyRequest request, ObjectOutputStream oos)throws Exception;

	MyResponse doAdminLogout(MyRequest request, ObjectOutputStream oos)throws Exception;

	MyResponse doGetHistory(MyRequest request, ObjectOutputStream oos)throws Exception;

	void exit(String aName)throws Exception;
	

}

package com.bwf.test;

import java.sql.Connection;

import com.bwf.database.ConnectionFactory;

public class Test {

	public static void main(String[] args) {
		//测试数据库连接
		test1();
		
		
	}
	
	public static void test1() {
		Connection conn = ConnectionFactory.getConnection();
		System.out.println(conn);
	}
}

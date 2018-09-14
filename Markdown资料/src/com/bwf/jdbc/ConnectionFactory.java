package com.bwf.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static String driver;
	private static String url;
	private static String uname;
	private static String upwd;
	
	static {
		Properties properties = new Properties();
		// 用 ClassLoader 读取src下的资源
		InputStream is = ConnectionFactory.class.getClassLoader()
				.getSystemResourceAsStream("dbconfig.properties");
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		uname = properties.getProperty("uname");
		upwd = properties.getProperty("upwd");
		
	}
	

	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uname, upwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;
	}
	
}

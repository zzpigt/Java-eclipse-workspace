package com.bwf.database;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();
	private static String driver;
	private static String url;
	private static String uname;
	private static String upwd;

	static {
		Properties properties = new Properties();
		// 用 ClassLoader 读取src下的资源
		InputStream is = ConnectionFactory.class.getClassLoader().getSystemResourceAsStream("dbconfig.properties");
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		uname = properties.getProperty("uname");
		upwd = properties.getProperty("upwd");

		// TODO Auto-generated method stub

		// loads the jdbc driver
		try {
			cpds.setDriverClass(driver);
			cpds.setJdbcUrl(url);
			cpds.setUser(uname);
			cpds.setPassword(upwd);

		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {

		try {
			return cpds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}

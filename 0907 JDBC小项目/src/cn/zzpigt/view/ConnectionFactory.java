package cn.zzpigt.view;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private static ComboPooledDataSource cds = new ComboPooledDataSource();


	private static String driver;
	private static String url;
	private static String uname;
	private static String upwd;
	
	static {
		Properties properties = new Properties();
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
		
		try {
			//loads the jdbc driver            
			cds.setDriverClass(driver);
			cds.setJdbcUrl(url);
			cds.setUser(uname);                                  
			cds.setPassword(upwd);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} 
		
		
	}
	
	
	public static Connection getConnection() {
		try {
			return cds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}

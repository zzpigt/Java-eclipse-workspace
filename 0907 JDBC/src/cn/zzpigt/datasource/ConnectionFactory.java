package cn.zzpigt.datasource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private static ComboPooledDataSource md = new ComboPooledDataSource();
	
	
	static {
		Properties properties = new Properties();
		InputStream is = ConnectionFactory.class.getClassLoader().getSystemResourceAsStream("dbconfig.properties");
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String uname = properties.getProperty("uname");
		String upwd = properties.getProperty("upwd");
		
		try {
			//loads the jdbc driver            
			md.setDriverClass(driver);
			md.setJdbcUrl(url);
			md.setUser(uname);                                  
			md.setPassword(upwd);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} 
		

	}
	
	
	public static Connection getConnection() {
		try {
			return md.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}

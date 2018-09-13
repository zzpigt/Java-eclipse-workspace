package cn.zzpigt.demo;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Demo8 {
	public static void main(String[] args) {
		
		//使用一下c3p0
		ComboPooledDataSource cpds = new ComboPooledDataSource("oracle");
		try {
			//loads the jdbc driver   
//			cpds.setDriverClass( "com.mysql.jdbc.Driver" );
//			cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/scott" );
//			cpds.setUser("root");                                  
//			cpds.setPassword("123456");   
			
			Connection conn = cpds.getConnection();
			
			System.out.println(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}          
		      
		
	}
	
}

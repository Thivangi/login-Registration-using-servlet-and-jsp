package com.akash;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Dbutil {
	
	static ComboPooledDataSource ds = null;

	private static void initDs() {
		if (ds == null) {
			ds = new ComboPooledDataSource();
			try {
				ds.setDriverClass("com.mysql.jdbc.Driver");
				ds.setJdbcUrl("JDBC:mysql://localhost:3306/Test");
				ds.setUser("root");
				ds.setPassword("root");
				ds.setMinPoolSize(5);
				ds.setAcquireIncrement(5);
				ds.setMaxPoolSize(20);

			} catch (PropertyVetoException e) {
				
				e.printStackTrace();
			} 

		}
	
	}
	
	public static Connection getConnectionDBUtil() throws SQLException {
		System.out.println("inside connection");
		initDs();
		return ds.getConnection();
	}

	public static void closeConnection() 
	{
		ds.close();
	}
	
	

}

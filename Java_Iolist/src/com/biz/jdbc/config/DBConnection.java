package com.biz.jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection dbConn = null;
	
	static {
		
			try {
				Class.forName(DBcontract.DB_CONN.JDBC_DRIVER);
				dbConn = DriverManager.getConnection(
						DBcontract.DB_CONN.URL,
						DBcontract.DB_CONN.USER_NAME,
						DBcontract.DB_CONN.PASSWORD
						);
						
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
		
	}
	public static Connection getDBConnection() {
		return dbConn;
	}
}

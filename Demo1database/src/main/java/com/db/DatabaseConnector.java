package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	
	private final static String MYSQL_DB_URL = "jdbc:mysql://localhost:3306/information";
	private final static String MYSQL_USERNAME = "root";
	private final static String MYSQL_PASSWORD = "root";
	private final static String MYSQL_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	
	public static Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
		try {
			Class.forName(MYSQL_DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
		return conn;
	}
}
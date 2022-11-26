package com.db.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.db.DatabaseConnector;

public class EmployeeDAO extends DatabaseConnector {
	
	private final static String USER_ID = "USER_ID";
	private final static String USER_NAME = "USER_NAME";
	private final static String PASSWORD = "PASSWORD";
	//private final static String ADDRESS = "ADDRESS";
	//private final static String CITY = "CITY";
	
	private final String SELECT_ALL_EMLOYEES_QRY = "SELECT * FROM user";

	public List<Map<String, Object>> getAllEmployee() throws ClassNotFoundException, SQLException {
		Connection conn = getDatabaseConnection();
		PreparedStatement pStmt = conn.prepareStatement(SELECT_ALL_EMLOYEES_QRY);
		ResultSet rs = pStmt.executeQuery();
		
		List<Map<String, Object>> employeeList = new ArrayList<Map<String, Object>>();
		while (rs.next()) {
			Map<String, Object> employee = new HashMap<String, Object>();
			employee.put("USER_ID", rs.getInt(USER_ID));
			employee.put("USER_NAME", rs.getString(USER_NAME));
			employee.put("PASSWORD", rs.getString(PASSWORD));
		//	employee.put("ADDRESS", rs.getString(ADDRESS));
	//		employee.put("CITY", rs.getString(CITY));
			employeeList.add(employee);
		}
		return employeeList;
	}
}
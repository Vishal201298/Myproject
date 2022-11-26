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

public class IssuesDAO extends DatabaseConnector {
	
	private final static String ISSUE_ID = "ISSUE_ID";
	private final static String DESCRIPTION = "DESCRIPTION";
	private final static String STATUS = "STATUS";
	//private final static String ADDRESS = "ADDRESS";
	//private final static String CITY = "CITY";
	
	private final String SELECT_ALL_EMLOYEES_QRY = "SELECT * FROM issue";

	public List<Map<String, Object>> getAllEmployee() throws ClassNotFoundException, SQLException {
		Connection conn = getDatabaseConnection();
		PreparedStatement pStmt = conn.prepareStatement(SELECT_ALL_EMLOYEES_QRY);
		ResultSet rs = pStmt.executeQuery();
		
		List<Map<String, Object>> employeeList = new ArrayList<Map<String, Object>>();
		while (rs.next()) {
			Map<String, Object> employee = new HashMap<String, Object>();
			employee.put("ISSUE_ID", rs.getInt(ISSUE_ID));
			employee.put("DESCRIPTION", rs.getString(DESCRIPTION));
			employee.put("STATUS", rs.getString(STATUS));
		//	employee.put("ADDRESS", rs.getString(ADDRESS));
	//		employee.put("CITY", rs.getString(CITY));
			employeeList.add(employee);
		}
		return employeeList;
	}
}

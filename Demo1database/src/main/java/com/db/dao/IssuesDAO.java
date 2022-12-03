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
	
	private final static String ISSUE_ID = "ID";
	private final static String DESCRIPTION = "discription";
	private final static String User_ID="user_id";
	private final static String STATUS = "status";
	
	
	private final String selectQueryById = "SELECT * FROM issue WHERE user_id = ?";
//	private final String INSERT_QRY="Insert into issue(ID,discription,user_id,status) values(?,?,?,?)";
	private String insertQuery = "INSERT INTO issue values (?, ?, ?, ?)";
	Connection conn = null;
	PreparedStatement insertPreparedStatement;
	PreparedStatement selectPreparedStatement;

	public List<Map<String, Object>> getAllIssue() throws ClassNotFoundException, SQLException {
		Connection conn = getDatabaseConnection();
		insertPreparedStatement = conn.prepareStatement(insertQuery);
		
		insertPreparedStatement.setInt(1, 1004);
		insertPreparedStatement.setString(2, "Laptop issues");
		insertPreparedStatement.setString(3, "13");
		insertPreparedStatement.setString(4, "open");
		
		
		insertPreparedStatement.executeUpdate();

//		PreparedStatement pStmt = conn.prepareStatement(SELECT_ALL_ISSUES_QRY);
//		ResultSet rs = pStmt.executeQuery();
		
		selectPreparedStatement = conn.prepareStatement(selectQueryById);
		selectPreparedStatement.setInt(1, 13);
		
		ResultSet rs = selectPreparedStatement.executeQuery();
	//	conn.close();
		List<Map<String, Object>> issueList = new ArrayList<Map<String, Object>>();
		while (rs.next()) {
			Map<String, Object> issue = new HashMap<String, Object>();
			issue.put("ISSUE_ID", rs.getInt(ISSUE_ID));
			issue.put("DESCRIPTION", rs.getString(DESCRIPTION));
			issue.put("User_ID", rs.getInt(User_ID));
			issue.put("STATUS", rs.getString(STATUS));
			issueList.add(issue);
		
		}
	
		return issueList;
	
	}
}

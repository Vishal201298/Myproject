package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connjdbc {

	public static void main(String[] args) {
		final String dbUrl = "jdbc:mysql://localhost:3306/information";
		final String username = "root";
		final String password = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbUrl, username, password);
			
			Statement stmt = conn.createStatement();
			Statement s = conn.createStatement();
			
		//	Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM user");
			ResultSet rd = s.executeQuery("SELECT * FROM issue");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			
			
			System.out.println("----------------------------");
			while (rd.next()) {
				System.out.println(rd.getInt(1) + " " + rd.getString(2) + " " + rd.getString(3));
			}
//			rs.beforeFirst();
//			while (rs.next()) {
//				System.out.println(rs.getInt("EMP_ID") + " " + rs.getString("FIRST_NAME") + " " + rs.getString("LAST_NAME"));
//			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

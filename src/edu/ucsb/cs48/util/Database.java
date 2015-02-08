package edu.ucsb.cs48.util;
//package triviamaster;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	public static Connection createDBconnection() {
		String url = "jdbc:mysql://104.236.175.85:3306/";
		String dbName = "triviamaster";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "triviaMaster";
		String password = "trivia";
		try {
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url + dbName,
					userName, password);

			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void closeDBconnection(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

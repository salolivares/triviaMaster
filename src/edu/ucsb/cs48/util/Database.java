package edu.ucsb.cs48.util;
//package triviamaster;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Database class that manages connections to remote database
 */

public class Database {

    /**
	 * This function connects to our database, using the IP address and login
     * information to access our tables.
	 * @return connecetion to the database
	 */
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

    /**
	 * This function closes the database connection.
	 * @param conn the connection to be closed
	 */
	public static void closeDBconnection(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

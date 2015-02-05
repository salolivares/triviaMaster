package edu.ucsb.cs48.util;
//package triviamaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//TODO:
// Make createAccount return a boolean

public class User {
	public static boolean loginCheck(String username, String password) {
		String query;
		boolean login = false;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection con = createDBconnection();

			Statement stmt = (Statement) con.createStatement();
			query = "SELECT username, password FROM user WHERE username='"
					+ username + "' AND password='" + password + "';";
			stmt.executeQuery(query);
			ResultSet rs = stmt.getResultSet();
			login = rs.first();
			closeDBconnection(con);
			return login;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return login;
	}

	public static String createUser(String username, String password) {
		try {
			Connection con = createDBconnection();
			Statement select_stmt = (Statement) con.createStatement();
			String query = "SELECT username FROM user WHERE username='"
					+ username + "';";
			//System.out.println(query);
			select_stmt.executeQuery(query);
			ResultSet rs = select_stmt.getResultSet();
			if (!(rs.first())) { /* If user does not exist */
				String ins = "INSERT into user (username, password) values ('"
						+ username + "','" + password + "');";
				//System.out.println(ins);
				Statement ins_stmt = (Statement) con.createStatement();
				ins_stmt.executeUpdate(ins);
			}
			else { /* If user already exists */
				return "DUPLICATE";
			}
			closeDBconnection(con);
			return "CREATED";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "NOTCREATED";
	}

	public static Connection createDBconnection() {
<<<<<<< HEAD
		String url = "jdbc:mysql://localhost/";
		String dbName = "triviamaster";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "nivedita";
		String password = "choudhuri";
=======
		String url = "jdbc:mysql://104.236.175.85:3306/";
		String dbName = "triviamaster";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "triviaMaster";
		String password = "trivia";
>>>>>>> origin/master
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

	public static void main(String[] args) {
		if (loginCheck("nivedita", "choudhuri"))
			System.out.println("loginCheck: Success");
		else
			System.out.println("loginCheck: Fail");
		
		String msg = createUser("user", "password");
		System.out.println("createUser: " + msg);
	}

}

package edu.ucsb.cs48.util;
//package triviamaster;

import edu.ucsb.cs48.Main;

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

			Connection con = Main.db.createDBconnection();

			Statement stmt = (Statement) con.createStatement();
			query = "SELECT username, password FROM user WHERE username='"
					+ username + "' AND password='" + password + "';";
			stmt.executeQuery(query);
			ResultSet rs = stmt.getResultSet();
			login = rs.first();
			Main.db.closeDBconnection(con);
			return login;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return login;
	}

	public static String createUser(String username, String password) {
		try {
			Connection con = Main.db.createDBconnection();
			Statement select_stmt = (Statement) con.createStatement();
			String query = "SELECT username FROM user WHERE username='"
					+ username + "';";
			//System.out.println(query);
			select_stmt.executeQuery(query);
			ResultSet rs = select_stmt.getResultSet();
			if (!(rs.first())) { /* If user does not exist */
				String ins = "INSERT into user (username, password, points, highscore) values ('"
						+ username + "','" + password + "','" + 0 + "','" + 0 + "');";
				//System.out.println(ins);
				Statement ins_stmt = (Statement) con.createStatement();
				ins_stmt.executeUpdate(ins);
			}
			else { /* If user already exists */
				return "DUPLICATE";
			}
			Main.db.closeDBconnection(con);
			return "CREATED";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "NOTCREATED";
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

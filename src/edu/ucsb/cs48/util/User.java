package edu.ucsb.cs48.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
	public static boolean loginCheck(String username, String password) {
		String query;
		boolean login = false;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection con = DriverManager.getConnection("jdbc:mysql://104.236.175.85:3306/triviamaster","triviaMaster","trivia");

			Statement stmt = (Statement) con.createStatement();
			query = "SELECT username, password FROM user WHERE username='"
					+ username + "' AND password='" + password + "';";
			stmt.executeQuery(query);
			ResultSet rs = stmt.getResultSet();
			login = rs.first();

			return login;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return login;
	}

	public static void main(String[] args) {
		if (loginCheck("nivedita","choudhuri"))
			System.out.println("Success");
		else
			System.out.println("Login failure");
	}
}
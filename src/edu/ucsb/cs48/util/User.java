package triviaMaster;

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

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/triviamaster?" + "user=trivia&password=master");

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
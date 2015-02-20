package edu.ucsb.cs48.util;
//package triviamaster;

import edu.ucsb.cs48.Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * User class that deals with logging in and creating new accounts
 */

public class User {

    /**
     * This function checks if the login information given by the user is valid.
     * It accesses the database and checks the user table to see if there is a user
     * with the given username and password, and returns true if there is.
     * @param username inputted username
     * @param password inputted password
     * @return true or false depending if login succeeded
     */
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

    /**
     * This function inserts a new username/password into the user table. It first
     * checks if there is already a user in the table with the same username, and returns
     * DUPLICATE if there is. Otherwise, the function returns CREATED unless there is an
     * error. Because the user has just been created, the user's points and high score are
     * initialized to 0.
     * @param username desired username
     * @param password desired password
     * @return String indicating whether account was succesfully created or not
     */
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
            } else { /* If user already exists */
                return "DUPLICATE";
            }
            Main.db.closeDBconnection(con);
            return "CREATED";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "NOTCREATED";
    }
}

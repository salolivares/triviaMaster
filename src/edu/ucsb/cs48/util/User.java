package edu.ucsb.cs48.util;
//package triviamaster;

import edu.ucsb.cs48.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * User class that deals with logging in and creating new accounts
 * This class also modifies user's high score and points
 */

public class User {



    private String username;

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

			Connection con = Database.createDBconnection();

			Statement stmt = con.createStatement();
			query = "SELECT username, password FROM user WHERE username='"
					+ username + "' AND password='" + password + "';";
			stmt.executeQuery(query);
			ResultSet rs = stmt.getResultSet();
			login = rs.first();
			Database.closeDBconnection(con);
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
            Connection con = Database.createDBconnection();
            Statement select_stmt = con.createStatement();
            String query = "SELECT username FROM user WHERE username='"
                    + username + "';";
            //System.out.println(query);
            select_stmt.executeQuery(query);
            ResultSet rs = select_stmt.getResultSet();
            if (!(rs.first())) { /* If user does not exist */
                String ins = "INSERT into user (username, password, points, highscore, AutoAnswer, QuestionEliminator) values ('"
                        + username + "','" + password + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "');";
                //System.out.println(ins);
                Statement ins_stmt = con.createStatement();
                ins_stmt.executeUpdate(ins);
            } else { /* If user already exists */
                return "DUPLICATE";
            }
            Database.closeDBconnection(con);
            return "CREATED";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "NOTCREATED";
    }

    /**
     * Username getter
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Username setter
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * getHighScore class gets user high score from database
     * @return high score int
     */
    public int getHighScore() {
        String query;
        String username = getUsername();
        int hs = 0;

        try {
            Connection con = Database.createDBconnection();
            Statement stmt = con.createStatement();
            query = "SELECT highscore FROM user WHERE username='" + username + "';";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                hs = rs.getInt("highscore");
            }

            Database.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return hs;
    }

    /**
     * getHighScore overloaded to get any high score from database
     * @param username username of high score desired
     * @return high score int
     */
    public int getHighScore(String username) {
        String query;
        int hs = 0;

        try {
            Connection con = Database.createDBconnection();
            Statement stmt = con.createStatement();
            query = "SELECT highscore FROM user WHERE username='" + username + "';";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                hs = rs.getInt("highscore");
            }

            Database.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return hs;
    }

    /**
     * getPoints class gets user points from database
     * @return points int
     */
    public int getPoints() {
        String query;
        String username = getUsername();
        int points = 0;

        try {
            Connection con = Database.createDBconnection();
            Statement stmt = con.createStatement();
            query = "SELECT points FROM user WHERE username='" + username + "';";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                points = rs.getInt("points");
            }

            Database.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return points;
    }

    /**
     * setHighscore method that sets the user's highscore
     * @param hs highscore to input
     */
    public void setHighscore(double hs) {

        String query;
        String un = getUsername();

        try {
            Connection con = Database.createDBconnection();
            query = "update user set highscore = ? where username = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, hs);
            ps.setString(2, un);
            ps.executeUpdate();

            Database.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * modifyPoints method that modifies (add or subract) to the user's points
     * @param pts highscore to input
     */
    public void modifyPoints(double pts) {

        String query;
        String un = getUsername();

        try {
            Connection con = Database.createDBconnection();
            query = "update user set points = ? where username = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, Main.player.getPoints() + pts);
            ps.setString(2, un);
            ps.executeUpdate();

            Database.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function finds the top 5 high scores in the database
     * @return An ArrayList<String> of the names of the top 5 scores.
     */
    public ArrayList<String> getTopFiveUsers() {
        String query;
        ArrayList<String> usernames = new ArrayList<String>();

        try {
            Connection con = Database.createDBconnection();
            Statement stmt = con.createStatement();
            query = "SELECT username FROM user ORDER by highscore DESC limit 5;";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                usernames.add(rs.getString("username"));
            }

            Database.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return usernames;
    }
}

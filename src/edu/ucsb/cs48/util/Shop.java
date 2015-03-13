package edu.ucsb.cs48.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Adapter class for items database
 *
 */
public class Shop {
    /**
     * This function checks how many AutoAnswer power ups a user currently has.
     * @param username
     * @return number of AutoAnswer power ups
     */
    public int numberOfAutoAnswer(String username) {
        String query;
        int num = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = Database.createDBconnection();

            Statement stmt = con.createStatement();
            query = "SELECT AutoAnswer FROM user WHERE username='" + username + "';";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();

            while(rs.next()) {
                num = rs.getInt("AutoAnswer");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    /**
     * This function checks how many QuestionEliminator power ups a user currently has.
     * @param username
     * @return number of QuestionEliminator power ups
     */
    public int numberOfQuestionEliminator(String username) {
        String query;
        int num = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = Database.createDBconnection();

            Statement stmt = con.createStatement();
            query = "SELECT QuestionEliminator FROM user WHERE username='" + username + "';";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();

            while(rs.next()) {
                num = rs.getInt("QuestionEliminator");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    /**
     * This function increases a user's number of AutoAnswer power ups by 1.
     * @param username
     */
    public void increaseNumberOfAutoAnswer(String username) {
        String query;

        try {
            Connection con = Database.createDBconnection();
            query = "UPDATE user SET AutoAnswer = ? WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, numberOfAutoAnswer(username) + 1);
            ps.setString(2, username);
            ps.executeUpdate();

            Database.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function decreases a user's number of AutoAnswer power ups by 1.
     * @param username
     */
    public void decreaseNumberOfAutoAnswer(String username) {
        String query;

        try {
            Connection con = Database.createDBconnection();
            query = "UPDATE user SET AutoAnswer = ? WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);

            if(numberOfAutoAnswer(username) == 0) return;

            ps.setInt(1, numberOfAutoAnswer(username) - 1);
            ps.setString(2, username);
            ps.executeUpdate();

            Database.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function increases a user's number of QuestionEliminator power ups by 1.
     * @param username
     */
    public void increaseNumberOfQuestionEliminator(String username) {
        String query;

        try {
            Connection con = Database.createDBconnection();
            query = "UPDATE user SET QuestionEliminator = ? WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, numberOfQuestionEliminator(username) + 1);
            ps.setString(2, username);
            ps.executeUpdate();

            Database.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function decreases a user's number of QuestionEliminator power ups by 1.
     * @param username
     */
    public void decreaseNumberOfQuestionEliminator(String username) {
        String query;

        try {
            Connection con = Database.createDBconnection();
            query = "UPDATE user SET QuestionEliminator = ? WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);

            if(numberOfQuestionEliminator(username) == 0) return;

            ps.setInt(1, numberOfQuestionEliminator(username) - 1);
            ps.setString(2, username);
            ps.executeUpdate();

            Database.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

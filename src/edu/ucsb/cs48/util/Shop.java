package edu.ucsb.cs48.util;

import edu.ucsb.cs48.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Shop class. Work in Progress
 */
public class Shop {
    public int numberOfAutoAnswer(String username) {
        String query;
        int num = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = Main.db.createDBconnection();

            Statement stmt = (Statement) con.createStatement();
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

    public int numberOfQuestionEliminator(String username) {
        String query;
        int num = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = Main.db.createDBconnection();

            Statement stmt = (Statement) con.createStatement();
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

    public void increaseNumberOfAutoAnswer(String username) {
        String query;

        try {
            Connection con = Main.db.createDBconnection();
            query = "UPDATE user SET AutoAnswer = ? WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, numberOfAutoAnswer(username) + 1);
            ps.setString(2, username);
            ps.executeUpdate();

            Main.db.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }


    public void decreaseNumberOfAutoAnswer(String username) {
        String query;

        try {
            Connection con = Main.db.createDBconnection();
            query = "UPDATE user SET AutoAnswer = ? WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);

            if(numberOfAutoAnswer(username) == 0) return;

            ps.setInt(1, numberOfAutoAnswer(username) - 1);
            ps.setString(2, username);
            ps.executeUpdate();

            Main.db.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void increaseNumberOfQuestionEliminator(String username) {
        String query;

        try {
            Connection con = Main.db.createDBconnection();
            query = "UPDATE user SET QuestionEliminator = ? WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, numberOfQuestionEliminator(username) + 1);
            ps.setString(2, username);
            ps.executeUpdate();

            Main.db.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void decreaseNumberOfQuestionEliminator(String username) {
        String query;

        try {
            Connection con = Main.db.createDBconnection();
            query = "UPDATE user SET QuestionEliminator = ? WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);

            if(numberOfQuestionEliminator(username) == 0) return;

            ps.setInt(1, numberOfQuestionEliminator(username) - 1);
            ps.setString(2, username);
            ps.executeUpdate();

            Main.db.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

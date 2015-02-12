package edu.ucsb.cs48.util;

import edu.ucsb.cs48.Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


/* TO DO: modify database functions to take Connection con as a parameter,
 * instead of creating and closing a connection in each function. This way,
 * the connection can just be created and closed once, in the main function. */

public class QuestionAccess {

    public static ArrayList<String> getCategories() {
        String query;
        ArrayList<String> categories = new ArrayList<String>();

        try {
            Connection con = Main.db.createDBconnection();
            Statement stmt = con.createStatement();
            query = "SELECT category FROM category;";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                categories.add(rs.getString("category"));
            }

            Main.db.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    public static HashMap<String, Integer> getHashMap() {
        String query;
        HashMap<String, Integer> catID = new HashMap<String, Integer>();

        try {
            Connection con = Main.db.createDBconnection();
            Statement stmt = con.createStatement();
            query = "SELECT category_id, category FROM category;";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                catID.put(rs.getString("category"), rs.getInt("category_id"));
            }

            Main.db.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return catID;
    }

    public ArrayList<Integer> getQuestionIDs(int cID) {
        ArrayList<Integer> questions = new ArrayList<Integer>();
        String query;

        try {
            Connection con = Main.db.createDBconnection();
            Statement stmt = con.createStatement();
            query = "SELECT question_ID FROM question WHERE category_ID='" + cID + "';";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                questions.add(rs.getInt("question_ID"));
            }

            Main.db.closeDBconnection(con);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }

    /* before calling getQuestionAndAnswer(), you should have already used rand on the
    question_id array returned by getQuestionIDs(), and you should now be entering a
    specific question_ID that you want the question, answers etc for*/
    public String[] getQuestionAndAnswer(int qID) {
        String[] questionInfo = new String[8];
        String query;

        try {
            Connection con = Main.db.createDBconnection();
            Statement stmt = con.createStatement();
            query = "SELECT question, ans1, ans2, ans3, ans4, ans5, correct_answer, point_value FROM question WHERE question_ID='" + qID + "';";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                questionInfo[0] = rs.getString("question"); // the question
                questionInfo[1] = rs.getString("ans1"); // possible answer 1
                questionInfo[2] = rs.getString("ans2"); // possible answer 2
                questionInfo[3] = rs.getString("ans3"); // possible answer 3
                questionInfo[4] = rs.getString("ans4"); // possible answer 4
                questionInfo[5] = rs.getString("ans5"); // possible answer 5
                questionInfo[6] = rs.getString("correct_answer"); // the correct answer
                questionInfo[7] = rs.getString("point_value"); // the point value
            }

            Main.db.closeDBconnection(con);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return questionInfo;
    }
}

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

/**
 * QuestionAccess class that is involved in accessing categories and questions
 * from the remote database
 */

public class QuestionAccess {

    /**
     * This function returns an ArrayList of all of the possible categories created
     * in the table category.
     * @return ArrayList populated with all possible categories
     */

    public static ArrayList<String> getCategories() {
        String query;
        ArrayList<String> categories = new ArrayList<String>();

        try {
            Connection con = Database.createDBconnection();
            Statement stmt = con.createStatement();
            query = "SELECT category FROM category;";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                categories.add(rs.getString("category"));
            }

            Database.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    /**
     * This function is similar to getCategories() but instead of placing all of the
     * categories into an ArrayList, the category names and the categoryIDs are placed
     * into a HashMap as key-value pairs.
     * @return HashMap populated with category and categoryID pairs
     */

     public static HashMap<String, Integer> getHashMap() {
        String query;
        HashMap<String, Integer> catID = new HashMap<String, Integer>();

        try {
            Connection con = Database.createDBconnection();
            Statement stmt = con.createStatement();
            query = "SELECT category_id, category FROM category;";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                catID.put(rs.getString("category"), rs.getInt("category_id"));
            }

            Database.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return catID;
    }

    /**
     * This function returns an ArrayList of all of the questionIDs for a specific
     * category. For example, if the user has chosen the category Sports, this function
     * will return an ArrayList of all of the questionIDs contained in the category Sports
     * @param cID the category ID number corresponding to a question category
     * @return ArrayList populated with all question IDs corresponding to the category
     */
    public ArrayList<Integer> getQuestionIDs(int cID) {
        ArrayList<Integer> questions = new ArrayList<Integer>();
        String query;

        try {
            Connection con = Database.createDBconnection();
            Statement stmt = con.createStatement();
            query = "SELECT question_ID FROM question WHERE category_ID='" + cID + "';";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                questions.add(rs.getInt("question_ID"));
            }

            Database.closeDBconnection(con);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }

    /* before calling getQuestionAndAnswer(), you should have already used rand on the
    question_id array returned by getQuestionIDs(), and you should now be entering a
    specific question_ID that you want the question, answers etc for */

    /**
     * This function takes in the parameter questionID, and accesses the question table
     * to retrieve the question, possible answers, and correct answer for that questionID.
     * This information is stored in a String array, with each index representing a different
     * value. This String array is returned.
     * @param qID the ID of the question
     * @return an array of Strings containing question, possible answers, correct answer, and point value
     */
    public String[] getQuestionAndAnswer(int qID) {
        String[] questionInfo = new String[8];
        String query;

        try {
            Connection con = Database.createDBconnection();
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

            Database.closeDBconnection(con);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return questionInfo;
    }

    public boolean createQuestion(int qID, int cID, String q, String a1, String a2, String a3, String a4, String a5, int correctAns) {
        try {
            Connection con = Database.createDBconnection();
            //Statement select_stmt = (Statement) con.createStatement();
            //String query = "SELECT username FROM user WHERE username='" + username + "';";
            //select_stmt.executeQuery(query);
            //ResultSet rs = select_stmt.getResultSet();
            String ins = "INSERT into question (question_ID, category_ID, question, ans1, ans2, ans3, ans4, ans5, correct_answer, point_value) values ('"
                        + qID + "','" + cID + "','" + q + "','" + a1 + "','" + a2 + "','" + a3 + "','" + a4 + "','" + a5 + "','" + correctAns + "','" + 10 + "');";
            Statement ins_stmt = con.createStatement();
            ins_stmt.executeUpdate(ins);

            Database.closeDBconnection(con);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getNewQuestionID(){
        int qID = 0;
        String query;

        try {
            Connection con = Database.createDBconnection();
            Statement stmt = con.createStatement();
            query = "SELECT question_ID FROM question";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                if ( (rs.getInt("question_ID")) >= qID)
                    qID = rs.getInt("question_ID") + 1;
            }

            Database.closeDBconnection(con);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return qID;
    }
}

package edu.ucsb.cs48.util;

import edu.ucsb.cs48.Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Jordan Nguyen on 2/20/2015.
 * HighScore class accesses database to get and set values
 */
public class HighScore {

    public static int getHighScore(String userName) {
        String query;
        int hs = 0;

        try {
            Connection con = Main.db.createDBconnection();
            Statement stmt = con.createStatement();
            query = "SELECT highscore FROM user WHERE username='" + userName + "';";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                hs = rs.getInt("highscore");
            }

            Main.db.closeDBconnection(con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return hs;
    }
}

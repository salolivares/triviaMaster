package edu.ucsb.cs48;

import edu.ucsb.cs48.gui.triviaMain;
import edu.ucsb.cs48.util.Database;
import edu.ucsb.cs48.util.QuestionAccess;
import edu.ucsb.cs48.util.User;

/**
 * Application launcher
 */

public class Main {

    // player is a static variable so it can be accessed by all other classes at runtime
    public static User player;
    public static Database db;
    public static QuestionAccess qa;

    public static void main(String[] args){
        triviaMain gui = new triviaMain();
        player = new User();
        db = new Database();
        qa = new QuestionAccess();

        gui.createWindow();
    }

    /**
     * private constructor so class cannot be instantiated by outside classes
     */
    private Main(){
    }
}



package edu.ucsb.cs48;

import edu.ucsb.cs48.gui.triviaMain;
import edu.ucsb.cs48.util.Database;
import edu.ucsb.cs48.util.QuestionAccess;
import edu.ucsb.cs48.util.Game;
import edu.ucsb.cs48.util.User;
import edu.ucsb.cs48.util.Shop;

import java.sql.Connection;

/**
 * The Application Launcher
 * This is the launching off point for TriviaMaster
 */

public class Main {

    /**
     * All of these variables are static so they can be accessed through out the program's classes
     */
    public static User player;
    public static Database db;
    public static QuestionAccess qa;
    public static Game game;
    public static int gameMode; // 0 - normal mode, 1 - timedmode
    public static Thread gameThread;
    public static Shop shop;

    public static void main(String[] args){
        /**
         * Intialize all the static variables then create gui window
         */
        triviaMain gui = new triviaMain();
        player = new User();
        db = new Database();
        qa = new QuestionAccess();
        shop = new Shop();
        game = new Game();
        gameMode = 0;

        gui.createWindow();

    }

    /**
     * private constructor so class cannot be instantiated by outside classes
     */
    private Main(){
    }
}



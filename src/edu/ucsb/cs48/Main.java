package edu.ucsb.cs48;

import edu.ucsb.cs48.gui.triviaMain;
import edu.ucsb.cs48.util.User;

/**
 * Application launcher
 */

public class Main {
    public static User player;

    public static void main(String[] args){
        triviaMain gui = new triviaMain();
        player = new User();

        gui.createWindow();
    }

    /**
     * private constructor so class cannot be instantiated by outside classes
     */
    private Main(){
    }
}



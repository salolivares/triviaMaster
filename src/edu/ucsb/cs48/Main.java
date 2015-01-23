package edu.ucsb.cs48;

import edu.ucsb.cs48.gui.triviaMain;

/**
 * Application launcher
 */

public class Main {
    public static void main(String[] args){
        triviaMain gui = new triviaMain();
        gui.createWindow();
    }

    /**
     * private constructor so class cannot be instantiated by outside classes
     */
    private Main(){
    }
}



package edu.ucsb.cs48.util;

import edu.ucsb.cs48.gui.countdownTimer;
import edu.ucsb.cs48.gui.triviaMain;

public class Game {

    // Unintialized constants used to choose questions
    // GUI should intialize these
    // Difficulty:
    //        0 - easy
    //        1 - hard
    public static String CATEGORY = "null";
    public static int DIFFICULTY = 0;

    public void start() throws InterruptedException {
        countdownTimer();
    }
    public void end(){
    }
    public void countdownTimer() throws InterruptedException{
        triviaMain.setCurrentPanel(new countdownTimer("3"));
        Thread.sleep(2000);
        triviaMain.setCurrentPanel(new countdownTimer("2"));
        Thread.sleep(2000);
        triviaMain.setCurrentPanel(new countdownTimer("1"));
        Thread.sleep(2000);
    }
}

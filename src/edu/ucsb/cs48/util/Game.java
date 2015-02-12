package edu.ucsb.cs48.util;

import edu.ucsb.cs48.gui.countdownTimer;
import edu.ucsb.cs48.gui.gamePanel;
import edu.ucsb.cs48.gui.mainMenuPanel;
import edu.ucsb.cs48.gui.triviaMain;


public class Game implements Runnable{

    // Uninitialized constants used to choose questions
    // GUI should initialize these
    // Difficulty:
    //        0 - easy
    //        1 - hard
    private String category = "null";
    private int difficulty = 0;
    public static QuestionAndAnswers QandA;


    //mandatory method to make a class run in separate thread
    public void run(){
        try {
            gameStart();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    // starts the main game
    public void gameStart() throws InterruptedException{
        countdownTimer();
        QandA = new QuestionAndAnswers(category,difficulty);
        triviaMain.setCurrentPanel(new gamePanel("Who made the game saving interception in Super Bowl XLIX?", "Richard Sherman",
                "Darrelle Revis", "Malcolm Butler",
                "Earl Thomas","Tom Brady")); // CHANGE THIS TO THE QUESTIONS and ANSWERS PANEL
    }
    public void gameEnd() {
    }

    // counts down on main JFrame
    public void countdownTimer() throws InterruptedException{
        triviaMain.setCurrentPanel(new countdownTimer("3"));
        Thread.sleep(1000);
        triviaMain.setCurrentPanel(new countdownTimer("2"));
        Thread.sleep(1000);
        triviaMain.setCurrentPanel(new countdownTimer("1"));
        Thread.sleep(1000);
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }
}

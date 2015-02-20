package edu.ucsb.cs48.util;

import edu.ucsb.cs48.gui.*;

import java.util.concurrent.CountDownLatch;

/**
 * Game class is the controller the defines gameplay behavior.
 * It is ran in another thread so it can manipulate with GUI,
 * therefore implements Runnable
 */
public class Game implements Runnable {

    private int category = 0;
    private double gameScore = 0;
    public static QuestionAndAnswers QandA;
    public static CountDownLatch latch;


    /**
     * Needed by Runnable Interface.
     * Used to Start the thread
     */
    public void run(){
        try {
            gameStart();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * Starts the core game and sets GUI to gamePanels
     * @see edu.ucsb.cs48.gui.gamePanel
     * @throws InterruptedException Throws exception if thread cannot be put to sleep
     */
    public void gameStart() throws InterruptedException{
        QandA = new QuestionAndAnswers(category);
        int num = QandA.getNumberOfQuestions();
        countdownTimer();
        while(num > 0){
            latch = new CountDownLatch(1);
            triviaMain.setCurrentPanel(new gamePanel(QandA.getQuestion(), QandA.getAnswerOne(), QandA.getAnswerTwo(),
                    QandA.getAnswerThree(), QandA.getAnswerFour(), QandA.getAnswerFive(), QandA.getCorrectAnswer()));
            latch.await();
            num--;
        }
        gameEnd();
    }

    /**
     * Called at the gameStart
     * Sets panel to gameOverPanel when game ends
     */
    public void gameEnd() {
        triviaMain.setCurrentPanel(new gameOverPanel());
    }

    /**
     * Displays a countdown on the GUI
     * @throws InterruptedException throws exceptions if the thread cannot be put to sleep
     */
    public void countdownTimer() throws InterruptedException{
        triviaMain.setCurrentPanel(new countdownTimer("3"));
        Thread.sleep(1000);
        triviaMain.setCurrentPanel(new countdownTimer("2"));
        Thread.sleep(1000);
        triviaMain.setCurrentPanel(new countdownTimer("1"));
        Thread.sleep(1000);
    }

    /**
     * Allows external class or methods to set the game category
     * Must be set before making and running a new game thread
     * @param category An ID (int) that identifies the category in the database
     */
    public void setCategory(int category){
        this.category = category;
    }

    /**
     * Reset the game score to 0 each time a new game is started
     */
    public void resetGameScore() { this.gameScore = 0; }

    /**
     * Add to the current game score when a question is correctly answered
     * @param score the amount of points added to the game score
     */
    public void addToGameScore(double score) { this.gameScore += score; }

    /**
     * get the game score
     * @return current game score
     */
    public double getGameScore() {return this.gameScore; }
}

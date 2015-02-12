package edu.ucsb.cs48.util;

import edu.ucsb.cs48.Main;
import edu.ucsb.cs48.gui.countdownTimer;
import edu.ucsb.cs48.gui.gamePanel;
import edu.ucsb.cs48.gui.mainMenuPanel;
import edu.ucsb.cs48.gui.triviaMain;

import java.util.concurrent.CountDownLatch;


public class Game implements Runnable {

    // Uninitialized constants used to choose questions
    // GUI should initialize these
    // Difficulty:
    //        0 - easy
    //        1 - hard
    private int category = 0;
    public static QuestionAndAnswers QandA;
    public static CountDownLatch latch;


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
        QandA = new QuestionAndAnswers(category);
        int num = QandA.getNumberOfQuestions();
        while(num > 0){
            latch = new CountDownLatch(1);
            triviaMain.setCurrentPanel(new gamePanel(QandA.getQuestion(), QandA.getAnswerOne(), QandA.getAnswerTwo(),
                    QandA.getAnswerThree(), QandA.getAnswerFour(), QandA.getAnswerFive()));
            latch.await();
            num--;
        }
        gameEnd();
    }
    public void gameEnd() {
        triviaMain.setCurrentPanel(new mainMenuPanel());
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
    public void setCategory(int category){
        this.category = category;
    }
}

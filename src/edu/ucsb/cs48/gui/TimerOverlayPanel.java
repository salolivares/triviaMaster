package edu.ucsb.cs48.gui;

import edu.ucsb.cs48.Main;

import javax.swing.*;
import java.awt.*;

/**
 * Paints a countdown timer on the gamePanel if user selected
 * time mode
 * @see edu.ucsb.cs48.gui.gamePanel
 * @see edu.ucsb.cs48.gui.gameModePanel
 * @see edu.ucsb.cs48.util.Game
 */
public class TimerOverlayPanel extends JPanel implements Runnable{
    JLabel timeLabel;
    public static int timerValue = 30; //represents the number of seconds

    /**
     * Paints a timer on panel that is being displayed
     * @param g system painter
     */
    public void paintComponent(Graphics g){
        /*******************************************************
         * If timer reaches zero, erase the timer off the panel.
         * If not, display new timer value on panel
         */
        if(timerValue <= 0){
            timeLabel = new JLabel("");
        }
        else {
            timeLabel = new JLabel(Integer.toString(timerValue));
        }
        /********************************************************/

        //set font properties and display timer
        timeLabel.setFont(new Font("Arial",Font.PLAIN, 30));
        timeLabel.setBounds(100,100,400,30);
        timeLabel.paint(g);
    }

    /**
     * This constructor is called whenever a new timeroverlay is made
     * It initiziales timer value which represent the number of seconds
     */
    public TimerOverlayPanel(){
        timerValue = 30;
        setLayout(null);
    }

    /**
     * Called whenever a new thread of this class is made.
     * It first displays the timer value on the panel
     * then makes the counter count down till it reaches zero.
     * @see edu.ucsb.cs48.util.Game
     */
    @Override
    public void run() {
        setupTimerOverlay();
        runTimer();
        Main.game.gameEnd();
    }

    /**
     * First paints timer on panel
     */
    private synchronized void setupTimerOverlay(){
        this.setOpaque(false);
        triviaMain.mainFrame.setGlassPane(this);
        this.setVisible(true);
        triviaMain.mainFrame.repaint();
    }

    /**
     * Makes the timer value update every second
     * to make it mirror a real countdown timer
     */
    private void runTimer(){
        while(timerValue != 0){
            try{
                Thread.sleep(1000);
            } catch (Exception e){
                e.printStackTrace();
            }
            timerValue--;
            triviaMain.mainFrame.repaint();
        }
    }
}

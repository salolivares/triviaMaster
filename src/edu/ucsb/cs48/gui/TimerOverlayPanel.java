package edu.ucsb.cs48.gui;

import edu.ucsb.cs48.Main;

import javax.swing.*;
import java.awt.*;

public class TimerOverlayPanel extends JPanel implements Runnable{
    JLabel timeLabel;
    public static int timerValue = 30;

    public void paintComponent(Graphics g){
        if(timerValue <= 0){
            timeLabel = new JLabel("");
        }
        else {
            timeLabel = new JLabel(Integer.toString(timerValue));
        }
        timeLabel.setFont(new Font("Arial",Font.PLAIN, 30));
        timeLabel.setBounds(100,100,400,30);
        timeLabel.paint(g);
    }

    public TimerOverlayPanel(){
        timerValue = 30;
        setLayout(null);
    }

    @Override
    public void run() {
        setupTimerOverlay();
        runTimer();
        Main.game.gameEnd();
        triviaMain.setCurrentPanel(new gameOverPanel());
    }

    private synchronized void setupTimerOverlay(){
        this.setOpaque(false);
        triviaMain.mainFrame.setGlassPane(this);
        this.setVisible(true);
        triviaMain.mainFrame.repaint();
    }
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

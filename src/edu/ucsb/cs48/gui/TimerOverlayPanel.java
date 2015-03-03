package edu.ucsb.cs48.gui;

import javax.swing.*;
import java.awt.*;

public class TimerOverlayPanel extends JPanel implements Runnable{
    JLabel timeLabel;
    public static int timerValue = 60;

    public void paintComponent(Graphics g){
        timeLabel = new JLabel(Integer.toString(timerValue));
        timeLabel.setBounds(0,0,400,30);
        timeLabel.paint(g);
    }

    public TimerOverlayPanel(){
        timerValue = 60;
    }

    @Override
    public void run() {
        setupTimerOverlay();
        runTimer();
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

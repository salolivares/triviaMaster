package edu.ucsb.cs48.gui;

import javax.swing.*;
import java.awt.*;

/**
 * countdownTimer class that creates a countdown prior to starting the game
 */
public class countdownTimer extends JPanel {
    //GUI Components
    JLabel numberLabel;

    /**
     * countdownTimer constructor
     * @param number the string that will be displayed on the panel
     */
    public countdownTimer(String number){
        numberLabel = new JLabel(number);

        //set layout manager
        setLayout(new BorderLayout());
        //set font size
        numberLabel.setFont(new Font("Serif", Font.BOLD, 48));
        numberLabel.setVerticalAlignment(SwingConstants.CENTER);
        numberLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //add components
        add(numberLabel,BorderLayout.CENTER);
    }

}

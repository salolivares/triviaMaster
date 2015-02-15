package edu.ucsb.cs48.gui;

import javax.swing.*;
import java.awt.*;

public class countdownTimer extends JPanel {
    //GUI Components
    JLabel numberLabel;

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

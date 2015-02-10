package edu.ucsb.cs48.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Jordan Nguyen on 2/9/2015.
 */
public class gamePanel extends JPanel{

    JPanel mainPanel;
    JLabel question;
    JRadioButton answer1;
    JRadioButton answer2;
    JRadioButton answer3;
    JRadioButton answer4;
    JRadioButton answer5;
    String q  = "question";
    String a1 = "answer 1";
    String a2 = "answer 2";
    String a3 = "answer 3";
    String a4 = "answer 4";
    String a5 = "answer 5";
    JButton submit;

    public gamePanel() {

        mainPanel = new JPanel();
        question  = new JLabel(q);
        answer1   = new JRadioButton(a1);
        answer2   = new JRadioButton(a2);
        answer3   = new JRadioButton(a3);
        answer4   = new JRadioButton(a4);
        answer5   = new JRadioButton(a5);
        submit    = new JButton("Submit Answer");

        question.setFont(new Font("Serif", Font.PLAIN, 28));
        question.setHorizontalAlignment(SwingConstants.CENTER);
        question.setVerticalAlignment(SwingConstants.CENTER);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        submit.setMnemonic(KeyEvent.VK_ENTER);
        answer1.setMnemonic(KeyEvent.VK_1);
        answer2.setMnemonic(KeyEvent.VK_2);
        answer3.setMnemonic(KeyEvent.VK_3);
        answer4.setMnemonic(KeyEvent.VK_4);
        answer5.setMnemonic(KeyEvent.VK_5);

        ButtonGroup group = new ButtonGroup();
        group.add(answer1);
        group.add(answer2);
        group.add(answer3);
        group.add(answer4);
        group.add(answer5);

        mainPanel.add(question);
        mainPanel.add(answer1);
        mainPanel.add(answer2);
        mainPanel.add(answer3);
        mainPanel.add(answer4);
        mainPanel.add(answer5);
        mainPanel.add(submit);

        add(mainPanel);

        submit.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                triviaMain.setCurrentPanel(new categoryPanel());
            }
        });

        submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new categoryPanel());
            }
        });

    }

}




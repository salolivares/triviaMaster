package edu.ucsb.cs48.gui;

import edu.ucsb.cs48.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Jordan Nguyen on 2/20/2015.
 * This class allows user to view their high score and points
 */
public class profilePanel extends JPanel{
    JLabel username;
    JLabel highscore;
    JLabel points;
    JLabel bomb;
    JLabel autoAnswer;
    JButton back;
    JPanel mainpanel;

    public profilePanel() {

        // instantiate components
        username = new JLabel("Username: " + Main.player.getUsername());
        highscore = new JLabel("High Score: " + Main.player.getHighScore());
        points = new JLabel("Points Available: " + Main.player.getPoints());
        bomb = new JLabel("Bombs Owned: " + Main.shop.numberOfQuestionEliminator(Main.player.getUsername()));
        autoAnswer = new JLabel("Auto Answers Owned: " + Main.shop.numberOfAutoAnswer(Main.player.getUsername()));
        back = new JButton("Main Menu");
        mainpanel = new JPanel(new GridBagLayout());
        setLayout(new BorderLayout());

        username.setFont(new Font("Courier New", Font.BOLD, 30));
        username.setVerticalAlignment(SwingConstants.CENTER);
        username.setHorizontalAlignment(SwingConstants.CENTER);

        highscore.setFont(new Font("Courier New", Font.BOLD, 24));
        highscore.setVerticalAlignment(SwingConstants.CENTER);
        highscore.setHorizontalAlignment(SwingConstants.CENTER);

        points.setFont(new Font("Courier New", Font.BOLD, 24));
        points.setVerticalAlignment(SwingConstants.CENTER);
        points.setHorizontalAlignment(SwingConstants.CENTER);

        bomb.setFont(new Font("Courier New", Font.BOLD, 24));
        bomb.setVerticalAlignment(SwingConstants.CENTER);
        bomb.setHorizontalAlignment(SwingConstants.CENTER);

        autoAnswer.setFont(new Font("Courier New", Font.BOLD, 24));
        autoAnswer.setVerticalAlignment(SwingConstants.CENTER);
        autoAnswer.setHorizontalAlignment(SwingConstants.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20,20,20,20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainpanel.add(username, gbc);
        gbc.gridy = 1;
        mainpanel.add(highscore, gbc);
        gbc.gridy = 2;
        mainpanel.add(points, gbc);
        gbc.gridy = 3;
        mainpanel.add(bomb, gbc);
        gbc.gridy = 4;
        mainpanel.add(autoAnswer, gbc);
        gbc.gridx = 3;
        gbc.gridy = 5;
        mainpanel.add(back, gbc);

        add(mainpanel, BorderLayout.CENTER);

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new mainMenuPanel());
            }
        });

    }

}

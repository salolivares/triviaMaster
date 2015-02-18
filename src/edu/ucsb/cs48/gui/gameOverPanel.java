package edu.ucsb.cs48.gui;


import edu.ucsb.cs48.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gameOverPanel extends JPanel {

    JButton mainMenu;
    JLabel gameOver;
    JLabel highScore;

    public gameOverPanel() {
        setBackground(Color.darkGray);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        //setLayout(new GridBagLayout());


        mainMenu = new JButton("Return to Main Menu");
        gameOver = new JLabel("Game Over");
        highScore = new JLabel("High Score: " + Double.toString(Main.game.getGameScore()));

        gameOver.setFont(new Font("Courier New", Font.BOLD, 90));
        gameOver.setVerticalAlignment(SwingConstants.CENTER);
        gameOver.setHorizontalAlignment(SwingConstants.CENTER);

        highScore.setFont(new Font("Courier New", Font.BOLD, 35));
        highScore.setVerticalAlignment(SwingConstants.CENTER);
        highScore.setHorizontalAlignment(SwingConstants.CENTER);


        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(0,0,75,0);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(gameOver, gbc);

        gbc.insets = new Insets(75,0,100,0);
        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(highScore, gbc);

        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady = 30;
        gbc.ipadx = 50;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(mainMenu, gbc);




        mainMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new mainMenuPanel());
            }
        });


    }


}

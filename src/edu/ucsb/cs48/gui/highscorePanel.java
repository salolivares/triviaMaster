package edu.ucsb.cs48.gui;

import javax.swing.*;
import java.awt.*;


public class highscorePanel extends JPanel{
    //Java Gui Components
    JLabel PlayerLabel;
    JLabel HighScoreheaderLabel;
    JLabel HighScoreLabel;
    JPanel HighScoreBotPanel;
    JPanel HighScoreTopPanel;
    JPanel EmptySpace;
    JLabel Empty;
    GridBagConstraints gbc;


    public highscorePanel(){
        HighScoreheaderLabel = new JLabel("High Score Leaderboard");
        PlayerLabel = new JLabel("Player");
        HighScoreLabel = new JLabel("High Score");
        HighScoreTopPanel = new JPanel(new BorderLayout());
        HighScoreBotPanel = new JPanel(new GridBagLayout());
        EmptySpace = new JPanel(new BorderLayout(5,5));
        Empty = new JLabel();
        gbc = new GridBagConstraints();

        PlayerLabel.setFont(new Font("Serif", Font.BOLD, 16));
        PlayerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        PlayerLabel.setVerticalAlignment(SwingConstants.CENTER);

        HighScoreheaderLabel.setFont(new Font("Serif", Font.BOLD, 26));
        HighScoreheaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        HighScoreheaderLabel.setVerticalAlignment(SwingConstants.CENTER);

        HighScoreLabel.setFont(new Font("Serif", Font.BOLD, 16));
        HighScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        HighScoreLabel.setVerticalAlignment(SwingConstants.CENTER);


        HighScoreTopPanel.add(PlayerLabel, BorderLayout.WEST);
        HighScoreTopPanel.add(Empty, BorderLayout.CENTER);
        HighScoreTopPanel.add(HighScoreheaderLabel,BorderLayout.NORTH);
        HighScoreTopPanel.add(HighScoreLabel, BorderLayout.EAST);
        /*gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        HighScoreBotPanel.add(PlayerLabel, gbc);
        gbc.gridx = 10;
        gbc.gridy = 3;
        HighScoreBotPanel.add(HighScoreLabel,gbc);
        */
        //HighScoreBotPanel.add(HighScoreheaderLabel, BorderLayout.NORTH);
        //HighScoreBotPanel.add(HighScoreLabel, BorderLayout.EAST);
        add(HighScoreTopPanel);
        add(HighScoreBotPanel);
    }}
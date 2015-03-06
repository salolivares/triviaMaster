package edu.ucsb.cs48.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * mainMenuPanel class that presents the main menu after login
 * Allows user to play game, view high scores, manage options, and enter the shop
 */

public class mainMenuPanel extends JPanel{
    //Java GUI Components
    JButton playGameButton;
    JButton viewHighScoreButton;
    JButton enterShopButton;
    JButton submitQuestion;
    JButton optionsButton;
    JButton profile;
    JLabel welcomeToLabel;
    JPanel topPanel;
    JPanel botPanel;
    GridBagConstraints gbc;

    /**
     * mainMenuPanel default constructor
     */
    public mainMenuPanel(){
        playGameButton = new JButton("Play Game");
        viewHighScoreButton = new JButton("View High Scores");
        optionsButton = new JButton("Options");
        enterShopButton = new JButton("Enter Shop");
        submitQuestion = new JButton("Submit Questions");
        profile = new JButton("View Profile");
        welcomeToLabel = new JLabel("Welcome to Trivia Master");
        topPanel = new JPanel(new BorderLayout());
        botPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();

        //set layout manager
        setLayout(new GridLayout(2, 1));

        //set label font and size
        welcomeToLabel.setFont(new Font("Serif", Font.BOLD, 48));
        welcomeToLabel.setVerticalAlignment(SwingConstants.CENTER);
        welcomeToLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //add components to top panel
        topPanel.add(welcomeToLabel,BorderLayout.CENTER);

        //add objects to bot panel and configure GBC constrains
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        botPanel.add(playGameButton, gbc);
        gbc.gridx = 3;
        gbc.gridy = 2;
        botPanel.add(enterShopButton, gbc);
        gbc.gridx = 3;
        gbc.gridy = 3;
        botPanel.add(submitQuestion, gbc);
        gbc.gridx = 3;
        gbc.gridy = 4;
        botPanel.add(viewHighScoreButton, gbc);
        gbc.gridx = 3;
        gbc.gridy = 5;
        botPanel.add(profile, gbc);
        gbc.gridy = 6;
        botPanel.add(optionsButton, gbc);

        //add bot and top panel
        add(topPanel);
        add(botPanel);

        // event manager
        playGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new gameModePanel());
            }
        });
        viewHighScoreButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new highscorePanel());
            }
        });
        enterShopButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new shopPanel());
            }
        });
        optionsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new optionsPanel());
            }
        });

        profile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new profilePanel());
            }
        });

        submitQuestion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new submitQuestionPanel());
            }
        });
    }

}

package edu.ucsb.cs48.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mainMenuPanel extends JPanel{
    //Java GUI Components
    JButton playGameButton;
    JButton viewHighScoreButton;
    JButton enterShopButton;
    JLabel welcomeToLabel;
    JPanel topPanel;
    JPanel botPanel;
    GridBagConstraints gbc;

    public mainMenuPanel(){
        playGameButton = new JButton("Play Game");
        viewHighScoreButton = new JButton("View High Scores");
        enterShopButton = new JButton("Enter Shop");
        welcomeToLabel = new JLabel("Welcome to Trivia Master");
        topPanel = new JPanel(new BorderLayout());
        botPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();

        //set layout manager
        setLayout(new GridLayout(2,1));

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
        botPanel.add(viewHighScoreButton, gbc);

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
    }

}

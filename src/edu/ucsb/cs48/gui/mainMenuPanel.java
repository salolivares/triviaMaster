package edu.ucsb.cs48.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

/**
 * mainMenuPanel class that presents the main menu after login
 * Allows user to play game, view high scores, learn how to play, and enter the shop
 */

public class mainMenuPanel extends JPanel{
    //Java GUI Components
    JButton playGameButton;
    JButton viewHighScoreButton;
    JButton enterShopButton;
    JButton howtoplaybutton;
    JButton profile;
    JLabel welcomeToLabel;
    JLabel background;
    JPanel topPanel;
    JPanel botPanel;
    GridBagConstraints gbc;

    /**
     * mainMenuPanel default constructor
     */
    public mainMenuPanel(){
        playGameButton = new JButton("Play Game");
        viewHighScoreButton = new JButton("View High Scores");
        howtoplaybutton = new JButton(    "How To Play");
        enterShopButton = new JButton("Enter Shop");
        profile = new JButton("View Profile");
        welcomeToLabel = new JLabel("Welcome to Trivia Master");
        topPanel = new JPanel(new BorderLayout());
        botPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();

//        Image image = null;
//        try{
//            //URL url = new URL("file:///C:/Users/brand_000/Documents/GitHub/triviaMaster/assets/background.jpg");
//            URL url = new URL("file:/assets/background.jpg");
//            image = ImageIO.read(url);
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

        background = new JLabel(new ImageIcon("assets/background.jpg"));
        background.setOpaque(false);
        add(background);
        background.setLayout(new GridBagLayout());

        //set layout manager
        setLayout(new BorderLayout());

        //set label font and size
        welcomeToLabel.setFont(new Font("Serif", Font.BOLD, 48));
        welcomeToLabel.setVerticalAlignment(SwingConstants.CENTER);
        welcomeToLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //add components to top panel
        //topPanel.add(welcomeToLabel,BorderLayout.CENTER);

        //add objects to bot panel and configure GBC constrains
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0,0,175,0);
        background.add(welcomeToLabel, gbc);
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady = 10;
        gbc.ipadx = 50;
        background.add(playGameButton, gbc);
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.ipady = 10;
        gbc.ipadx = 50;
        background.add(enterShopButton, gbc);
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.ipady = 10;
        gbc.ipadx = 15;
        background.add(viewHighScoreButton, gbc);
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.ipady = 10;
        gbc.ipadx = 50;
        background.add(howtoplaybutton, gbc);
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.ipady = 10;
        gbc.ipadx = 50;
        gbc.insets = new Insets(0,0,50,0);
        background.add(profile, gbc);

        //add bot and top panel
        //add(topPanel);
        //add(botPanel);
        add(background);

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
        howtoplaybutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new howtoplayPanel());
            }
        });

        profile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new profilePanel());
            }
        });
    }

}

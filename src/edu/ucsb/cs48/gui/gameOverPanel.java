package edu.ucsb.cs48.gui;


import edu.ucsb.cs48.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * gameOverPanel class that is displayed when the game is over.
 * This class displays the user's game score
 */
public class gameOverPanel extends JPanel {

    JButton mainMenu;
    JLabel gameOver;
    JLabel highScore;
    JLabel background;
    URL url;
    AudioClip sound;
    GridBagConstraints gbc;

    /**
     * gameOverPanel default constructor
     */
    public gameOverPanel() {

        try {
            //url = new URL("file:///C:/Users/brand_000/Documents/GitHub/triviaMaster/assets/cheering.wav");
            url = new URL("file:assets/cheering.wav");
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }

        sound = java.applet.Applet.newAudioClip(url);
        sound.play();


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
        background.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();


        setLayout(new BorderLayout());
        mainMenu = new JButton("Return to Main Menu");
        gameOver = new JLabel("Game Over");
        highScore = new JLabel("Your Score: " + Double.toString(Main.game.getGameScore()));

        gameOver.setFont(new Font("Courier New", Font.BOLD, 90));
        gameOver.setVerticalAlignment(SwingConstants.CENTER);
        gameOver.setHorizontalAlignment(SwingConstants.CENTER);

        highScore.setFont(new Font("Courier New", Font.BOLD, 35));
        highScore.setVerticalAlignment(SwingConstants.CENTER);
        highScore.setHorizontalAlignment(SwingConstants.CENTER);


        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(25,0,75,0);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        background.add(gameOver, gbc);

        gbc.insets = new Insets(66,0,50,0);
        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        background.add(highScore, gbc);

        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.insets = new Insets(50,600,0,0);
        gbc.ipady = 30;
        gbc.ipadx = 30;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 2;
        background.add(mainMenu, gbc);

        add(background, BorderLayout.CENTER);



        mainMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new mainMenuPanel());
            }
        });


    }


}

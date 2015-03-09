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
    URL url;
    AudioClip sound;
    JLabel background;

    public profilePanel() {


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
        //add(background);
        background.setLayout(new GridBagLayout());

        // instantiate components
        username = new JLabel("Username: " + Main.player.getUsername());
        highscore = new JLabel("High Score: " + Main.player.getHighScore());
        points = new JLabel("Points Available: " + Main.player.getPoints());
        bomb = new JLabel("Bombs Owned: " + Main.shop.numberOfQuestionEliminator(Main.player.getUsername()));
        autoAnswer = new JLabel("Auto Answers Owned: " + Main.shop.numberOfAutoAnswer(Main.player.getUsername()));
        back = new JButton("Main Menu");
        //mainpanel = new JPanel(new GridBagLayout());
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
        background.add(username, gbc);
        gbc.gridy = 1;
        background.add(highscore, gbc);
        gbc.gridy = 2;
        background.add(points, gbc);
        gbc.gridy = 3;
        background.add(bomb, gbc);
        gbc.gridy = 4;
        background.add(autoAnswer, gbc);
        gbc.gridx = 3;
        gbc.gridy = 5;
        background.add(back, gbc);

        add(background, BorderLayout.CENTER);

        try {
            //url = new URL("file:///C:/Users/brand_000/Documents/GitHub/triviaMaster/assets/fanfare.wav");
            url = new URL("file:assets/fanfare.wav");
        }
        catch (MalformedURLException es) {
            es.printStackTrace();
        }

        sound = java.applet.Applet.newAudioClip(url);
        sound.play();

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new mainMenuPanel());
            }
        });

    }

}

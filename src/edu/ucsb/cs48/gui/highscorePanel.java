package edu.ucsb.cs48.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.ucsb.cs48.Main;

/**
 * highscorePanel class that displays the top 5 high scores
 */
public class highscorePanel extends JPanel{
    //Java Gui Components
    JButton backbutton;
    JLabel PlayerLabel;
    JLabel HighScoreheaderLabel;
    JLabel HighScoreLabel;
    JPanel HighScorePanel;
    JLabel P1;
    JLabel P2;
    JLabel P3;
    JLabel P4;
    JLabel P5;
    JLabel P1HS;
    JLabel P2HS;
    JLabel P3HS;
    JLabel P4HS;
    JLabel P5HS;
    ArrayList<String> usernames;

    /**
     * highscorePanel default constructor
     */
    public highscorePanel(){
        usernames = Main.player.getTopFiveUsers();
        HighScoreheaderLabel = new JLabel("High Score Leaderboard");
        PlayerLabel = new JLabel("Player");
        HighScoreLabel = new JLabel("High Score");
        HighScorePanel = new JPanel();
        P1 = new JLabel("" + usernames.get(0));
        P2 = new JLabel("" + usernames.get(1));
        P3 = new JLabel("" + usernames.get(2));
        P4 = new JLabel("" + usernames.get(3));
        P5 = new JLabel("" + usernames.get(4));
        P1HS = new JLabel("" + Main.player.getHighScore(usernames.get(0)));
        P2HS = new JLabel("" + Main.player.getHighScore(usernames.get(1)));
        P3HS = new JLabel("" + Main.player.getHighScore(usernames.get(2)));
        P4HS = new JLabel("" + Main.player.getHighScore(usernames.get(3)));
        P5HS = new JLabel("" + Main.player.getHighScore(usernames.get(4)));
        backbutton = new JButton("Back");


        this.setLayout(null);

        P1.setFont(new Font("Serif", Font.BOLD, 20));
        P1.setHorizontalAlignment(SwingConstants.CENTER);
        P1.setVerticalAlignment(SwingConstants.CENTER);
        P2.setFont(new Font("Serif", Font.BOLD, 20));
        P2.setHorizontalAlignment(SwingConstants.CENTER);
        P2.setVerticalAlignment(SwingConstants.CENTER);
        P3.setFont(new Font("Serif", Font.BOLD, 20));
        P3.setHorizontalAlignment(SwingConstants.CENTER);
        P3.setVerticalAlignment(SwingConstants.CENTER);
        P4.setFont(new Font("Serif", Font.BOLD, 20));
        P4.setHorizontalAlignment(SwingConstants.CENTER);
        P4.setVerticalAlignment(SwingConstants.CENTER);
        P5.setFont(new Font("Serif", Font.BOLD, 20));
        P5.setHorizontalAlignment(SwingConstants.CENTER);
        P5.setVerticalAlignment(SwingConstants.CENTER);
        P1HS.setFont(new Font("Serif", Font.BOLD, 20));
        P1HS.setHorizontalAlignment(SwingConstants.CENTER);
        P1HS.setVerticalAlignment(SwingConstants.CENTER);
        P2HS.setFont(new Font("Serif", Font.BOLD, 20));
        P2HS.setHorizontalAlignment(SwingConstants.CENTER);
        P2HS.setVerticalAlignment(SwingConstants.CENTER);
        P3HS.setFont(new Font("Serif", Font.BOLD, 20));
        P3HS.setHorizontalAlignment(SwingConstants.CENTER);
        P3HS.setVerticalAlignment(SwingConstants.CENTER);
        P4HS.setFont(new Font("Serif", Font.BOLD, 20));
        P4HS.setHorizontalAlignment(SwingConstants.CENTER);
        P4HS.setVerticalAlignment(SwingConstants.CENTER);
        P5HS.setFont(new Font("Serif", Font.BOLD, 20));
        P5HS.setHorizontalAlignment(SwingConstants.CENTER);
        P5HS.setVerticalAlignment(SwingConstants.CENTER);
        PlayerLabel.setFont(new Font("Serif", Font.BOLD, 28));
        PlayerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        PlayerLabel.setVerticalAlignment(SwingConstants.CENTER);

        HighScoreheaderLabel.setFont(new Font("Serif", Font.BOLD, 34));
        HighScoreheaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        HighScoreheaderLabel.setVerticalAlignment(SwingConstants.CENTER);

        HighScoreLabel.setFont(new Font("Serif", Font.BOLD, 28));
        HighScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        HighScoreLabel.setVerticalAlignment(SwingConstants.CENTER);

        this.add(backbutton);
        this.add(PlayerLabel);
        this.add(HighScoreheaderLabel);
        this.add(HighScoreLabel);
        this.add(P1);
        this.add(P2);
        this.add(P3);
        this.add(P4);
        this.add(P5);
        this.add(P1HS);
        this.add(P2HS);
        this.add(P3HS);
        this.add(P4HS);
        this.add(P5HS);

        backbutton.setLocation(600,500);
        HighScoreLabel.setLocation(490,100);
        PlayerLabel.setLocation(90,100);
        HighScoreheaderLabel.setLocation(150,50);
        P1.setLocation(90,150);
        P2.setLocation(90,200);
        P3.setLocation(90,250);
        P4.setLocation(90,300);
        P5.setLocation(90,350);
        P1HS.setLocation(520,150);
        P2HS.setLocation(520,200);
        P3HS.setLocation(520,250);
        P4HS.setLocation(520,300);
        P5HS.setLocation(520,350);

        backbutton.setSize(75,25);
        HighScoreLabel.setSize(200,50);
        PlayerLabel.setSize(150,50);
        HighScoreheaderLabel.setSize(500,50);
        P1.setSize(150,50);
        P2.setSize(150,50);
        P3.setSize(150, 50);
        P4.setSize(150,50);
        P5.setSize(150,50);
        P1HS.setSize(150,50);
        P2HS.setSize(150,50);
        P3HS.setSize(150,50);
        P4HS.setSize(150,50);
        P5HS.setSize(150,50);

        backbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new mainMenuPanel());
            }
        });
        add(HighScorePanel);
    }

    // pointComponent method that paints the background of the panel a gradient blue
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(0,0, Color.BLUE, 800, 600, Color.CYAN);
        g2d.setPaint(gradient);
        g2d.fillRect(0,0, 800, 600);
    }

}
package edu.ucsb.cs48.gui;


import edu.ucsb.cs48.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

/**
 * gameModePanel class that lets users select which game mode to play
 * Version 1.0: only Classic mode works.
 */

public class gameModePanel extends JPanel{
    JButton mode1;
    JButton mode2;
    JButton mainMenu;
    JLabel selectMode;
    JLabel background;
    GridBagConstraints gbc;
    /**
     * gameModePanel default constructor
     */
    gameModePanel() {

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

        mode1 = new JButton("Classic");
        mode2 = new JButton("Timed");
        mainMenu = new JButton("Return to Main Menu");
        selectMode = new JLabel("Choose game mode");
        setLayout(new BorderLayout());

        selectMode.setFont(new Font("Serif", Font.BOLD, 36));
        selectMode.setHorizontalAlignment(SwingConstants.CENTER);
        selectMode.setVerticalAlignment(SwingConstants.CENTER);

        //mainPanel = new JPanel(new GridLayout(5,1))
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(25,0,75,0);
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        background.add(selectMode, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipady = 50;
        gbc.ipadx = 300;
        gbc.insets = new Insets(0,0,10,0);
        background.add(mode1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipady = 50;
        gbc.ipadx = 300;
        background.add(mode2, gbc);
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.insets = new Insets(50,600,0,0);
        gbc.ipady = 20;
        gbc.ipadx = 25;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 3;
        background.add(mainMenu, gbc);

        add(background, BorderLayout.CENTER);

        mode1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new categoryPanel());
                Main.gameMode = 0;
            }
        });

        mode2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new categoryPanel());
                Main.gameMode = 1;
            }
        });

        mainMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new mainMenuPanel());
            }
        });

    }

}
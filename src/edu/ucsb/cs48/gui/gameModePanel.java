package edu.ucsb.cs48.gui;


import edu.ucsb.cs48.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * gameModePanel class that lets users select which game mode to play
 * Version 1.0: only Classic mode works.
 */

public class gameModePanel extends JPanel{
    JButton mode1;
    JButton mode2;
    JButton mainMenu;
    JLabel selectMode;
    JLabel notAvailable;
    JPanel mainPanel;

    /**
     * gameModePanel default constructor
     */
    gameModePanel() {
        mode1 = new JButton("Classic");
        mode2 = new JButton("Timed");
        mainMenu = new JButton("Return to Main Menu");
        selectMode = new JLabel("Choose game mode");
        notAvailable = new JLabel("This mode is not available yet!");

        selectMode.setFont(new Font("Serif", Font.BOLD, 32));
        selectMode.setHorizontalAlignment(SwingConstants.CENTER);
        selectMode.setVerticalAlignment(SwingConstants.CENTER);

        notAvailable.setFont(new Font("Serif", Font.BOLD, 16));
        notAvailable.setForeground(Color.RED);
        notAvailable.setHorizontalAlignment(SwingConstants.CENTER);
        notAvailable.setVerticalAlignment(SwingConstants.CENTER);
        notAvailable.setVisible(false);


        mainPanel = new JPanel(new GridLayout(5,1));
        mainPanel.add(selectMode);
        mainPanel.add(mode1);
        mainPanel.add(mode2);
        mainPanel.add(mainMenu);
        mainPanel.add(notAvailable);

        add(mainPanel);

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
package edu.ucsb.cs48.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gameModePanel extends JPanel{
    JButton mode1;
    JButton mode2;
    JButton mainMenu;
    JLabel selectMode;
    JPanel mainPanel;

    gameModePanel() {
        mode1 = new JButton("Classic");
        mode2 = new JButton("Timed");
        mainMenu = new JButton("Return to Main Menu");
        selectMode = new JLabel("Choose game mode");

        selectMode.setFont(new Font("Serif", Font.BOLD, 32));
        selectMode.setHorizontalAlignment(SwingConstants.CENTER);
        selectMode.setVerticalAlignment(SwingConstants.CENTER);

        mainPanel = new JPanel(new GridLayout(4,1));
        mainPanel.add(selectMode);
        mainPanel.add(mode1);
        mainPanel.add(mode2);
        mainPanel.add(mainMenu);
        // test comment

        add(mainPanel);

        mode1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new categoryPanel());
            }
        });

        mode2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new categoryPanel());
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
package edu.ucsb.cs48.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class howtoplayPanel extends JPanel {
    JLabel title;
    JLabel background;
    JLabel description;
    JButton menu;
    GridBagConstraints gbc;


    /**
     * howtoplayPanel class that allows users to learn how to play TriviaMaster
     */
    public howtoplayPanel() {
        background = new JLabel(new ImageIcon("assets/background.jpg"));
        background.setOpaque(false);
        add(background);
        background.setLayout(new GridBagLayout());

        title = new JLabel("Options");
        gbc = new GridBagConstraints();

        //set layout manager
        setLayout(new BorderLayout());

        // sets title
        title = new JLabel("How To Play");
        title.setFont(new Font("Courier New", Font.BOLD, 70));
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(0,0,0,0);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        background.add(title, gbc);

        //sets description
        description = new JLabel("<html> 1) Click Play Game <br/>" +
                "2) Choose a game mode <br/>" +
                "3) Pick a category and start game <br/>" +
                "4) Use keys (1,2,3,4,5) or mouse to select an answer <br/>" +
                "and press \"Enter\" to submit selection. <br/>" +
                "</html>", JLabel.CENTER);
        description.setFont(new Font("Corier New", Font.BOLD, 20));
        gbc.insets = new Insets(75,0,0,0);
        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        background.add(description, gbc);

        // back button
        menu = new JButton("Return to Main Menu");
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.insets = new Insets(50,600,0,0);
        gbc.ipady = 30;
        gbc.ipadx = 30;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 3;
        background.add(menu, gbc);

        add(background, BorderLayout.CENTER);

        menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new mainMenuPanel());
            }
        });

    }
}

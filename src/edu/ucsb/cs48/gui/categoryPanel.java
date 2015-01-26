package edu.ucsb.cs48.gui;


import javax.swing.*;
import java.awt.*;

public class categoryPanel extends JPanel {
    //Java GUI Components

    JPanel mainPanel;
    JLabel selectCategory;
    JButton startGame;
    JComboBox dropMenu;

    public categoryPanel() {
        String[] categories = {"Test 1", "Test 2", "Test 3"}; // when we actually implement this, maybe use a
        selectCategory = new JLabel("Choose a category");     // for loop or something on the mySQL table w/ addItem()
        startGame = new JButton("Start Game!");
        dropMenu = new JComboBox(categories);
        mainPanel = new JPanel(new BorderLayout());

        selectCategory.setFont(new Font("Serif", Font.BOLD, 32));
        selectCategory.setHorizontalAlignment(SwingConstants.CENTER);
        selectCategory.setVerticalAlignment(SwingConstants.CENTER);

        mainPanel.add(selectCategory, BorderLayout.NORTH);
        mainPanel.add(dropMenu, BorderLayout.CENTER);
        mainPanel.add(startGame, BorderLayout.SOUTH);

        add(mainPanel);
    }


}




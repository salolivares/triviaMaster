package edu.ucsb.cs48.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class categoryPanel extends JPanel {
    //Java GUI Components

    JPanel mainPanel;
    JLabel selectCategory;
    JButton startGame;
    JButton backButton;
    JComboBox dropMenu;

    public categoryPanel() {
        String[] categories = {"Test 1", "Test 2", "Test 3"}; // when we actually implement this, maybe use a
        selectCategory = new JLabel("Choose a category");     // for loop or something on the mySQL table w/ addItem()
        startGame = new JButton("Start Game!");
        backButton = new JButton("Go Back");
        dropMenu = new JComboBox(categories);
        mainPanel = new JPanel(new GridLayout(4,1));

        selectCategory.setFont(new Font("Serif", Font.BOLD, 32));
        selectCategory.setHorizontalAlignment(SwingConstants.CENTER);
        selectCategory.setVerticalAlignment(SwingConstants.CENTER);

        mainPanel.add(selectCategory);
        mainPanel.add(dropMenu);
        mainPanel.add(startGame);
        mainPanel.add(backButton);

        add(mainPanel);

        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new gameModePanel());
            }
        });

        startGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new gamePanel("How much wood could a woodchuck chuck " +
                        "if a woodchuck could chuck wood","answer1","answer2",
                        "answer3","answer4","answer5"));
            }
        });
    }


}




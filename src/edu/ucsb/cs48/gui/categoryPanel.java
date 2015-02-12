package edu.ucsb.cs48.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class categoryPanel extends JPanel {
    //Java GUI Components

    JPanel mainPanel;
    JLabel selectCategory;
    JButton startGame;
    JButton backButton;
    JComboBox categoryMenu;


    public categoryPanel() {
        ArrayList<String> categories = new ArrayList<String>();
        categories.add("Sports");
        categories.add("UCSB");
        categories.add("Music");
        Collections.sort(categories);

        HashMap<String, Integer> catID= new HashMap<String, Integer>();
        catID.put("Sports", 1);
        catID.put("Music", 2);
        catID.put("UCSB", 3);


        selectCategory = new JLabel("Choose a category");
        startGame = new JButton("Start Game!");
        backButton = new JButton("Go Back");
        categoryMenu = new JComboBox(categories.toArray());
        mainPanel = new JPanel(new GridLayout(4,1));

        selectCategory.setFont(new Font("Serif", Font.BOLD, 32));
        selectCategory.setHorizontalAlignment(SwingConstants.CENTER);
        selectCategory.setVerticalAlignment(SwingConstants.CENTER);

        mainPanel.add(selectCategory);
        mainPanel.add(categoryMenu);
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
                //Main.game.setCategory(catID.get(categoryMenu.getSelectedItem()));
                triviaMain.setCurrentPanel(new gamePanel("How much wood could a woodchuck chuck " +
                        "if a woodchuck could chuck wood", "answer1", "answer2",
                        "answer3","answer4","answer5"));
            }
        });
    }


}




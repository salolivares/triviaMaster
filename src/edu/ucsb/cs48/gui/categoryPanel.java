package edu.ucsb.cs48.gui;

import edu.ucsb.cs48.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

/**
 * categoryPanel class that displays potential categories for user to choose from
 */

public class categoryPanel extends JPanel {
    //Java GUI Components

    JPanel mainPanel;
    JLabel selectCategory;
    JButton startGame;
    JButton backButton;
    JComboBox categoryMenu;
    JScrollPane scroller;

    /**
     * categoryPanel default constructor
     */

    public categoryPanel() {

        //fill up ArrayList with categories from database
        ArrayList<String> categories = Main.qa.getCategories();
        Collections.sort(categories);

        //fill up a HashMap with categories that map to their category ID
        final HashMap<String, Integer> catID= Main.qa.getHashMap();

        selectCategory = new JLabel("Choose a category");
        startGame = new JButton("Start Game!");
        backButton = new JButton("Go Back");
        categoryMenu = new JComboBox(categories.toArray());
        categoryMenu.setMaximumRowCount(5);
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
                Main.game.setCategory(catID.get(categoryMenu.getSelectedItem()));
                Main.game.resetGameScore();
                Main.gameThread = new Thread(Main.game);
                Main.gameThread.start();
            }
        });
    }


}




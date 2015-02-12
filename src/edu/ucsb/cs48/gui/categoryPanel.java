package edu.ucsb.cs48.gui;

import edu.ucsb.cs48.Main;
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

        //fill up ArrayList with categories from database
        ArrayList<String> categories = Main.qa.getCategories();
        Collections.sort(categories);

        //fill up a HashMap with categories that map to their category ID
        HashMap<String, Integer> catID= Main.qa.getHashMap();

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
                Main.gameThread.start();
            }
        });
    }


}




package edu.ucsb.cs48.gui;

import edu.ucsb.cs48.Main;
import edu.ucsb.cs48.util.QuestionAccess;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


/**
 * categoryPanel class that displays potential categories for user to choose from
 */

public class categoryPanel extends JPanel {

    //Java GUI Components
    JLabel selectCategory;
    JButton startGame;
    JButton backButton;
    JComboBox categoryMenu;
    JLabel background;
    GridBagConstraints gbc;

    /**
     * categoryPanel default constructor
     */

    public categoryPanel() {


        //load and add the background image
        background = new JLabel(new ImageIcon("assets/background.jpg"));
        background.setOpaque(false);
        background.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        setLayout(new BorderLayout());

        //fill up ArrayList with categories from database
        ArrayList<String> categories = QuestionAccess.getCategories();
        Collections.sort(categories);

        //fill up a HashMap with categories that map to their category ID
        final HashMap<String, Integer> catID= QuestionAccess.getHashMap();

        selectCategory = new JLabel("Choose a category");
        startGame = new JButton("Start Game!");
        backButton = new JButton("Go Back");
        categoryMenu = new JComboBox(categories.toArray());
        categoryMenu.setMaximumRowCount(5);


        selectCategory.setFont(new Font("Serif", Font.BOLD, 36));
        selectCategory.setHorizontalAlignment(SwingConstants.CENTER);
        selectCategory.setVerticalAlignment(SwingConstants.CENTER);

        // set up panel layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(25,0,50,0);
        background.add(selectCategory, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 100;
        gbc.ipady = 30;
        gbc.insets = new Insets(0,0,30,0);
        background.add(categoryMenu, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.insets = new Insets(0,0,0,0);
        background.add(startGame, gbc);
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.insets = new Insets(50,600,0,0);
        gbc.ipady = 30;
        gbc.ipadx = 30;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 3;
        background.add(backButton, gbc);


        add(background, BorderLayout.CENTER);

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




package edu.ucsb.cs48.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class shopPanel extends JPanel {
    //Java GUI components
    JButton backButton;
    JButton purchaseButton;
    JButton infoButton;
    JButton helpButton;
    JLabel mainTitle;
    JLabel pointsLabel;
    JTable itemsTable;
    JPanel topPanel;
    JPanel middlePanel;
    JPanel botPanel;
    JPanel midButtonPanel;
    JScrollPane tablePanel;
    GridBagConstraints gbc;

    public shopPanel(){
        //initialize Java Components
        backButton = new JButton("Back to menu");
        purchaseButton = new JButton("Purchase");
        infoButton = new JButton("Info");
        helpButton = new JButton("Help me");
        mainTitle = new JLabel("Trivia Shop");
        pointsLabel = new JLabel("You have # points"); // TODO: update this via DB
        botPanel = new JPanel(new BorderLayout());
        middlePanel = new JPanel(new GridBagLayout());
        midButtonPanel = new JPanel(new GridLayout(3,1));
        topPanel = new JPanel(new BorderLayout());
        gbc = new GridBagConstraints();

        //set layout manager for this panel
        setLayout(new BorderLayout());

        //set title and points label font properties
        mainTitle.setFont(new Font("Serif", Font.BOLD, 48));

        //add components to top panel
        topPanel.add(mainTitle, BorderLayout.NORTH);
        topPanel.add(pointsLabel,BorderLayout.CENTER);

        //configure middle components

        //table set up
        String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};
        Object[][] data = {
                {"Kathy", "Smith",
                        "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown",
                        "Pool", new Integer(10), new Boolean(false)}
        };

        itemsTable = new JTable(data,columnNames);
        tablePanel = new JScrollPane(itemsTable);
        itemsTable.setFillsViewportHeight(true);

        //button set up
        midButtonPanel.add(purchaseButton);
        midButtonPanel.add(infoButton);
        midButtonPanel.add(helpButton);

        //add components to middle panel
        gbc.gridx = 0;
        middlePanel.add(tablePanel);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        middlePanel.add(midButtonPanel);

        //add components to bot panel
        botPanel.add(backButton);

        //add panels to this panel
        add(topPanel, BorderLayout.NORTH);
        add(middlePanel,BorderLayout.CENTER);
        add(botPanel,BorderLayout.PAGE_END);

        /** Event manager **/
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new mainMenuPanel());
            }
        });

    }

}

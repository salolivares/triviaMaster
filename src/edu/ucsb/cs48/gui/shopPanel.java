package edu.ucsb.cs48.gui;

import edu.ucsb.cs48.Main;
import edu.ucsb.cs48.gui.guiUtils.ForcedListSelectionModel;

import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * shopPanel class where users can buy power ups using their earned points
 */
public class shopPanel extends JPanel {
    //Java GUI components
    JButton backButton;
    JButton purchaseButton;
    JButton infoButton;
    JLabel mainTitle;
    JLabel pointsLabel;
    JTable itemsTable;
    JPanel topPanel;
    JPanel middlePanel;
    JPanel botPanel;
    JPanel midButtonPanel;
    JScrollPane tablePanel;
    GridBagConstraints gbc;
    JFrame dialogFrame;
    URL url;
    AudioClip sound;


    // table properties
    String[] columnNames = {"Item",
            "Cost",
            "# you own",};
    Object[][] tableData = {
            {"Auto Answer", "10 Points",
                    Main.shop.numberOfAutoAnswer(Main.player.getUsername()), new Integer(10)},
            {"Bomb", "5 Points",
                    Main.shop.numberOfQuestionEliminator(Main.player.getUsername()), new Integer(5)}
    };

    public shopPanel(){
        //initialize Java Components
        backButton = new JButton("Back to menu");
        purchaseButton = new JButton("Purchase");
        infoButton = new JButton("Info");
        mainTitle = new JLabel("Trivia Shop");
        pointsLabel = new JLabel("You have " + Main.player.getPoints() + " points");
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
        topPanel.add(pointsLabel, BorderLayout.CENTER);

        //configure middle components

        //table set up
        itemsTable = new JTable(tableData,columnNames);
        tablePanel = new JScrollPane(itemsTable);
        itemsTable.setFillsViewportHeight(true);
        itemsTable.setSelectionModel(new ForcedListSelectionModel());

        //button set up
        midButtonPanel.add(purchaseButton);
        midButtonPanel.add(infoButton);

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

        /**
         * Go back to main menu if this button is hit
         */
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new mainMenuPanel());
            }
        });

        purchaseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //whenever the user hits this button,
                //make a sound
                try {
                    url = new URL("file:assets/coin.wav");
                }
                catch (MalformedURLException es) {
                    es.printStackTrace();
                }

                sound = java.applet.Applet.newAudioClip(url);
                sound.play();

                /**
                 * itemsTable.getSelectedRow:
                 * Returns the index of the row selected
                 * Returns -1 if user selected no row
                 */
                purchaseHelper(itemsTable.getSelectedRow());

                //refresh shop panel
                triviaMain.setCurrentPanel(new shopPanel());
            }
        });

        /**
         * When user hits this button, display information about the power ups
         */
        infoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                JOptionPane.showMessageDialog(dialogFrame, "Autoanswer - Automatically Answer Question for you\n" +
                        "Bomb - Highlights 2 wrong answers for you"
                        , "Item Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

    }

    /**
     * purchaseHelper method that lets user purchase items
     * @param index the index of the item the user wishes to purchase
     */
    private void purchaseHelper(int index){
        /**
         * Display error message if user did not select a item to purchase
         */
        if(index == -1 ){
            JOptionPane.showMessageDialog(dialogFrame, "Please select an item to purchase",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            String dialogMessage;
            String titleMessage;
            int points = Main.player.getPoints();
            int powerupValue = (Integer)tableData[index][3];
            int messageIcon;

            /**
             * Display error message if user does not have enough points
             * to purchase the powerup
             */
            if(points < powerupValue){
                dialogMessage = "Not Enough Points to purchase";
                titleMessage = "Purchase Unsuccessful";
                messageIcon = JOptionPane.ERROR_MESSAGE;
            }

            else {
                /**
                 * Deduct points from user profile depending on power up selected
                 */
                if(index == 0){
                    Main.shop.increaseNumberOfAutoAnswer(Main.player.getUsername());
                    Main.player.modifyPoints(-10);
                }
                else{
                    Main.shop.increaseNumberOfQuestionEliminator(Main.player.getUsername());
                    Main.player.modifyPoints(-5);
                }
                dialogMessage = String.format("You purchased %s", tableData[index][0]);
                titleMessage = "Purchase Successful";
                messageIcon = JOptionPane.INFORMATION_MESSAGE;
            }
            JOptionPane.showMessageDialog(dialogFrame, dialogMessage, titleMessage, messageIcon);
        }
    }

}

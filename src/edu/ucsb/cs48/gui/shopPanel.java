package edu.ucsb.cs48.gui;

import edu.ucsb.cs48.gui.guiUtils.ForcedListSelectionModel;
import edu.ucsb.cs48.gui.guiUtils.tableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    JFrame dialogFrame;

    // table properties
    String[] columnNames = {"Item",
            "Cost",
            "# you own",};
    Object[][] data = {
            {"Auto Answer", "30 Points",
                    new Integer(20)},
            {"Some cool category", "20 Points",
                    new Integer(20)},
            {"null", "100 Points",
                    new Integer(0)},
            {"null", "300 Points",
                    new Integer(20)},
            {"null", "400 Points",
                    new Integer(20)}
    };

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
        itemsTable = new JTable(data,columnNames);
        tablePanel = new JScrollPane(itemsTable);
        itemsTable.setFillsViewportHeight(true);
        itemsTable.setSelectionModel(new ForcedListSelectionModel());

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

        purchaseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                purchaseHelper(itemsTable.getSelectedRow());
            }
        });

    }

    private void purchaseHelper(int index){
        if(index == -1 ){
            JOptionPane.showMessageDialog(dialogFrame, "Please select an item to purchase",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            String dialogMessage;
            dialogMessage = String.format("You purchased %s",data[index][0]);
            JOptionPane.showMessageDialog(dialogFrame, dialogMessage, "Purchase Successful",JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
